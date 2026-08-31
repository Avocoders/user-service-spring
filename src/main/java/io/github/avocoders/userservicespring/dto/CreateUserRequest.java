package io.github.avocoders.userservicespring.dto;

public class CreateUserRequest {
    private String name;
    private String email;
    private Integer age;

    public CreateUserRequest() {}

    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public String getEmail() {
        return this.email;
    }
    public Integer getAge() {
        return this.age;
    }

}
