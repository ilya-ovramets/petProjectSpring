package com.illia.mapper;

import com.illia.dto.TagDTO;
import com.illia.dto.TaskDTO;
import com.illia.model.Tag;
import com.illia.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel="spring")
public interface TagMapper extends EntityMapper<TagDTO,Tag>{

    @Mapping(target = "taskDTOS", source = "tasks",qualifiedByName = "toMinimalTaskDto")
    TagDTO toDtoEager(Tag tag);

    @Named("toMinimalTaskDto")
    @Mapping(target = "performerDtos", ignore = true)
    @Mapping(target = "tagDTOS", ignore = true)
    @Mapping(target = "statusDTO", ignore = true)
    TaskDTO toMinimalTaskDto(Task task);
}
