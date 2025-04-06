package com.example.ToDoApp.Task.Model;

import com.example.ToDoApp.User.Model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @ToString.Exclude
    private  User user;

//    @Column(name = "user_id")
//    private int userId;
    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_description")
    private String taskDescription;
}
