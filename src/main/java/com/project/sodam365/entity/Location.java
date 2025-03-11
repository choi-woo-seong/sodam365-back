package com.project.sodam365.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "location")
@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(length = 100, nullable = false)
    private String loc;

    @Column(nullable = false)
    private double x_info;

    @Column(nullable = false)
    private double y_info;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @Column
    private LocalDateTime create_at;

    @Column
    private LocalDateTime update_at;
}
