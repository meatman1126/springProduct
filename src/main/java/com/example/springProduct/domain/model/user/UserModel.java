package com.example.springProduct.domain.model.user;

import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.domain.model.value.object.LoginId;
import com.example.springProduct.domain.model.value.object.UserName;
import com.example.springProduct.infrastructure.db.dto.user.UserDto;
import com.example.springProduct.infrastructure.db.generated.GenUsers;
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

    public static UserModel of(GenUsers users){
        return UserModel.builder()
                .userId(users.getUserId())
                .userName(users.getUserName())
                .loginId(users.getLoginId())
                .password(users.getPassword())
                .build();
    }

}
