package Day10;

import java.util.ArrayList;
import java.util.List;

/*
Task Management Application: 
Create classes for Task, Project, and User10. 
Implement methods for adding tasks and tracking progress.
*/

// Enum representing the status of a Task
enum TaskStatus {
    NOT_STARTED,
    IN_PROGRESS,
    COMPLETED
}

// Class representing a Task
class Task {
    private String title;
    private String description;
    private TaskStatus status;
    private int priority; // Priority level (1-5)

    public Task(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.status = TaskStatus.NOT_STARTED; // Default status
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public int getPriority() {
        return priority;
    }

    public void startTask() {
        status = TaskStatus.IN_PROGRESS;
    }

    public void completeTask() {
        status = TaskStatus.COMPLETED;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                '}';
    }
}

// Class representing a Project
class Project {
    private String name;
    private List<Task> tasks;

    public Project(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added: " + task.getTitle());
    }

    public void trackProgress() {
        int totalTasks = tasks.size();
        int completedTasks = 0;

        for (Task task : tasks) {
            if (task.getStatus() == TaskStatus.COMPLETED) {
                completedTasks++;
            }
        }

        System.out.println("Project: " + name);
        System.out.println("Total Tasks: " + totalTasks);
        System.out.println("Completed Tasks: " + completedTasks);
        System.out.println("Progress: " + (totalTasks > 0 ? (completedTasks * 100 / totalTasks) + "%" : "No tasks available"));
    }

    public List<Task> getTasks() {
        return tasks;
    }
}

// Class representing a User10
class User10 {
    private String User10name;
    private List<Project> projects;

    public User10(String User10name) {
        this.User10name = User10name;
        this.projects = new ArrayList<>();
    }

    public String getUser10name() {
        return User10name;
    }

    public void addProject(Project project) {
        projects.add(project);
        System.out.println("Project added: " + project.getName());
    }

    public List<Project> getProjects() {
        return projects;
    }
}

// Class for managing tasks
class TaskManager {
    public static void main(String[] args) {
        // Create a User10
        User10 User10 = new User10("Alice");

        // Create a project
        Project project = new Project("Website Development");
        User10.addProject(project);

        // Create tasks
        Task task1 = new Task("Design Homepage", "Create the homepage layout", 3);
        Task task2 = new Task("Develop Backend", "Set up the server and database", 5);
        Task task3 = new Task("Write Documentation", "Document the project", 2);

        // Add tasks to the project
        project.addTask(task1);
        project.addTask(task2);
        project.addTask(task3);

        // Start and complete some tasks
        task1.startTask();
        task2.completeTask();

        // Track progress of the project
        project.trackProgress();
    }
}
