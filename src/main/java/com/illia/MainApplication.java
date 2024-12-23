package com.illia;

import com.illia.model.Role;
import com.illia.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MainApplication {
    private static final Logger log = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(MainApplication.class, args);
    }

}