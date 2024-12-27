package com.illia.controller;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.illia.mapper.StatusMapper;
import com.illia.dto.StatusDTO;
import com.illia.model.Role;
import com.illia.model.Status;
import com.illia.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    StatusService statusService;
    @Autowired
    StatusMapper statusMapper;

    @GetMapping
    public List<StatusDTO> findAll(){
        return statusService.findAll().stream().map(statusMapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDTO> findById(@PathVariable Long id){
        return statusService.findById(id)
                .map(status -> ResponseEntity.ok(statusMapper.toDto(status))) // Перетворення в DTO
                .orElse(ResponseEntity.notFound().build());
    }


    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public ResponseEntity<StatusDTO> create(@RequestBody StatusDTO statusDTO) {
        Status status = statusMapper.toEntity(statusDTO);
        statusService.save(status);

        return ResponseEntity.ok().body(statusDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusDTO> update(@PathVariable Long id, @RequestBody StatusDTO statusDTO) {
        statusMapper.partialUpdate(statusService.findById(id).get(),statusDTO);
        return ResponseEntity.ok(statusDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        statusService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
