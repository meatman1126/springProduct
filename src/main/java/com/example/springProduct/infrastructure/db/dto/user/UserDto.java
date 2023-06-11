package com.example.springProduct.infrastructure.db.dto.user;

import com.example.springProduct.constant.code.RoleFlugEnum;
import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.domain.model.value.object.LoginId;
import com.example.springProduct.domain.model.value.object.UserName;
import com.example.springProduct.infrastructure.db.generated.GenUsers;
import com.example.springProduct.infrastructure.db.generated.Users;
import lombok.Data;

@Data
public class UserDto {

    private Id userId;

    private UserName userName;

    private LoginId loginId;

    private String password;

    private RoleFlugEnum authorityRead;

    /**
     * 更新権限
     */
    private RoleFlugEnum authorityUpdate;

    /**
     * 管理者権限
     */
    private RoleFlugEnum authorityAdmin;


    public Users toGenDto(){
        return Users.of(userId,userName,loginId,password,authorityRead,authorityUpdate,authorityAdmin);
    }
}
