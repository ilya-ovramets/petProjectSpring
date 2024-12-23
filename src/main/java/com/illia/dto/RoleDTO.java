package com.illia.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class RoleDTO implements Serializable {
    private long id;
    private String name;
    private List<Long> userIds;  // Список ID користувачів

    public RoleDTO() { }

    public RoleDTO(long id, String name, List<Long> userIds) {
        this.id = id;
        this.name = name;
        this.userIds = userIds;
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

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleDTO roleDTO = (RoleDTO) o;
        return id == roleDTO.id && Objects.equals(name, roleDTO.name) && Objects.equals(userIds, roleDTO.userIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userIds);
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userIds=" + userIds +
                '}';
    }
}
