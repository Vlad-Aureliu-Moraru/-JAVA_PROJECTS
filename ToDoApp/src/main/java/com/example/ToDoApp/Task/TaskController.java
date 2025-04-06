package com.example.ToDoApp.Task;

import com.example.ToDoApp.Task.CommandHandlers.CreateUserTaskCommandHandler;
import com.example.ToDoApp.Task.CommandHandlers.DeleteUserTaskCommandHandler;
import com.example.ToDoApp.Task.CommandHandlers.UpdateUserTaskCommandHandler;
import com.example.ToDoApp.Task.Model.Task;
import com.example.ToDoApp.Task.Model.TaskHelper;
import com.example.ToDoApp.Task.QueryHandlers.GetUserTasksQueryHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final GetUserTasksQueryHandler getUserTasksQueryHandler;
    private final UpdateUserTaskCommandHandler updateUserTaskCommandHandler;
    private final CreateUserTaskCommandHandler createUserTaskCommandHandler;
    private final DeleteUserTaskCommandHandler deleteUserTaskCommandHandler;

    public TaskController(DeleteUserTaskCommandHandler deleteUserTaskCommandHandler,GetUserTasksQueryHandler getUserTasksQueryHandler,CreateUserTaskCommandHandler createUserTaskCommandHandler, UpdateUserTaskCommandHandler updateUserTaskCommandHandler) {
        this.getUserTasksQueryHandler = getUserTasksQueryHandler;
        this.updateUserTaskCommandHandler = updateUserTaskCommandHandler;
        this.createUserTaskCommandHandler = createUserTaskCommandHandler;
        this.deleteUserTaskCommandHandler = deleteUserTaskCommandHandler;
    }
    //crud
    //!done
    @GetMapping("/{user_id}")
    public ResponseEntity getTask(@PathVariable("user_id") int user_id) {
        return getUserTasksQueryHandler.execute(user_id);
    }
    //!done
    @PutMapping("/{user_id}/{task_id}")
    public ResponseEntity updateTask(@PathVariable("user_id") int user_id,@PathVariable("task_id") int task_id, @RequestBody com.example.ToDoApp.Task.Model.Task task) {
        TaskHelper taskHelper = new TaskHelper(task_id,user_id,task);
        return updateUserTaskCommandHandler.execute(taskHelper);

    }
    //!done
    @PostMapping("/{user_id}")
    public ResponseEntity<Object> addTask(@PathVariable("user_id") int user_id, @RequestBody Task task) {
        TaskHelper taskHelper = new TaskHelper(user_id,task);
        return createUserTaskCommandHandler.execute(taskHelper);
    }
    //!
    @DeleteMapping("/{user_id}/{task_id}")
    public ResponseEntity deleteTask(@PathVariable("user_id") int user_id,@PathVariable("task_id")int task_id) {
        TaskHelper taskHelper = new TaskHelper(user_id,task_id);
        return deleteUserTaskCommandHandler.execute(taskHelper);
    }

}
