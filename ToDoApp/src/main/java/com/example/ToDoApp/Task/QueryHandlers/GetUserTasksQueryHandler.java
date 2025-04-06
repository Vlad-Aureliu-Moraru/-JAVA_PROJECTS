package com.example.ToDoApp.Task.QueryHandlers;

import com.example.ToDoApp.Query;
import com.example.ToDoApp.Task.Model.TaskDTO;
import com.example.ToDoApp.User.Model.User;
import com.example.ToDoApp.User.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetUserTasksQueryHandler implements Query<Integer, List<TaskDTO>> {
    private final UserRepository userRepository;
    public GetUserTasksQueryHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<List<TaskDTO>> execute(Integer userId) {
        User user = userRepository.findById(userId).get();
        List<TaskDTO> taskDTOS = user.getTasks().stream().map(TaskDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(taskDTOS);
    }
}
