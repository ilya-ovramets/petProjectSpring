package com.illia.mapper;

import com.illia.dto.StatusDTO;
import com.illia.model.Status;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface StatusMapper {
    StatusDTO toDTO(Status status);
    Status toEntity(StatusDTO statusDTO);
}
