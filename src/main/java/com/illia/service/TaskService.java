package com.illia.service;


import com.illia.model.Task;
import com.illia.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> findAll(){return taskRepository.findAll();}

    public Optional<Task> findById(Long id){return taskRepository.findById(id);}

    public Task save(Task task){return taskRepository.save(task);}

    public void deleteById(Long id){taskRepository.deleteById(id);}


}
