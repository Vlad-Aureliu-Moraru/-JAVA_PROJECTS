package com.example.ToDoApp.User;

import com.example.ToDoApp.Task.Model.Task;
import com.example.ToDoApp.User.CommandHandlers.CreateUserCommand;
import com.example.ToDoApp.User.CommandHandlers.DeleteUserCommand;
import com.example.ToDoApp.User.CommandHandlers.UpdateUserCommand;
import com.example.ToDoApp.User.Model.User;
import com.example.ToDoApp.User.Model.UserUpdate;
import com.example.ToDoApp.User.QueryHandlers.GetAllUsersQueryHandler;
import com.example.ToDoApp.User.QueryHandlers.GetUserQueryHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    private GetUserQueryHandler getUserQueryHandler;
    private GetAllUsersQueryHandler getAllUsersQueryHandler;

    private UpdateUserCommand updateUserCommand;
    private CreateUserCommand createUserCommand;
    private DeleteUserCommand deleteUserCommand;
    public UserController(UpdateUserCommand updateUserCommand,DeleteUserCommand deleteUserCommand,CreateUserCommand createUserCommand,GetUserQueryHandler getUserQueryHandler, GetAllUsersQueryHandler getAllUsersQueryHandler) {
        this.getUserQueryHandler = getUserQueryHandler;
        this.updateUserCommand = updateUserCommand;
        this.createUserCommand = createUserCommand;
        this.deleteUserCommand = deleteUserCommand;
        this.getAllUsersQueryHandler = getAllUsersQueryHandler;
    }
    /*!TODO
    * user CRUD
    * user get all tasks
    * */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return getAllUsersQueryHandler.execute(null);
    }
     @GetMapping("/{id}")
    public ResponseEntity<User>getUser(@PathVariable int id) {
        return getUserQueryHandler.execute(id);
    }
    @PostMapping()
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return createUserCommand.execute(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        return deleteUserCommand.execute(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id , @RequestBody User user) {
        UserUpdate userUpdate = new UserUpdate(id,user);
        return updateUserCommand.execute(userUpdate);
    }
}
