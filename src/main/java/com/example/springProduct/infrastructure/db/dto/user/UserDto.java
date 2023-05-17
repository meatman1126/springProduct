package com.example.springProduct.infrastructure.db.dto.user;

import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.domain.model.value.object.LoginId;
import com.example.springProduct.domain.model.value.object.UserName;
import lombok.Data;

@Data
public class UserDto {

    private Id userId;

    private UserName userName;

    private LoginId loginId;

    private String password;
}
