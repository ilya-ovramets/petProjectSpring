package com.illia.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<TaskDTO> taskDTOS;  // Замість списку Task, краще передавати список їх ID
    private RoleDTO role;  // Передавати тільки ID ролі, якщо це потрібно

}
