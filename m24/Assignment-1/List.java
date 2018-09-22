import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */
/**
 * Class for todoist.
 */

/**Create a class called Todoist. It should have an array of the type Task to store the Task objects.
The constructor of the Todoist should initialize the array. Add a public method add that takes a
Task object as a parameter. The add method should add the given task object to the array. If
the array is full then resize the array.
Add a toString method to the Todoist class to print the list of all the tasks. The print format is
one task per line. For each task print its title, name of the person, time to complete, Important or
Not Important, Urgent or Not Urgent, task status i.e, todo or done.
2 test case files input006, input007 must pass for the 2 marks to be awarded. Main method is
already provided and handles the input and output.*/

class Todoist {
    Task[] tasks;
    int size;
    Todoist() {
        tasks = new Task[10];
        size = 0;
    }
    public void addTask(Task task) {
        try {
            tasks[size] = task;
            size++;
        } catch (Exception e) {
            resize();
            addTask(task);
        }

    }
    void resize() {
        tasks = Arrays.copyOf(tasks, 2 * size);
    }

 /**  Add a public method getNextTask with a String parameter and Task object as return type. The
parameter is the name of the person. The goal of this method is to return the next task todo for
the person given in the parameter. There are two criteria for a task to qualify as the next task.
1. The task should be assigned to the given person, status of the task should be todo, it
should be important and not urgent. There could be multiple tasks that qualify this
criteria. Return the first task in the list that matches. If there are no such tasks then look
for the next point.
2. The task should be assigned to the given person, status of the task should be todo, it
should be important and urgent. Again, there could be multiple tasks that qualify this
criteria. Return the first task in the list that matches.
3. If there are no such tasks then return null.
2 test case files input008, input009 must pass for the 2 marks to be awarded. Main method is
already provided and handles the input and output.*/

    public Task getNextTask(String name) {
        for (int i = 0; i < size; i++) {
            if (tasks[i].assignedTo.equals(name) && tasks[i].status.equals("todo")) {
                if (tasks[i].important && !tasks[i].urgent) {
                    return tasks[i];
                }
            }
        }
        return null;
    }

   /** Add a public overloaded method getNextTask with a String parameter and a integer parameter.
String parameter is the name of the person and int parameter is the count of tasks. Return
should be an array of type Task and the size of the return array should be count (i.e., passed as
an argument to the method). The goal of this method is similar to the one in Question 4 with a
simple extension to return not just one next task but count number of next tasks for the given
person.
Test case file input010 must pass for the 1 mark to be awarded. Main method is already
provided and handles the input and output.*/
    public Task[] getNextTask(String name, int n) {
        Task[] getTasks = new Task[n];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (tasks[i].assignedTo.equals(name) && tasks[i].status.equals("todo")) {
                if (tasks[i].important && !tasks[i].urgent) {
                    getTasks[index] = tasks[i];
                    index++;
                    if (index == n) break;
                }
            }
        }
        return getTasks;
    }

   /** Add a public method totalTime4Completion that returns an int. The goal of the method is to add
up all the time to complete properties of the tasks that are todo and return the total.
Test case files input011, input012, input013 must pass for the 1 mark to be awarded. Main
method is already provided and handles the input and output.*/
    public int totalTime4Completion() {
        int totalTime = 0;
        for (int i = 0; i < size; i++) {
            if (tasks[i].status.equals("todo")) totalTime += tasks[i].timeToComplete;
        }
        return totalTime;
    }
    public String toString() {
        String display = "";
        for (int i = 0; i < size; i++) {
           String a= "Not Important";
            String b = "Not Urgent";
            if (tasks[i].important) a = "Important";
            if (tasks[i].urgent) b = "Urgent";
            display += tasks[i].title + ", " + tasks[i].assignedTo + ", " + tasks[i].timeToComplete + ", " + a + ", "+
            b + ", " + tasks[i].status + "\n";

        }
        return display;
    }
}