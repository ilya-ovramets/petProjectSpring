package com.illia.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class StatusDTO implements Serializable {
    private long id;
    private String statusName;
    private List<Long> taskIds;  // Заміна на список ID завдань

    public StatusDTO() {
    }

    public StatusDTO(long id, String statusName, List<Long> taskIds) {
        this.id = id;
        this.statusName = statusName;
        this.taskIds = taskIds;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<Long> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<Long> taskIds) {
        this.taskIds = taskIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusDTO statusDTO = (StatusDTO) o;
        return id == statusDTO.id && Objects.equals(statusName, statusDTO.statusName) && Objects.equals(taskIds, statusDTO.taskIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, statusName, taskIds);
    }

    @Override
    public String toString() {
        return "StatusDTO{" +
                "id=" + id +
                ", statusName='" + statusName + '\'' +
                ", taskIds=" + taskIds +
                '}';
    }
}
