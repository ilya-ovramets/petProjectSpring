package com.illia.controller;


import com.illia.model.Status;
import com.illia.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    StatusService statusService;

    @GetMapping
    public List<Status> findAll(){return statusService.findAll();}

    @GetMapping("/{id}")
    public Optional<Status> findById(@PathVariable Long id){return statusService.findById(id);}

    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public Status create(@RequestBody Status status) {
        return statusService.save(status);
    }

    @PutMapping
    public Status update(@RequestBody Status status) {
        return statusService.save(status);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        statusService.deleteById(id);
    }
}
