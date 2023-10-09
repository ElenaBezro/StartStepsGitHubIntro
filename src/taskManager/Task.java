package taskManager;

public class Task implements Taskable {
    private String title;
    private String description;
    private String priority;

    //TODO: use Enum for status
    private String status;

    public Task(String title, String description, String priority, String status) throws EmptyFieldsException {
        if (title.trim().equals("") ||
                description.trim().equals("") ||
                priority.trim().equals("") ||
                status.trim().equals("")) {
            throw new EmptyFieldsException("Empty values are not allowed");
        }
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public void setTitle(String title) {
        if (title.trim().equals("")) {
            System.out.println("Empty values are not allowed");
            return;
        }
        this.title = title;
    }

    public void setDescription(String description) {
        if (description.trim().equals("")) {
            System.out.println("Empty values are not allowed");
            return;
        }
        this.description = description;
    }

    public void setPriority(String priority) {
        if (priority.trim().equals("")) {
            System.out.println("Empty values are not allowed");
            return;
        }
        this.priority = priority;
    }

    public void setStatus(String status) {
        if (status.trim().equals("")) {
            System.out.println("Empty values are not allowed");
            return;
        }
        this.status = status;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getPriority() {
        return this.priority;
    }

    public String getStatus() {
        return this.status;
    }

    @Override
    public void changeStatus(String newStatus) {
        setStatus(newStatus);
    }

    @Override
    public void editTask(String title, String description, String priority) {
        setTitle(title);
        setDescription(description);
        setPriority(priority);
    }

    @Override
    public String toString() {
        StringBuilder taskInfo = new StringBuilder();
        taskInfo.append(getTitle())
                .append(", ")
                .append(getDescription())
                .append(", ")
                .append(getPriority())
                .append(", ")
                .append(getStatus());
        return taskInfo.toString();
    }
}
