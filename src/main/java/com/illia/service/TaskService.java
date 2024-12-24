package com.illia.service;


import com.illia.model.Task;
import com.illia.model.Task;
import com.illia.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<Task> findAll(){return taskRepository.findAll();}

    public Optional<Task> findById(Long id){return taskRepository.findById(id);}

    public Task save(Task task){return taskRepository.save(task);}

    public Task update(Long id, Task updateTask) {
        return this.findById(id).map(existedTask -> {
            existedTask.setTitle(updateTask.getTitle());
            existedTask.setBody(updateTask.getBody());
            existedTask.setStartDate(updateTask.getStartDate());
            existedTask.setFinishDate(updateTask.getFinishDate());
            existedTask.setPerformers(updateTask.getPerformers());
            existedTask.setCreateBy(updateTask.getCreateBy());
            existedTask.setStatus(updateTask.getStatus());
            existedTask.setTags(updateTask.getTags());

            return taskRepository.save(existedTask);
        }).orElseThrow(() -> new ResolutionException("Task not found with ID " + id));
    }

    public void deleteById(Long id){taskRepository.deleteById(id);}


}
