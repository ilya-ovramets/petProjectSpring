package com.illia.controller;


import com.illia.dto.RoleDTO;
import com.illia.mapper.RoleMapper;
import com.illia.model.Role;
import com.illia.model.User;
import com.illia.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    RoleService roleService;
    @Autowired
    RoleMapper roleMapper;

    @GetMapping
    public List<RoleDTO> findAll(){
        return roleService.findAll().stream().map(roleMapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> findById(@PathVariable Long id){
        return roleService.findById(id)
            .map(role -> ResponseEntity.ok(roleMapper.toDto(role))) // Перетворення в DTO
            .orElse(ResponseEntity.notFound().build());}

    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public ResponseEntity<RoleDTO> create(@RequestBody RoleDTO roleDTO) {
        Role role = roleMapper.toEntity(roleDTO);
        roleService.save(role);

        return ResponseEntity.ok().body(roleDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> update(@PathVariable Long id,@RequestBody RoleDTO roleDTO) {
        roleMapper.partialUpdate(roleService.findById(id).get(),roleDTO);
        return ResponseEntity.ok(roleDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        roleService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
