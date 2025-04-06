package com.example.ToDoApp.User.CommandHandlers;

import com.example.ToDoApp.Command;
import com.example.ToDoApp.User.Model.User;
import com.example.ToDoApp.User.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserCommand implements Command <Integer,Void> {
private final UserRepository userRepository;
public DeleteUserCommand(UserRepository userRepository) {
    this.userRepository = userRepository;
}

    @Override
    public ResponseEntity execute(Integer id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().body("User deleted successfully");
    }
}
