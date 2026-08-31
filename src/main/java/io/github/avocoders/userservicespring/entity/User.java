package io.github.avocoders.userservicespring.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Integer age;
    @Column(name="created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public User() {}

    public User(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

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
    public Long getId() {
        return this.id;
    }
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @PrePersist
    private void initializeCreatedAt() {
        createdAt = LocalDateTime.now();
    }

}
