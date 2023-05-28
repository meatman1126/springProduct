package com.example.springProduct.infrastructure.db.dto.user;

import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.domain.model.value.object.LoginId;
import com.example.springProduct.domain.model.value.object.UserName;
import com.example.springProduct.infrastructure.db.generated.GenUsers;
import lombok.Data;

@Data
public class UserDto {

    private Id userId;

    private UserName userName;

    private LoginId loginId;

    private String password;

    public GenUsers toGenDto(){
        return GenUsers.builder().userId(userId).userName(userName).loginId(loginId).password(password).build();
    }
}
