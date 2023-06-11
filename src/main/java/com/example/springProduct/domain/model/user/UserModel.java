package com.example.springProduct.domain.model.user;

import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.domain.model.value.object.LoginId;
import com.example.springProduct.domain.model.value.object.UserName;
import com.example.springProduct.infrastructure.db.dto.user.UserDto;
import com.example.springProduct.infrastructure.db.generated.GenUsers;
import com.example.springProduct.infrastructure.db.generated.Users;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {

    private Id userId;

    private UserName userName;

    private LoginId loginId;

    private String password;

    private UserRoles userRoles;

    public static UserModel of(UserDto userDto) {
        return UserModel.builder()
                .userId(userDto.getUserId())
                .userName(userDto.getUserName())
                .loginId(userDto.getLoginId())
                .password(userDto.getPassword())
                .userRoles(convertRoleFromDto(userDto)).build();
    }

    public static UserModel of(Users users) {
        return UserModel.builder()
                .userId(users.getUserId())
                .userName(users.getUserName())
                .loginId(users.getLoginId())
                .password(users.getPassword())
                .build();
    }

    private static UserRoles convertRoleFromDto(UserDto userDto) {
        return UserRoles.builder().
                authorityRead(userDto.getAuthorityRead())
                .authorityUpdate(userDto.getAuthorityUpdate())
                .authorityAdmin(userDto.getAuthorityAdmin())
                .build();
    }

}
