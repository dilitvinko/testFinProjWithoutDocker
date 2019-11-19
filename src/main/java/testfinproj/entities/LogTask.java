package testfinproj.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class LogTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Task task;
    private int time;
    @NotBlank(message = "Please fill")
    @Length(max = 255, message = "too long")
    private String comment;

    public LogTask() {
    }

    public LogTask(Task task, int time, String comment) {
        this.task = task;
        this.time = time;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
