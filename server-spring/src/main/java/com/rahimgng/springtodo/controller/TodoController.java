package com.rahimgng.springtodo.controller;

import com.rahimgng.springtodo.entity.TodoHeadEntity;
import com.rahimgng.springtodo.entity.TodoSubEntity;
import com.rahimgng.springtodo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("todos")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    TodoService service;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody TodoHeadEntity entity) {
        return ResponseEntity.ok(service.saveHead(entity));
    }

    @GetMapping
    public List<TodoHeadEntity> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
        System.out.println("Deleted!");
    }

    @DeleteMapping("/deleteall")
    public void deleteAll() {
        service.deleteAll();
    }

    @GetMapping("/{id}")
    public Optional<TodoHeadEntity> getSpes(@PathVariable Long id) {
        return service.getSpes(id);
    }

    @PostMapping("add/{id}")
    public ResponseEntity<?> addTask(@RequestBody TodoSubEntity entity, @PathVariable Long id) {
        entity.setTitleId(id);
        return ResponseEntity.ok(service.saveIt(entity));
    }

    @PutMapping("task/{taskId}")
    public TodoSubEntity update(@RequestBody TodoSubEntity newEntity, @PathVariable Long taskId) throws IOException {
        newEntity.setTaskId(taskId);
        return service.updateIt(newEntity, taskId);
    }
    @DeleteMapping("task/{id}")
    public void deleteIt(@PathVariable Long id) {
        service.deleteIt(id);
        System.out.println("Task Deleted!");
    }

}
