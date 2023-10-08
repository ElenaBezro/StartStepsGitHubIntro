package taskManager;

public class Task implements Taskable {
    private String title;
    private String description;
    private String priority;

    //TODO: use Enum for status
    private String status;

    public Task(final String title, final String description, final String priority, final String status) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public void setTitle(final String title) {
        if (title.equals("")) {
            System.out.println("Empty values are not allowed");
            return;
        }
        this.title = title;
    }

    public void setDescription(final String description) {
        if (description.equals("")) {
            System.out.println("Empty values are not allowed");
            return;
        }
        this.description = description;
    }

    public void setPriority(final String priority) {
        if (priority.equals("")) {
            System.out.println("Empty values are not allowed");
            return;
        }
        this.priority = priority;
    }

    public void setStatus(final String status) {
        if (status.length() > 1) {
            this.status = status;
            return;
        }
        System.out.println("Status should contain at least 2 characters");    }

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
