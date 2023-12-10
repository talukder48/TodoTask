package pkg.model;

import java.sql.Date;

public class Task {
	private int taskId;
	private String taskDescription;
	private String assignedPerson;
	private Date issueDate;
	private String taskStatus;
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(int taskId, String taskDescription, String assignedPerson, Date issueDate, String taskStatus) {
		super();
		this.taskId = taskId;
		this.taskDescription = taskDescription;
		this.assignedPerson = assignedPerson;
		this.issueDate = issueDate;
		this.taskStatus = taskStatus;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public String getAssignedPerson() {
		return assignedPerson;
	}
	public void setAssignedPerson(String assignedPerson) {
		this.assignedPerson = assignedPerson;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskDescription=" + taskDescription + ", assignedPerson=" + assignedPerson
				+ ", issueDate=" + issueDate + ", taskStatus=" + taskStatus + "]";
	}
	
	
}
