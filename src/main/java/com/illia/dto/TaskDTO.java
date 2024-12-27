package com.illia.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class TaskDTO implements Serializable {
    private long id;
    private String title;
    private String body;
    @JsonIgnore
    private List<Long> performerIds;  // Замість List<User> передавати список ID користувачів
    private LocalDate startDate;
    private LocalDate finishDate;
    private long createdBy;  // Замість ID "createBy" краще використовувати 'createdBy'
    private List<Long> tagIds;  // Замість List<Tag> передавати список ID тегівp
    private StatusDTO statusDTO;

}
