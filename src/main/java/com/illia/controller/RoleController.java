package com.illia.controller;


import com.illia.model.Book;
import com.illia.model.Role;
import com.illia.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping
    public List<Role> findAll(){return roleService.findAll();}

    @GetMapping("/{id}")
    public Optional<Role> findById(@PathVariable Long id){return roleService.findById(id);}

    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public Role create(@RequestBody Role role) {
        return roleService.save(role);
    }

    @PutMapping
    public Role update(@RequestBody Role role) {
        return roleService.save(role);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        roleService.deleteById(id);
    }
}
