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
public class DeleteUserTaskCommandHandler implements Command<TaskHelper,Void> {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    public DeleteUserTaskCommandHandler(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }
    @Override
    public ResponseEntity execute(TaskHelper entity) {
        User user = userRepository.findById(entity.getUserId()).get();
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        Task task = taskRepository.findById(entity.getTaskId()).get();
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        if (task.getUser().getId() != user.getId()) {
            return ResponseEntity.badRequest().build();
        }
        taskRepository.delete(task);
        return ResponseEntity.ok().body("Task deleted successfully");
    }
}
