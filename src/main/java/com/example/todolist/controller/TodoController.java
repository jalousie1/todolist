package com.example.todolist.controller;

import com.example.todolist.entity.TodoEntity;
import com.example.todolist.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    List<TodoEntity> create(@RequestBody TodoEntity todo) {
        return todoService.create(todo);
    }

    @GetMapping
    List<TodoEntity> list() {
        return todoService.list();
    }

    @PutMapping
    List<TodoEntity> update(@RequestBody TodoEntity todo) {
        return todoService.update(todo);

    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return todoService.delete(id);
    }
}
