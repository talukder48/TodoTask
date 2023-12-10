package pkg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pkg.ServiceImp.DataConnection;
import pkg.model.Task;

public class TaskDao {
	private static final String select_all = "select * from tasks";
	private static final String select_By_ID = "select * from tasks where taskId=?";
	private static final String Insert_into = "INSERT INTO `tasks`(`taskId`, `task_description`, `assigned_persion`, `issue_date`, `task_status`) VALUES (?,?,?,?,?)";
	private static final String Update_By_ID = "UPDATE `tasks` SET `task_description`=?,`assigned_persion`=?,`issue_date`=?,`task_status`=? WHERE taskId=? ";
	private static final String Delete_By_ID = "DELETE FROM `tasks` WHERE `taskId`=?";
	private static final String MaxID = "SELECT nvl(max(taskId),0)+1 FROM `tasks` ";

	private DataConnection connectionObj = new DataConnection();

	public boolean deleteUser(int taskId) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = connectionObj.OpenConnection();
				PreparedStatement statement = connection.prepareStatement(Delete_By_ID);) {
			statement.setInt(1, taskId);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public List<Task> GetAllTask() {
		List<Task> TaskList = new ArrayList<Task>();
		Connection Datasource = connectionObj.OpenConnection();
		try {
			PreparedStatement preparedStatement = Datasource.prepareStatement(select_all);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				TaskList.add(new Task(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getDate(4), resultSet.getString(5)));
			}
			connectionObj.closeConnection(Datasource);
		} catch (Exception e) {

		}
		return TaskList;
	}

	public Task GetTaskByID(int taskId) {
		Task taskObj = null;
		;
		Connection Datasource = connectionObj.OpenConnection();
		try {
			PreparedStatement preparedStatement = Datasource.prepareStatement(select_By_ID);
			preparedStatement.setInt(1, taskId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				taskObj = new Task(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getDate(4), resultSet.getString(5));
			}
			connectionObj.closeConnection(Datasource);
		} catch (Exception e) {

		}
		return taskObj;
	}

	public int GetMaxID() {
		int taskID = 0;
		Connection Datasource = connectionObj.OpenConnection();
		try {
			PreparedStatement preparedStatement = Datasource.prepareStatement(MaxID);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				taskID = resultSet.getInt(1);
			}
			connectionObj.closeConnection(Datasource);
		} catch (Exception e) {

		}
		return taskID;
	}

	public void InsertTask(Task task) throws SQLException {
		System.out.println(Insert_into);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = connectionObj.OpenConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Insert_into)) {
			preparedStatement.setInt(1, task.getTaskId());
			preparedStatement.setString(2, task.getTaskDescription());
			preparedStatement.setString(3, task.getAssignedPerson());
			preparedStatement.setDate(4, task.getIssueDate());
			preparedStatement.setString(5, task.getTaskStatus());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
		}
	}

	public boolean UpdateTask(Task task) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = connectionObj.OpenConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Update_By_ID);) {

			preparedStatement.setString(1, task.getTaskDescription());
			preparedStatement.setString(2, task.getAssignedPerson());
			preparedStatement.setDate(3, task.getIssueDate());
			preparedStatement.setString(4, task.getTaskStatus());
			preparedStatement.setInt(5, task.getTaskId());
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}
