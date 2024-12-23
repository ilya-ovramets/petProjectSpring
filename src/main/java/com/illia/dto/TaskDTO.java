package com.illia.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class TaskDTO implements Serializable {

    private long id;
    private String title;
    private String body;
    private List<Long> performerIds;  // Замість List<User> передавати список ID користувачів
    private LocalDate startDate;
    private LocalDate finishDate;
    private long createdBy;  // Замість ID "createBy" краще використовувати 'createdBy'
    private String status;  // Використовуємо статус як String або ID
    private List<Long> tagIds;  // Замість List<Tag> передавати список ID тегів

    // Конструктори
    public TaskDTO() {}

    public TaskDTO(long id, String title, String body, List<Long> performerIds, LocalDate startDate, LocalDate finishDate, long createdBy, String status, List<Long> tagIds) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.performerIds = performerIds;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.createdBy = createdBy;
        this.status = status;
        this.tagIds = tagIds;
    }

    // Гетери та сетери
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<Long> getPerformerIds() {
        return performerIds;
    }

    public void setPerformerIds(List<Long> performerIds) {
        this.performerIds = performerIds;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Long> tagIds) {
        this.tagIds = tagIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDTO taskDTO = (TaskDTO) o;
        return id == taskDTO.id && createdBy == taskDTO.createdBy && Objects.equals(title, taskDTO.title) && Objects.equals(body, taskDTO.body) && Objects.equals(performerIds, taskDTO.performerIds) && Objects.equals(startDate, taskDTO.startDate) && Objects.equals(finishDate, taskDTO.finishDate) && Objects.equals(status, taskDTO.status) && Objects.equals(tagIds, taskDTO.tagIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, performerIds, startDate, finishDate, createdBy, status, tagIds);
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", performerIds=" + performerIds +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", createdBy=" + createdBy +
                ", status='" + status + '\'' +
                ", tagIds=" + tagIds +
                '}';
    }
}
