package com.example.ToDoApp.Task.CommandHandlers;

import com.example.ToDoApp.Command;
import com.example.ToDoApp.Task.Model.Task;
import com.example.ToDoApp.Task.Model.TaskHelper;
import com.example.ToDoApp.Task.TaskRepository;
import com.example.ToDoApp.User.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserTaskCommandHandler implements Command<TaskHelper,String> {
   private TaskRepository taskRepository;
   private UserRepository userRepository;
   public UpdateUserTaskCommandHandler(TaskRepository taskRepository, UserRepository userRepository) {
       this.taskRepository = taskRepository;
       this.userRepository = userRepository;
   }

    @Override
    public ResponseEntity<String> execute(TaskHelper entity) {
        int taskId = entity.getTaskId();
        int userId = entity.getUserId();
        Task task = entity.getTask();
        Task task1 = taskRepository.findById(taskId).get();
        if (task1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (task1.getUser().getId() != userId) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        task.setUser(userRepository.findById(userId).get());
        task.setId(taskId);
        taskRepository.save(task);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
