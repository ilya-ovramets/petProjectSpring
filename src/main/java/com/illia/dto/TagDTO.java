package com.illia.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TagDTO implements Serializable {

    private long id;
    private String name;
    @JsonIgnore
    private List<TaskDTO> taskDTOS;  // Список ID замість об'єктів Task
}
