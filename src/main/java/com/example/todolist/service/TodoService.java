package com.example.todolist.service;

import com.example.todolist.entity.TodoEntity;
import com.example.todolist.repository.TodoRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    public List<TodoEntity> create(TodoEntity todo) {
        todoRepository.save(todo);
        return list();
    }
    public List<TodoEntity> list() {
        Sort sort = Sort.by(Sort.Direction.ASC, "prioridade").descending().and(
                Sort.by(Sort.Direction.ASC, "nome").ascending());
        return todoRepository.findAll(sort);
    }
    public List<TodoEntity> update(TodoEntity todo) {
        todoRepository.save(todo);
        return list();
    }
    public ResponseEntity<?> delete(Long id) {
        return todoRepository.findById(id)
                .map(existingTodo -> {
                    todoRepository.delete(existingTodo);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.badRequest().body("Todo " + id + " não existe!"));
    }

}
