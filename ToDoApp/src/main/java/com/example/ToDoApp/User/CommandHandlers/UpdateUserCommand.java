package com.example.ToDoApp.User.CommandHandlers;

import com.example.ToDoApp.Command;
import com.example.ToDoApp.User.Model.User;
import com.example.ToDoApp.User.Model.UserUpdate;
import com.example.ToDoApp.User.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class UpdateUserCommand implements Command<UserUpdate , Void>{
private final UserRepository userRepository;
public UpdateUserCommand(UserRepository userRepository) {
    this.userRepository = userRepository;
}

    @Override
    public ResponseEntity execute(UserUpdate entity) {
        User toReplace = userRepository.findById(entity.getId()).get();
        if(toReplace== null) {
            throw  new RuntimeException("User not found");
        }
        User user = entity.getUser();
        user.setId(entity.getId());
        userRepository.save(user);
        return ResponseEntity.ok().body("User updated successfully");
    }

}
