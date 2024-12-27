package com.illia.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoleDTO implements Serializable {
    private long id;
    private String name;
    @JsonIgnore
    private List<UserDTO> users;  // Список ID користувачів


}
