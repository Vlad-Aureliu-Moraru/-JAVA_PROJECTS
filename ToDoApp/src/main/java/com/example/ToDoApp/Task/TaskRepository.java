package com.example.ToDoApp.Task;

import com.example.ToDoApp.Task.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("SELECT t FROM Task t WHERE t.user.id = :userId")
    List<Task> findTasksByUserIdJPQL(int userId);

    @Query("SELECT t FROM Task t WHERE t.user.id = :userId AND t.id = :taskId")
    Optional<Task> findTaskByUserIdAndIdJPQL(int userId, int taskId);
}
