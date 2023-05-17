package com.example.springProduct.domain.model.user;

import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.domain.model.value.object.LoginId;
import com.example.springProduct.domain.model.value.object.UserName;
import com.example.springProduct.infrastructure.db.dto.user.UserDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {

    private Id userId;

    private UserName userName;

    private LoginId loginId;

    private String password;

    public static UserModel of(UserDto userDto) {
        return UserModel.builder()
                .userId(userDto.getUserId())
                .userName(userDto.getUserName())
                .loginId(userDto.getLoginId())
                .password(userDto.getPassword()).build();
    }

}
