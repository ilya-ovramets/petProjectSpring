package com.illia.controller;


import com.illia.dto.UserDTO;
import com.illia.mapper.UserMapper;
import com.illia.model.User;
import com.illia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;


    @GetMapping
    public List<UserDTO> findAll(){return userService.findAll().stream()
            .map(userMapper::toDTO)
            .toList();}


    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        return userService.findById(id)
                .map(user -> ResponseEntity.ok(userMapper.toDTO(user))) // Перетворення в DTO
                .orElse(ResponseEntity.notFound().build());

    }

    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userService.save(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

}
