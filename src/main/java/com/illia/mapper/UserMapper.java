package com.illia.mapper;

import com.illia.dto.RoleDTO;
import com.illia.dto.TaskDTO;
import com.illia.dto.UserDTO;
import com.illia.model.Role;
import com.illia.model.Task;
import com.illia.model.User;
import com.illia.service.RoleService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO,User> {

    @Mapping(target ="taskDTOS", source = "tasks")
    @Mapping(target = "roleDTO", source="role")
    UserDTO toDtoEager(User user);

    @Mapping(target ="tasks", source = "taskDTOS")
    @Mapping(target = "role", source="roleDTO")
    User toEntityEager(UserDTO userDTO);





}