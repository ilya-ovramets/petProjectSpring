package com.illia.service;

import com.illia.dto.UserDTO;
import com.illia.mapper.UserMapper;
import com.illia.model.User;
import com.illia.repository.UserRepository;
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
            var user = userMapper.toEntityEager(userDTO);
            userRepository.save(user);
            return userDTO;
        }catch (Exception ex){
            throw ex;
        }


    }

    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


}
