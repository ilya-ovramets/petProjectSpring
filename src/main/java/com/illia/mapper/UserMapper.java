package com.illia.mapper;

import com.illia.dto.UserDTO;
import com.illia.model.Role;
import com.illia.model.User;
import com.illia.service.RoleService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Autowired
    protected RoleService roleService;

    @Mapping(target = "roleName", source = "role.name")
    public abstract UserDTO toDTO(User user);

    @Mapping(target = "role", ignore = true) // Ігноруємо поле role, щоб встановити його пізніше
    @Mapping(target = "id", ignore = true)
    public abstract User toEntity(UserDTO userDTO);


}