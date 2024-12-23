package com.illia.service;


import com.illia.model.Status;
import com.illia.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    StatusRepository statusRepository;

    public List<Status> findAll(){return statusRepository.findAll();}

    public Optional<Status> findById(Long id){return statusRepository.findById(id);}

    public Status save(Status status){return statusRepository.save(status);}

    public void deleteById(Long id){statusRepository.deleteById(id);}

}
