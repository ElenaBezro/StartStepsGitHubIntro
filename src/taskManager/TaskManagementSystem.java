package taskManager;

public class TaskManagementSystem {
    private UserInterface ui = new UserInterface();
    public void startApp() {
            ui.startUI();
    }

    public static void main(String[] args) {
        TaskManagementSystem taskApp = new TaskManagementSystem();
        taskApp.startApp();
    }
}
