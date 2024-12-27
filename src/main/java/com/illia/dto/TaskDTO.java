package com.illia.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskDTO implements Serializable {
    private long id;
    private String title;
    private String body;
    private List<UserDTO> performerDtos;  // Замість List<User> передавати список ID користувачів
    private LocalDate startDate;
    private LocalDate finishDate;
    private long createBy;  // Замість ID "createBy" краще використовувати 'createdBy'
    private List<TagDTO> tagDTOS;  // Замість List<Tag> передавати список ID тегівp
    private StatusDTO statusDTO;

}
