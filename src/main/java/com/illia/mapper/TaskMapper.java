package com.illia.mapper;

import com.illia.dto.TaskDTO;
import com.illia.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mapping(target = "statusName", expression = "java(task.getStatus() != null ? task.getStatus().getStatusName() : null)")
    TaskDTO toDTO(Task task);
    Task toEntity(TaskDTO taskDTO);
}
