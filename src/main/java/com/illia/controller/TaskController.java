package com.illia.controller;

import com.illia.dto.TaskDTO;
import com.illia.mapper.TaskMapper;
import com.illia.model.Task;
import com.illia.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    TaskMapper taskMapper;

    @GetMapping
    public List<TaskDTO> findAll() {
        return taskService.findAll().stream().map(taskMapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable Long id) {
        return taskService.findById(id)
                .map(task -> ResponseEntity.ok(taskMapper.toDto(task)))
                .orElse(ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO taskDTO) {
        Task task = taskMapper.toEntity(taskDTO);
        taskService.save(task);
        return ResponseEntity.ok().body(taskDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> update(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        Task updatedTask = taskService.update(id, taskMapper.toEntity(taskDTO));
        return ResponseEntity.ok(taskMapper.toDto(updatedTask));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
