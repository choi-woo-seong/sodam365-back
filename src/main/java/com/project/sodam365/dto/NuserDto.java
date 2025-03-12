package com.project.sodam365.dto;

import com.project.sodam365.entity.Nuser;
import com.project.sodam365.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NuserDto {
    private String n_userid;
    private String n_password;
    private String n_name;
    private String address;
    private String n_email;
    private String n_phone1;

    // User 엔티티 → UserDto 변환
    public static NuserDto fromUserEntity(Nuser user) {
        return NuserDto.builder()
                .n_userid(user.getN_userid())
                .n_password(user.getN_password())
                .n_name(user.getN_name())
                .n_email(user.getN_email())
                .address(user.getAddress())
                .n_phone1(user.getN_phone1())
                .build();
    }

    // UserDto → User 엔티티 변환 (빌더 패턴 적용)
    public static Nuser fromUserDto(NuserDto userDto) {
        return Nuser.builder()
                .n_userid(userDto.getN_userid())
                .n_password(userDto.getN_password())
                .n_name(userDto.getN_name())
                .n_email(userDto.getN_email())
                .address(userDto.getAddress())
                .n_phone1(userDto.getN_phone1())
                .build();
    }
}
