package com.illia.mapper;

import com.illia.dto.TagDTO;
import com.illia.model.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface TagMapper {
    TagDTO toDTO(Tag tag);
    Tag toEntity(TagDTO tagDTO);
}
