package com.illia.mapper;

import com.illia.dto.StatusDTO;
import com.illia.model.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface StatusMapper extends EntityMapper<StatusDTO, Status>{
}
