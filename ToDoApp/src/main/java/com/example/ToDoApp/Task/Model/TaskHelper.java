package com.example.ToDoApp.Task.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskHelper {
    private int taskId;
    private int userId;
    private Task task;

    public TaskHelper(int userId, Task task) {
        this.userId = userId;
        this.task = task;
    }
    public TaskHelper(int userId,int taskId) {
        this.taskId = taskId;
        this.userId = userId;
    }
}
