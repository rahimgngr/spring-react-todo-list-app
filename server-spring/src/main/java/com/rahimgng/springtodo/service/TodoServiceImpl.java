package com.rahimgng.springtodo.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.rahimgng.springtodo.entity.TodoHeadEntity;
import com.rahimgng.springtodo.entity.TodoSubEntity;
import com.rahimgng.springtodo.repository.TodoRepo;
import com.rahimgng.springtodo.repository.TodoSubRepo;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepo repository;
    @Autowired
    TodoSubRepo repo;

    @Override
    public Object saveHead(TodoHeadEntity todoHeadEntity) {
        List<String> users = repository.findAll().stream().distinct().map(TodoHeadEntity::getTitle).collect(Collectors.toList());
        if (users.contains(todoHeadEntity.getTitle())) {
            return "Todo Exists!";
        } else
            return repository.save(todoHeadEntity);
    }

    @Override
    public List<TodoHeadEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Optional<TodoHeadEntity> getSpes(Long id) {
        return repository.findById(id);
    }


    @Override
    public TodoSubEntity updateIt(TodoSubEntity todoSubEntity, Long taskId)  {
        TodoSubEntity entity = repo.findById(taskId).orElseThrow(() -> new ResourceNotFoundException("title not found for ::" + taskId));
        entity.setCompleted(todoSubEntity.isCompleted());
        final TodoSubEntity todoSub = repo.save(entity);
        return repo.save(todoSub);
    }

    @Override
    public void deleteIt(Long taskId) {
        repo.deleteById(taskId);
    }

    @Override
    public Object saveIt(TodoSubEntity todoSubEntity) {
        return ResponseEntity.ok(repo.save(todoSubEntity));
    }
}
