package com.project.sodam365.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "answer")
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(length = 30, nullable = false)
    private String a_title;

    @Column(length = 500, nullable = false)
    private String a_contents;

    @Column(length = 500, nullable = false)
    private String answer;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @Column
    private LocalDateTime create_at;

    @Column
    private LocalDateTime update_at;
}
