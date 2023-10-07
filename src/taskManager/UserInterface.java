package taskManager;

import java.util.Scanner;

public class UserInterface {
    Scanner sc = new Scanner(System.in);
    TaskList taskList = new TaskList();

    public void startUI(){
        while(true){
            printCommandOptions();
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
        handleInput();
    }

    public void handleInput() {
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
        boolean isEmptyInput = true;
        String[] taskFields = {"title", "description", "priority", "status"};
        String[] taskArr =  new String[4];
        int i = 0;
        for (String field: taskFields) {
            String input = "";
            while (isEmptyInput) {
                System.out.println(String.format("Enter task %s: ", field));
                input = sc.nextLine();
                isEmptyInput = input.equals("");
            }
            isEmptyInput = true;
            taskArr[i] = input;
            i++;
        }

        Task task = new Task(taskArr[0], taskArr[1], taskArr[2], taskArr[3]);
        taskList.addTask(task);
    }

    public void editTask() {
        System.out.println("Enter title of the task that you want to change: ");
        String oldTitle = sc.nextLine();

        System.out.println("Enter new task title: ");
        String title = sc.nextLine();
        System.out.println("Enter new task description: ");
        String description = sc.nextLine();
        System.out.println("Enter new task priority: ");
        String priority = sc.nextLine();

        taskList.editTask(oldTitle, title, description, priority);
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
