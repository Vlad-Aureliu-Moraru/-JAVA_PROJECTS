package com.example.ToDoApp.User.QueryHandlers;

import com.example.ToDoApp.Query;
import com.example.ToDoApp.User.Model.User;
import com.example.ToDoApp.User.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetUserQueryHandler implements Query<Integer, User> {
    private UserRepository userRepository;
    public GetUserQueryHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public ResponseEntity<User> execute(Integer input) {
        User user = userRepository.findById(input).get();
        return ResponseEntity.ok(user);
    }
}
