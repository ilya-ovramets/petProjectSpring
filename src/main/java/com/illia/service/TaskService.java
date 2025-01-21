package com.illia.service;


import com.illia.dto.TaskDTO;
import com.illia.mapper.TaskMapper;
import com.illia.mapper.UserMapper;
import com.illia.model.Task;
import com.illia.model.Task;
import com.illia.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
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
    public List<TaskDTO> findAll(){
        return taskRepository.findAll().stream()
            .map(taskMapper::toDtoLazy)
            .toList();
    }

    @Transactional
    public Optional<TaskDTO> findById(Long id) {
        return taskRepository.findById(id)
                .map(taskMapper::toDtoEager); // Використовуємо TaskMapper для перетворення
    }

    @Transactional
    public TaskDTO save(TaskDTO taskDTO){
        try {
            Task task = taskMapper.toEntityEager(taskDTO);
            taskRepository.save(task);
            return taskDTO;
        }catch (Exception ex){
            throw ex;
        }
    }

    @Transactional(rollbackOn = EntityNotFoundException.class)
    public TaskDTO update(TaskDTO taskDTO) {
        // Check this task exist or not.
        Task existingTask = taskRepository.findById(taskDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Task with ID " + taskDTO.getId() + " not found"));

        // Transform DTO to Entity.
        Task resaveTask = taskMapper.toEntityEager(taskDTO);

        // Update field
        if (resaveTask.getTitle() != null && !resaveTask.getTitle().isBlank()) {
            existingTask.setTitle(resaveTask.getTitle());
        }

        if (resaveTask.getBody() != null && !resaveTask.getBody().isBlank()) {
            existingTask.setBody(resaveTask.getBody());
        }

        if (resaveTask.getStartDate() != null) {
            if (resaveTask.getFinishDate() != null && resaveTask.getStartDate().isAfter(resaveTask.getFinishDate())) {
                throw new IllegalArgumentException("Start date cannot be after finish date");
            }
            existingTask.setStartDate(resaveTask.getStartDate());
        }

        if (resaveTask.getFinishDate() != null) {
            if (existingTask.getStartDate() != null && resaveTask.getFinishDate().isBefore(existingTask.getStartDate())) {
                throw new IllegalArgumentException("Finish date cannot be before start date");
            }
            existingTask.setFinishDate(resaveTask.getFinishDate());
        }

        if (resaveTask.getCreateBy() != null) {
            existingTask.setCreateBy(resaveTask.getCreateBy());
        }

        if (resaveTask.getStatus() != null) {
            existingTask.setStatus(resaveTask.getStatus());
        }

        if (resaveTask.getPerformers() != null && !resaveTask.getPerformers().isEmpty()) {
            existingTask.setPerformers(resaveTask.getPerformers());
        }

        if (resaveTask.getTags() != null && !resaveTask.getTags().isEmpty()) {
            existingTask.setTags(resaveTask.getTags());
        }

        // Save updated Task.
        Task updatedTask = taskRepository.save(existingTask);

        // Return updated DTO
        return taskMapper.toDtoEager(updatedTask);
    }





    @Transactional
    public void deleteById(Long id){
        taskRepository.deleteById(id);
    }


}
