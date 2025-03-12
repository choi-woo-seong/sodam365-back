package com.project.sodam365.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "user")
@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nuser extends BaseTimeEntity {

    @Id
    @Column(length = 50, nullable = false, updatable = false)
    private String n_userid;

    @Column(length = 100, nullable = false)
    private String n_password;

    @Column(length = 30, nullable = false)
    private String n_name;

    @Column(length = 30)
    private String n_email;

    @Column(length = 100, nullable = false)
    private String address;

    @Column(length = 20, nullable = false)
    private String n_phone1;


    // 엔티티 저장 전, UUID 자동 생성
    @PrePersist
    public void generateId() {
        if (this.n_userid == null || this.n_userid.isEmpty()) {
            this.n_userid = UUID.randomUUID().toString();
        }
    }

    // 비밀번호 설정 (암호화 적용)
    public void encodePassword(String encodedPassword) {
        this.n_password = encodedPassword;
    }
}
