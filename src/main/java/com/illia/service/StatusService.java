package com.illia.service;


import com.illia.dto.RoleDTO;
import com.illia.dto.StatusDTO;
import com.illia.mapper.StatusMapper;
import com.illia.model.Role;
import com.illia.model.Status;
import com.illia.model.Tag;
import com.illia.model.Task;
import com.illia.repository.StatusRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    StatusRepository statusRepository;
    @Autowired
    StatusMapper statusMapper;

    @Transactional
    public List<StatusDTO> findAll(){
        return statusRepository.findAll()
                .stream()
                .map(statusMapper::toDtoLazy).toList();
    }

    @Transactional
    public Optional<StatusDTO> findById(Long id){
        return statusRepository.findById(id)
                .map(statusMapper::toDtoEager);
    }

    @Transactional
    public StatusDTO save(StatusDTO statusDTO){
        try {
            Status status = statusMapper.toEntityLazy(statusDTO);
            statusRepository.save(status);
            return statusDTO;
        }catch (Exception ex){
            throw ex;
        }
    }

    @Transactional
    public StatusDTO update(Long id, StatusDTO statusDTO){
        try {
            Status existingStatus = statusRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Status with id " + id + " not found"));

            statusMapper.partialUpdate(existingStatus,statusDTO);
            return statusDTO;
        }catch (Exception e){
            throw e;
        }
    }


    public void deleteById(Long id){
        statusRepository.deleteById(id);
    }

}
