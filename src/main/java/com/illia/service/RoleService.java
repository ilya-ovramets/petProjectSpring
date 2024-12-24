package com.illia.service;


import com.illia.model.Role;
import com.illia.model.User;
import com.illia.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public List<Role> findAll(){return roleRepository.findAll();}

    public Optional<Role> findById(Long id){return roleRepository.findById(id);}

    public Optional<Role> findByName(String name){return roleRepository.findByName(name);}

    public Role save(Role role){return roleRepository.save(role);}

    public Role update(Long id, Role updateRole){
        return this.findById(id).map(existedRole -> {
            existedRole.setName(updateRole.getName());
            existedRole.setUsers(updateRole.getUsers());
            return roleRepository.save(existedRole);

        }).orElseThrow(() -> new ResolutionException("Role not found with ID" + id));

    }


    public void deleteById(Long id){roleRepository.deleteById(id);}


}
