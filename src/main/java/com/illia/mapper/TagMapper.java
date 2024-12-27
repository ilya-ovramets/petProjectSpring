package com.illia.mapper;

import com.illia.dto.TagDTO;
import com.illia.model.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface TagMapper extends EntityMapper<TagDTO,Tag>{

}
