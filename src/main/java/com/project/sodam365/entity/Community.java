package com.project.sodam365.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "community")
@Getter
@Setter
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(length = 30, nullable = false)
    private String cTitle;

    @Column(length = 500, nullable = false)
    private String cContents;

    @Column(length = 500)
    private String cComment;

    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @Column
    private String createAt;

    @Column
    private String updateAt;
}
