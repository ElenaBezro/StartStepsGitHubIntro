package taskManager;

public interface Taskable {
    void changeStatus(String newStatus);
    void editTask(String title, String description, String priority);
}
