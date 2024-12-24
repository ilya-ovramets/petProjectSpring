package com.illia.mapper;

import com.illia.dto.RoleDTO;
import com.illia.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDTO toDTO(Role role);
    @Mapping(target = "id", ignore = true)
    Role toEntity(RoleDTO roleDTO);
}
