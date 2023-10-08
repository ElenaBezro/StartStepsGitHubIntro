package taskManager;

public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        UserInterface userInterface = new UserInterface(taskList);
        userInterface.startUI();
    }
}
