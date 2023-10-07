package taskManager;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> taskList = new ArrayList<>();

    public void addTask(Task task) {
        taskList.add(task);
    }

    //Why pass whole Task? mb pass only title
    public void removeTask(String title) {
        boolean isRemoved = taskList.removeIf(task -> {
            return task.getTitle().equals(title);
        });

        String message = isRemoved ? "Task removed" : "Invalid title input";
        System.out.println(message);

        //Another implementation
//        var tasksToRemove = new ArrayList<Task>();
//        for (Task task: taskList) {
//            if (task.getTitle().equals(title)) {
//                tasksToRemove.add(task);
//            }
//        }
//        taskList.removeAll(tasksToRemove);

    }

    public void printTasks() {
        StringBuilder list = new StringBuilder();
        for (Task task: taskList) {
           list.append(task.toString()).append(System.lineSeparator());
        }
        System.out.println(list);
    }

    public void editTask(String oldTitle, String title, String description, String priority) {
        // This code will change all tasks with the same title ==> we need to somehow create unique tasks (uuid?)
        int count = 0;
        for (Task task: taskList) {
            if (task.getTitle().equals(oldTitle)) {
                task.editTask(title, description, priority);
                count++;
            }
        }
        String message =  (count != 0) ? "Task edited" : "Invalid title input";
        System.out.println(message);
    }
    public void changeStatus(String title, String status) {
        int count = 0;
        for (Task task: taskList) {
            if (task.getTitle().equals(title)) {
                task.changeStatus(status);
                count++;
            }
        }
        String message =  (count != 0) ? "Status changed" : "Invalid title input";
        System.out.println(message);
    }
}
