package com.example.ToDoApp.User.QueryHandlers;

import com.example.ToDoApp.Query;
import com.example.ToDoApp.User.Model.User;
import com.example.ToDoApp.User.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GetAllUsersQueryHandler implements Query<Void,List<User>> {
    private UserRepository userRepository;
    public GetAllUsersQueryHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public ResponseEntity<List<User>> execute(Void input) {
        List<User> users = userRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
