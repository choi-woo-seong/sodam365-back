package com.project.sodam365.entity;

import com.project.sodam365.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "b_user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseTimeEntity {

    @Id
    @Column(length = 50, nullable = false, updatable = false)
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

    // 엔티티 저장 전, UUID 자동 생성
    @PrePersist
    public void generateId() {
        if (this.userid == null || this.userid.isEmpty()) {
            this.userid = UUID.randomUUID().toString();
        }
    }

    // 비밀번호 설정 (암호화 적용)
    public void encodePassword(String encodedPassword) {
        this.password = encodedPassword;
    }
}
