package com.illia.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import lombok.*;

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
    @Email
    private String email;
    private List<TaskDTO> taskDTOS;  // Замість списку Task, краще передавати список їх ID
    private RoleDTO roleDTO;  // Передавати тільки ID ролі, якщо це потрібно
    @JsonIgnore
    private String password;

}
