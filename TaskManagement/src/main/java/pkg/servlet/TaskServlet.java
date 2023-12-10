package pkg.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.dao.TaskDao;
import pkg.model.Task;

@WebServlet("/")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String url = request.getServletPath();
		try {
			switch (url) {
			case "/IssueList":
				IssueList(request, response);
				break;
			case "/IssueForm":
				IssueForm(request, response);
				break;
			case "/CreateIssue":
				SaveNewIssue(request, response);
				break;
			case "/IssueEditForm":
				IssueEditForm(request, response);
				break;
			case "/IssueModify":
				IssueModify(request, response);
				break;
			case "/IssueDelete":
				DeleteIssue(request, response);
				break;
			default:
				IssueList(request, response);
				break;
			}

		} catch (Exception e) {

		}
	}

	TaskDao TaskDao = new TaskDao();

	void IssueList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Task> TaskList = TaskDao.GetAllTask();
		request.setAttribute("TaskList", TaskList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("task-list.jsp");
		dispatcher.forward(request, response);
	}

	private void IssueForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("task-form.jsp");
		dispatcher.forward(request, response);
	}

	private void IssueEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("update-task.jsp");
		Task taskObj = TaskDao.GetTaskByID(taskId);
		request.setAttribute("task", taskObj);
		dispatcher.forward(request, response);

	}

	private void SaveNewIssue(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String taskDescription = request.getParameter("taskDescription");
		String assignedPerson = request.getParameter("assignedPerson");
		Date issueDate = Date.valueOf(request.getParameter("issueDate"));
		Task TaskObj = new Task(TaskDao.GetMaxID(), taskDescription, assignedPerson, issueDate, "Pending");
		TaskDao.InsertTask(TaskObj);
		System.out.println(TaskObj.toString());
		response.sendRedirect("IssueList");
	}

	private void IssueModify(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		String taskDescription = request.getParameter("taskDescription");
		String assignedPerson = request.getParameter("assignedPerson");
		Date issueDate = Date.valueOf(request.getParameter("issueDate"));

		Task TaskObj = new Task(taskId, taskDescription, assignedPerson, issueDate, "Pending");
		TaskDao.UpdateTask(TaskObj);

		System.out.println(TaskObj.toString());
		response.sendRedirect("IssueList");
	}

	private void DeleteIssue(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		System.out.println(taskId);
		TaskDao.deleteUser(taskId);
		response.sendRedirect("IssueList");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
