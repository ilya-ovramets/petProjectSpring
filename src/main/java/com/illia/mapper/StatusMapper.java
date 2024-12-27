package com.illia.mapper;

import com.illia.dto.RoleDTO;
import com.illia.dto.StatusDTO;
import com.illia.dto.TaskDTO;
import com.illia.dto.UserDTO;
import com.illia.model.Role;
import com.illia.model.Status;
import com.illia.model.Task;
import com.illia.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel="spring")
public interface StatusMapper extends EntityMapper<StatusDTO, Status>{

    @Mapping(target = "taskDTOS", source = "tasks", qualifiedByName = "toMinimalTaskDto")
    StatusDTO toDtoEager(Status status);

    @Named("toMinimalTaskDto")
    @Mapping(target = "performerDtos", ignore = true)
    @Mapping(target = "tagDTOS", ignore = true)
    @Mapping(target = "statusDTO", ignore = true)
    TaskDTO toMinimalTaskDto(Task task);
}
