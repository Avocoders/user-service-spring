package io.github.avocoders.userservicespring.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    Integer age;
    @Column(name="created_at")
    LocalDateTime createdAt;

}
