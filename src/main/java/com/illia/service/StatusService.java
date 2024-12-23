package com.illia.service;


import com.illia.model.Role;
import com.illia.model.Status;
import com.illia.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    StatusRepository statusRepository;

    public List<Status> findAll(){return statusRepository.findAll();}

    public Optional<Status> findById(Long id){return statusRepository.findById(id);}

    public Status save(Status status){return statusRepository.save(status);}

    public Status update(Long id, Status updateStatus){
        return this.findById(id).map(existedStatus -> {
            existedStatus.setStatusName(updateStatus.getStatusName());
            existedStatus.setTasks(updateStatus.getTasks());
            return statusRepository.save(existedStatus);

        }).orElseThrow(() -> new ResolutionException("Status not found with ID" + id));

    }

    public void deleteById(Long id){statusRepository.deleteById(id);}

}
