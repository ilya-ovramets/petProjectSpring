package com.illia.mapper;

import com.illia.dto.RoleDTO;
import com.illia.dto.UserDTO;
import com.illia.model.Role;
import com.illia.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper extends EntityMapper<RoleDTO,Role>{

    @Mapping(target="userDTOS", source = "users", qualifiedByName = "toMinimalUserDto")
    RoleDTO toDtoEager(Role role);


    @Named("toMinimalUserDto")
    @Mapping(target = "taskDTOS", ignore = true)
    @Mapping(target = "role", ignore = true)
    UserDTO toMinimalUserDto(User user);

}
