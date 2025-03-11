package com.project.sodam365.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "biz")
@Getter
@Setter
public class Biz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(length = 30, nullable = false)
    private String b_title;

    @Column(length = 500, nullable = false)
    private String b_contents;

    @Column(length = 50)
    private String img;

    @Column(length = 100, nullable = false)
    private String b_link;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @Column
    private LocalDateTime create_at;

    @Column
    private LocalDateTime update_at;
}
