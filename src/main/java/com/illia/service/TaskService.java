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
        return this.findById(id).map(existingTask -> {
            if (updateTask.getTitle() != null) {
                existingTask.setTitle(updateTask.getTitle());
            }
            if (updateTask.getBody() != null) {
                existingTask.setBody(updateTask.getBody());
            }
            if (updateTask.getStartDate() != null) {
                existingTask.setStartDate(updateTask.getStartDate());
            }
            if (updateTask.getFinishDate() != null) {
                existingTask.setFinishDate(updateTask.getFinishDate());
            }
            if (updateTask.getCreateBy() != null) {
                existingTask.setCreateBy(updateTask.getCreateBy());
            }
            if (updateTask.getStatus() != null) {
                existingTask.setStatus(updateTask.getStatus());
            }
            if (updateTask.getTags() != null) {
                existingTask.setTags(updateTask.getTags());
            }

            return taskRepository.save(existingTask);
        }).orElseThrow(() -> new ResolutionException("Task not found with ID: " + id));
    }


    public void deleteById(Long id){taskRepository.deleteById(id);}


}
