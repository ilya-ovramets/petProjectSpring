package com.illia.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDTO implements Serializable {
    private long id;
    private String name;
    @JsonIgnore
    private List<UserDTO> userDTOS;  // Список ID користувачів
}
