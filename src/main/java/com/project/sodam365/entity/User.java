package com.project.sodam365.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @Column(length = 50, nullable = false)
    private String userid;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String ownername;

    @Column(length = 20, nullable = false)
    private String ownernum;

    @Column(length = 100, nullable = false)
    private String ownerloc;

    @Column(length = 30)
    private String email;

    @Column(length = 20, nullable = false)
    private String phone1;

    @Column(length = 20)
    private String phone2;

    @Column
    private LocalDateTime create_at;

    @Column
    private LocalDateTime update_at;
}
