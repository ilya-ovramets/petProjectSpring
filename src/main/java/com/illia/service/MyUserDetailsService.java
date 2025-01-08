package com.illia.service;

import com.illia.model.MyUserDetails;
import com.illia.model.User;
import com.illia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findUserByEmail(username)
                .orElseThrow(
                () -> new UsernameNotFoundException(username)
        );

//        user.setTasks(List.of());

        return new MyUserDetails(user);
    }
}
