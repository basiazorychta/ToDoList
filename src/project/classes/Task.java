package project.classes;

import java.util.Date;

public class Task {

    private int id;
    private String heading;
    private Date datetime;
    private boolean completed;
    private String description;

    public Task(int id, String heading, Date datetime, boolean completed, String description) {
        this.id = id;
        this.heading = heading;
        this.datetime = datetime;
        this.completed = completed;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Date getDate() {
        return datetime;
    }

    public void setDate(Date datetime) {
        this.datetime = datetime;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", \n heading='" + heading + '\'' +
                ", \n date time=" + datetime +
                ", \n completed=" + completed +
                ", \n description='" + description + '\'' +
                '}';
    }
}
