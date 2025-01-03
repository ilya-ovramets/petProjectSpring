package com.illia.service;

import com.illia.dto.UserDTO;
import com.illia.mapper.UserMapper;
import com.illia.model.User;
import com.illia.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;;

    @Transactional
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDtoLazy)
                .toList();
    }

    @Transactional
    public Optional<UserDTO> findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDtoEager);
    }

    @Transactional
    public UserDTO save(UserDTO userDTO) {
        try {
            User user = userMapper.toEntityEager(userDTO);
            userRepository.save(user);
            return userDTO;
        }catch (Exception ex){
            throw ex;
        }
    }

    @Transactional
    public UserDTO update(UserDTO userDTO) {
        // Перевірка, чи існує користувач із таким ID
        User existingUser = userRepository.findById(userDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("User with ID " + userDTO.getId() + " not found"));

        // Перетворення DTO на сутність
        User resaveUser = userMapper.toEntityEager(userDTO);

        // Перевірки та оновлення полів
        if (resaveUser.getFirstName() != null && !resaveUser.getFirstName().isBlank()) {
            existingUser.setFirstName(resaveUser.getFirstName());
        }

        if (resaveUser.getLastName() != null && !resaveUser.getLastName().isBlank()) {
            existingUser.setLastName(resaveUser.getLastName());
        }

        if (resaveUser.getEmail() != null ) {
            existingUser.setEmail(resaveUser.getEmail());
        }

        if (resaveUser.getPassword() != null && resaveUser.getPassword().length() >= 8) {
            existingUser.setPassword(resaveUser.getPassword()); // Можна додати хешування пароля
        } else if (resaveUser.getPassword() != null) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        if (resaveUser.getRole() != null) {
            existingUser.setRole(resaveUser.getRole());
        }

        if (resaveUser.getTasks() != null && !resaveUser.getTasks().isEmpty()) {
            existingUser.setTasks(resaveUser.getTasks());
        }

        // Save
        User updatedUser = userRepository.save(existingUser);

        // Return updated DTO
        return userMapper.toDtoEager(updatedUser);
    }



    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


}
