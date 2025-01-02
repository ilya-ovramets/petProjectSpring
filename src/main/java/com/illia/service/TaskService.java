package com.illia.service;


import com.illia.dto.TaskDTO;
import com.illia.mapper.TaskMapper;
import com.illia.mapper.UserMapper;
import com.illia.model.Task;
import com.illia.model.Task;
import com.illia.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;;

    @Transactional
    public List<TaskDTO> findAll(){return taskRepository.findAll().stream()
            .map(taskMapper::toDtoLazy)
            .toList();}

    @Transactional
    public Optional<TaskDTO> findById(Long id) {
        return taskRepository.findById(id)
                .map(taskMapper::toDtoEager); // Використовуємо TaskMapper для перетворення
    }

    @Transactional
    public TaskDTO save(TaskDTO taskDTO){
        try {
            var user = taskMapper.toEntityEager(taskDTO);
            taskRepository.save(user);
            return taskDTO;
        }catch (Exception ex){
            throw ex;
        }
    }

    @Transactional
    public void deleteById(Long id){taskRepository.deleteById(id);}


}
