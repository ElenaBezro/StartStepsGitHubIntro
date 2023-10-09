package taskManager;

import java.util.*;

public class UserInterface {
    Scanner sc = new Scanner(System.in);
    TaskList taskList;
    public static final String[] TASK_FIELDS = {"title", "description", "priority", "status"};
    public static final String[] TASK_FIELDS_OMIT_STATUS = Arrays.copyOf(TASK_FIELDS, TASK_FIELDS.length - 1);


    public UserInterface(TaskList taskList) {
        this.taskList = taskList;
    }

    public void startUI() {
        while (true) {
            printCommandOptions();
            handleInput();
        }
    }

    public void printCommandOptions() {
        System.out.println("Select command you would like to implement from following:");
        System.out.println("1 - add Task");
        System.out.println("2 - edit Task");
        System.out.println("3 - remove Task");
        System.out.println("4 - print Tasks List");
        System.out.println("5 - change task status");
        System.out.println("exit - exit the application");
    }

    public void handleInput() {
        // TODO: implement map with handlers
        String command = sc.nextLine();
        switch (command) {
            case "1":
                addTask();
                break;
            case "2":
                editTask();
                break;
            case "3":
                removeTask();
                break;
            case "4":
                printTasksList();
                break;
            case "5":
                changeStatus();
                break;
            case "exit":
                exit();
                break;
            default:
                System.out.println("Invalid command");
        }
    }

    public void addTask() {
        List<String> taskFieldValues = new ArrayList<String>(TASK_FIELDS.length);
        for (String field : TASK_FIELDS) {
            while (true) {
                System.out.println(String.format("Enter task %s: ", field));
                var input = sc.nextLine();
                if (!input.trim().equals("")) {
                    taskFieldValues.add(input);
                    break;
                }
            }
        }

        try {
            Task task = new Task(taskFieldValues.get(0),
                    taskFieldValues.get(1),
                    taskFieldValues.get(2),
                    taskFieldValues.get(3));
            taskList.addTask(task);
        } catch (EmptyFieldsException e) {
            System.out.println(e.toString());
        }
    }

    public void editTask() {
        System.out.println("Enter title of the task that you want to change: ");
        String oldTitle = sc.nextLine();

        boolean isContaines = taskList.containsTask(oldTitle);
        if (!isContaines) {
            System.out.println("Invalid title input");
            return;
        }

        List<String> newTaskFieldValues = new ArrayList<>(TASK_FIELDS_OMIT_STATUS.length);
        for (String field : TASK_FIELDS_OMIT_STATUS) {
            while (true) {
                System.out.println(String.format("Enter new task %s: ", field));
                var input = sc.nextLine();
                if (!input.trim().equals("")) {
                    newTaskFieldValues.add(input);
                    break;
                }
            }
        }

        int editedTasksCount = taskList.editTask(oldTitle,
                newTaskFieldValues.get(0),
                newTaskFieldValues.get(1),
                newTaskFieldValues.get(2));
        String message =  (editedTasksCount > 0) ? "Task edited" : "Failed";
        System.out.println(message);
    }

    public void removeTask() {
        System.out.println("Enter title of the task that you want to remove: ");
        String title = sc.nextLine();

        taskList.removeTask(title);
    }

    public void printTasksList() {
        taskList.printTasks();
    }

    public void changeStatus() {
        System.out.println("Enter the title of the task whose status you want to change: ");
        String title = sc.nextLine();

        System.out.println("Enter new task status: ");
        String status = sc.nextLine();

        taskList.changeStatus(title, status);
    }

    public void exit() {
        sc.close();
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
