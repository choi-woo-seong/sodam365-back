package com.project.sodam365.service;

import com.project.sodam365.dto.NuserDto;
import com.project.sodam365.dto.UserDto;
import com.project.sodam365.entity.Nuser;
import com.project.sodam365.entity.User;
import com.project.sodam365.repository.NuserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class NuserService {
    private final NuserRepository nuserRepository;
    private final PasswordEncoder passwordEncoder; // Spring에서 제공하는 비밀번호 암호화

//    // 회원가입 (비밀번호 암호화 적용)
//    public User registerUser(UserDto userDto) {
//        // 비밀번호 암호화
//        String encryptedPassword = passwordEncoder.encode(userDto.getPassword());
//
//        // DTO → 엔티티 변환 (빌더 사용)
//        User user = User.builder()
//                .userid(userDto.getUserid())
//                .password(encryptedPassword) // 암호화된 비밀번호 적용
//                .name(userDto.getName())
//                .ownername(userDto.getOwnername())
//                .ownernum(userDto.getOwnernum())
//                .ownerloc(userDto.getOwnerloc())
//                .email(userDto.getEmail())
//                .phone1(userDto.getPhone1())
//                .phone2(userDto.getPhone2())
//                .build();
//
//        return userRepository.save(user);
//    }

    // 로그인 검증
    public boolean login(String userid, String rawPassword) {
        Nuser nuser = nuserRepository.findById(userid)
                .orElseThrow(() -> new RuntimeException("사용자 없음"));

        // 입력된 비밀번호(rawPassword)와 저장된 암호화된 비밀번호 비교
        return passwordEncoder.matches(rawPassword, nuser.getN_password());
    }

    // 모든 사용자 조회
    public List<Nuser> getAllUsers() {
        return nuserRepository.findAll();
    }

    // 새로운 사용자 생성 (비밀번호 암호화 포함)
    public void createUser(NuserDto dto) {
        String encryptedPassword = passwordEncoder.encode(dto.getN_password());

        // DTO → 엔티티 변환
        Nuser user = Nuser.builder()
                .n_userid(dto.getN_userid())
                .n_password(encryptedPassword) // 암호화된 비밀번호 적용
                .n_name(dto.getN_name())
                .n_email(dto.getN_email())
                .address(dto.getAddress())
                .n_phone1(dto.getN_phone1())
                .build();

        nuserRepository.save(user);
    }

    public boolean existsById(String n_userid) {
        return nuserRepository.existsById(n_userid);
    }
}