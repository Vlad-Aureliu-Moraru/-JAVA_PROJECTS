package com.example.ToDoApp.User.CommandHandlers;

import com.example.ToDoApp.Command;
import com.example.ToDoApp.User.Model.User;
import com.example.ToDoApp.User.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateUserCommand implements Command <User,ResponseEntity>{
    private UserRepository userRepository;
    public CreateUserCommand(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public ResponseEntity execute(User user) {
        validateUser(user);
        try {
            userRepository.save(user);
            return ResponseEntity.ok().body("User created successfully");
        }catch (DataIntegrityViolationException exception){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }
    }
    private void validateUser(User user) {
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new RuntimeException();
        } else if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new RuntimeException();
        }
    }
}
