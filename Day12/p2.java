package Day12;

import java.util.ArrayList;
import java.util.List;

/*
 12. Task Management System
Description: A task management system that allows users to add tasks, 
mark them as complete, and view pending tasks.
 */
//Interface for Task Operations
interface TaskOperations {
 void addTask(String task);
 void completeTask(String task);
 void viewTasks();
}

//Class representing a Task Manager
class TaskManager implements TaskOperations {
 private List<String> tasks = new ArrayList<>();
 private List<String> completedTasks = new ArrayList<>();

 @Override
 public void addTask(String task) {
     tasks.add(task);
     System.out.println("Added task: " + task);
 }

 @Override
 public void completeTask(String task) {
     if (tasks.remove(task)) {
         completedTasks.add(task);
         System.out.println("Completed task: " + task);
     } else {
         System.out.println("Task not found.");
     }
 }

 @Override
 public void viewTasks() {
     System.out.println("Pending Tasks: " + tasks);
     System.out.println("Completed Tasks: " + completedTasks);
 }
}

//Main class to test the Task Management System
public class p2 {
 public static void main(String[] args) {
     TaskManager manager = new TaskManager();
     manager.addTask("Finish report");
     manager.addTask("Attend meeting");
     manager.completeTask("Finish report");
     manager.viewTasks();
 }
}
