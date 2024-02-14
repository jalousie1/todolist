package com.example.todolist.repository;

import com.example.todolist.entity.TodoEntity;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface TodoRepository  extends JpaRepository<TodoEntity, Long> {
    void deleteById(SingularAttribute<AbstractPersistable, Serializable> id);
}
