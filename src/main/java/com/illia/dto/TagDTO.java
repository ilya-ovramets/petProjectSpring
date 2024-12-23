package com.illia.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class TagDTO implements Serializable {

    private long id;
    private String name;
    private List<Long> taskIds;  // Список ID замість об'єктів Task

    public TagDTO(long id, String name, List<Long> taskIds) {
        this.id = id;
        this.name = name;
        this.taskIds = taskIds;
    }

    public TagDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        TagDTO tagDTO = (TagDTO) o;
        return id == tagDTO.id && Objects.equals(name, tagDTO.name) && Objects.equals(taskIds, tagDTO.taskIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, taskIds);
    }

    @Override
    public String toString() {
        return "TagDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", taskIds=" + taskIds +
                '}';
    }
}
