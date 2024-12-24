package com.illia.dto;

import java.util.List;

public class UserDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Long> taskIds;  // Замість списку Task, краще передавати список їх ID
    private String password;
    private String roleName;  // Передавати тільки ID ролі, якщо це потрібно

    // Конструктори
    public UserDTO() {}

    public UserDTO(long id, String firstName, String lastName, String email, List<Long> taskIds, String password, String roleName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.taskIds = taskIds;
        this.password = password;
        this.roleName = roleName;
    }

    // Гетери та сетери
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<Long> taskIds) {
        this.taskIds = taskIds;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
