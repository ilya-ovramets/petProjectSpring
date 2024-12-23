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
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        User user = userService.save(userMapper.toEntity(userDTO));
        UserDTO responceDTO = userMapper.toDTO(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(responceDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id,@RequestBody UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User updateUser = userService.updateUser(id,user);
        return ResponseEntity.ok(userMapper.toDTO(updateUser));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
