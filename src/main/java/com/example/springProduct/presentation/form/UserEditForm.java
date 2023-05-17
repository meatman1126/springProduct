package com.example.springProduct.presentation.form;

import com.example.springProduct.domain.model.user.UserModel;
import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.domain.model.value.object.LoginId;
import com.example.springProduct.domain.model.value.object.UserName;
import com.example.springProduct.infrastructure.db.dto.user.UserDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Builder
@ToString
public class UserEditForm {

    private Id userId;

    private UserName userName;

    private LoginId loginId;


    public UserDto toDto(){
        UserDto userDto = new UserDto();
        userDto.setUserId(userId);
        userDto.setUserName(userName);
        userDto.setLoginId(loginId);
        return userDto;
    }

    public static UserEditForm convertFromDomModel(UserModel userModel){
        return UserEditForm.builder().userId(userModel.getUserId())
                .loginId(userModel.getLoginId())
                .userName(userModel.getUserName())
                .build();
    }
}
