package com.illia.mapper;

import com.illia.dto.RoleDTO;
import com.illia.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper extends EntityMapper<RoleDTO,Role>{

    RoleDTO toDtoEager(Role role);

    Role toEntity(RoleDTO roleDTO);

}
