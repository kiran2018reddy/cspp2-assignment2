import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for task.
 */

 /**Create a class named Task with its 6 properties. Add an overloaded constructor with the
parameters String title, String assignedTo, int timeToComplete, boolean important, boolean
urgent, String status. Also, add a toString method to display the Task object.
The first 3 test case files input000, input001, input002 must pass for the 2 marks to be awarded.
Main method is already provided and handles the input and output.*/
class Task {
	String title;
	String assignedTo;
	int timeToComplete;
	boolean important;
	boolean urgent;
	String status;


	/**Check for errors in the values set for the properties of the Task object. The error validation
should be performed in the constructor. In case of error, constructor should throw an Exception
with an error message. There are 3 validations to be performed.
1. Task title should not be empty
2. Time required to complete the task should be non negative value
3. Task status should be either todo or done and can’t have any other value.
The error messages for the above validations are:
1. Title not provided
2. Invalid timeToComplete <time value>
3. Invalid status <status value>
3 test case files input003, input004, input005 must pass for the 2 marks to be awarded. Main
method is already provided and handles the input and output.*/
	
	Task(String title, String assignedTo, int timeToComplete, boolean important,
	     boolean urgent, String status) throws Exception {
		if (title == null || title.equals("")) throw new Exception("Title not provided");
		if (!status.equals("todo") && !status.equals("done")) throw new Exception("Invalid status " + status);
		if (timeToComplete < 0) throw new Exception("Invalid timeToComplete " + timeToComplete);
		this.title = title;
		this.assignedTo = assignedTo;
		this.timeToComplete = timeToComplete;
		this.important = important;
		this.urgent = urgent;
		this.status = status;
	}
	public String toString() {
		String a = "Not Important";
		String b = "Not Urgent";
		if(important) a = "Important";
		if(urgent) b = "Urgent";
		String display = title + ", " + assignedTo+", "+ timeToComplete+", "+ a+", "+ b+", "+ status;
		return display;
	}
}