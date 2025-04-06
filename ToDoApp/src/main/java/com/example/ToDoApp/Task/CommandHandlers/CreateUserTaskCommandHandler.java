package com.example.ToDoApp.Task.CommandHandlers;

import com.example.ToDoApp.Command;
import com.example.ToDoApp.Task.Model.Task;
import com.example.ToDoApp.Task.Model.TaskHelper;
import com.example.ToDoApp.Task.TaskRepository;
import com.example.ToDoApp.User.Model.User;
import com.example.ToDoApp.User.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateUserTaskCommandHandler  implements Command<TaskHelper,Void> {
    private UserRepository userRepository;
    private TaskRepository taskRepository;
    public CreateUserTaskCommandHandler(TaskRepository taskRepository,UserRepository userRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }
    @Override
    public ResponseEntity execute(TaskHelper task) {
    User user = userRepository.findById(task.getUserId()).get();
    if (user == null) {
        return ResponseEntity.notFound().build();
    }
        Task taskToAdd = task.getTask();
        taskToAdd.setUser(user);
        taskRepository.save(taskToAdd);
        return ResponseEntity.ok().body(task.getTask()+" ; "+ task.getUserId()+" ; " +task.getTaskId());
    }
}
