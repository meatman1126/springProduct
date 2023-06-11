package com.example.springProduct.presentation.form.user;

import com.example.springProduct.domain.model.value.object.*;
import com.example.springProduct.infrastructure.db.dto.user.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class UserRegisterForm {

    private Id userId;

    private UserName userName;

    private LoginId loginId;

    private String password;

    public UserDto toDto(){
        UserDto userDto = new UserDto();
        userDto.setUserName(userName);
        userDto.setLoginId(loginId);
        userDto.setPassword(password);
        return userDto;
    }

    public UserRegisterForm of(UserDto userDto){
        UserRegisterForm userRegisterForm = new UserRegisterForm();
        userRegisterForm.setUserId(userDto.getUserId());
        userRegisterForm.setUserName(userDto.getUserName());
        userRegisterForm.setLoginId(userDto.getLoginId());
        userRegisterForm.setPassword(userDto.getPassword());
        return userRegisterForm;
    }
}
