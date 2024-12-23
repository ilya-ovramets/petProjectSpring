package com.illia.controller;


import com.illia.model.Task;
import com.illia.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping
    public List<Task> findAll(){return taskService.findAll();}

    @GetMapping("/{id}")
    public Optional<Task> findById(@PathVariable Long id){return taskService.findById(id);}

    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public Task create(@RequestBody Task task) {
        return taskService.save(task);
    }

    @PutMapping
    public Task update(@RequestBody Task task) {
        return taskService.save(task);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        taskService.deleteById(id);
    }

}
