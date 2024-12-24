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

    @Mapping(target = "roleName", expression = "java(user.getRole() != null ? user.getRole().getName() : null)")
    public abstract UserDTO toDTO(User user);

    @Mapping(target = "role", ignore = true) // Ігноруємо поле role, щоб встановити його пізніше
    @Mapping(target = "id", ignore = true)
    public abstract User toEntity(UserDTO userDTO);

    @AfterMapping
    protected void setRoleForEntity(@MappingTarget User user, UserDTO userDTO) {
        if (userDTO.getRoleName() != null) {
            Role role = roleService.findByName(userDTO.getRoleName()).get();
            user.setRole(role);
        }
    }
}