package com.illia.mapper;

import com.illia.dto.StatusDTO;
import com.illia.dto.TagDTO;
import com.illia.dto.TaskDTO;
import com.illia.model.Status;
import com.illia.model.Tag;
import com.illia.model.Task;
import com.illia.service.StatusService;
import com.illia.service.TagService;
import com.illia.service.UserService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper extends EntityMapper<TaskDTO, Task>{

    @Mapping(target = "performerDtos", source = "performers")
    @Mapping(target= "statusDTO", source = "status")
    @Mapping(target= "tagDTOS", source = "tags")
    TaskDTO toDtoEager(Task task);

    @Mapping(target = "performers", source = "performerDtos")
    @Mapping(target = "status", source = "statusDTO")
    @Mapping(target= "tags", source = "tagDTOS")
    Task toEntityEager(TaskDTO taskDto);

}
