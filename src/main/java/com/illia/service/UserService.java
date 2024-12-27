package com.illia.service;

import com.illia.model.User;
import com.illia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findByIds(List<Long> ids) {
        return ids.stream().map(id -> userRepository.findById(id).get()).toList();
    }


    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User updateUser) {
        return this.findById(id)
                .map(existingUser -> {
                    if (updateUser.getFirstName() != null) {
                        existingUser.setFirstName(updateUser.getFirstName());
                    }
                    if (updateUser.getLastName() != null) {
                        existingUser.setLastName(updateUser.getLastName());
                    }
                    if (updateUser.getEmail() != null) {
                        existingUser.setEmail(updateUser.getEmail());
                    }
                    if (updateUser.getRole() != null) {
                        existingUser.setRole(updateUser.getRole());
                    }
                    if (updateUser.getPassword() != null) {
                        existingUser.setPassword(updateUser.getPassword());
                    }
                    if (updateUser.getTasks() != null) {
                        existingUser.setTasks(updateUser.getTasks());
                    }

                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new ResolutionException("User not found with ID: " + id));
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


}
