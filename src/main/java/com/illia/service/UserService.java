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

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User updateUser) {
        return this.findById(id).
                map((existingUser) -> {
                    existingUser.setFirstName(updateUser.getFirstName());
                    existingUser.setLastName(updateUser.getLastName());
                    existingUser.setEmail(updateUser.getEmail());
                    existingUser.setRole(updateUser.getRole());
                    existingUser.setPassword(updateUser.getPassword());
                    existingUser.setTasks(updateUser.getTasks());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new ResolutionException("User not found with ID" + id));
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


}
