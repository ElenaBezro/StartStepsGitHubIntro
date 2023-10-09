package taskManager;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> taskList = new ArrayList<>();

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void removeTask(String title) {
        boolean isRemoved = taskList.removeIf(task -> {
            return task.getTitle().equals(title);
        });

        String message = isRemoved ? "Task removed" : "Invalid title input";
        System.out.println(message);

        //Another implementation:
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
            //TODO: implement using join()
            //System.out.println(task.toString());
           list.append(task.toString()).append(System.lineSeparator());
        }
        System.out.println(list);
    }

    public int editTask(String oldTitle, String title, String description, String priority) {
        // TODO: This code will change all tasks with the same title ==> we need to somehow create unique tasks (uuid?)
        int count = 0;
        for (Task task: taskList) {
            if (task.getTitle().equals(oldTitle)) {
                task.editTask(title, description, priority);
                count++;
            }
        }
        return count;
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

    public boolean containsTask(String title){
        for(Task task: taskList) {
            if (task.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }
}
