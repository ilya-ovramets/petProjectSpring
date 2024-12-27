package com.illia.mapper;

import com.illia.dto.UserDTO;
import com.illia.model.Role;
import com.illia.model.User;
import com.illia.service.RoleService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO,User> {

    @Mapping(target ="taskDTOS", source = "tasks")
    @Mapping(target = "roleDTO", source="role")
    UserDTO toDtoEager(User user);

    @Mapping(target ="task", source = "taskDTOS")
    @Mapping(target = "role", source="roleDTO")
    User toEntityEager(UserDTO userDTO);


}