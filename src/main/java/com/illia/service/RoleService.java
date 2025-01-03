package com.illia.service;


import com.illia.dto.RoleDTO;
import com.illia.mapper.RoleMapper;
import com.illia.model.Role;
import com.illia.model.Task;
import com.illia.model.User;
import com.illia.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoleMapper roleMapper;

    @Transactional
    public List<RoleDTO> findAll(){
        return roleRepository.findAll().stream()
                .map(roleMapper::toDtoLazy)
                .toList();
    }

    @Transactional
    public Optional<RoleDTO> findById(Long id){
        return roleRepository.findById(id)
                .map(roleMapper::toDtoEager);
    }

    @Transactional
    public RoleDTO save(RoleDTO roleDTO){
        try {
            Role role = roleMapper.toEntityLazy(roleDTO);
            roleRepository.save(role);
            return roleDTO;
        }catch (Exception ex){
            throw ex;
        }
    }

    @Transactional
    public RoleDTO update(Long id,RoleDTO roleDTO){
        try {
            roleMapper.partialUpdate(roleRepository.findById(id).get(),roleDTO);
            return roleDTO;
        }catch (Exception e){
            throw e;
        }
    }

    @Transactional
    public void deleteById(Long id){roleRepository.deleteById(id);}


}
