package com.example.ToDoApp.Task.Model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskDTO {
    String taskName;
    String taskDescription;
    public TaskDTO(Task task) {
        this.taskName = task.getTaskName();
        this.taskDescription = task.getTaskDescription();
    }
}
