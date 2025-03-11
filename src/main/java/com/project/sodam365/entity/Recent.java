package com.project.sodam365.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "recent")
@Getter
@Setter
public class Recent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long r_no;

    @Column(length = 30, nullable = false)
    private String r_title;

    @Column(length = 50)
    private String img;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @Column
    private LocalDateTime create_at;

    @Column
    private LocalDateTime update_at;
}
