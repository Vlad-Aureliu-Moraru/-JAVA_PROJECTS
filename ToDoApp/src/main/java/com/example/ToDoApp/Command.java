package com.example.ToDoApp;

import org.springframework.http.ResponseEntity;

public interface Command<E,T> {
    ResponseEntity<T> execute(E entity);
}
