package com.example.springProduct.domain.model.user;

import com.example.springProduct.constant.code.RoleFlugEnum;
import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.domain.model.value.object.LoginId;
import com.example.springProduct.domain.model.value.object.UserName;
import com.example.springProduct.infrastructure.db.dto.user.UserDto;
import com.example.springProduct.infrastructure.db.generated.GenUsers;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRoles {

    /**
     * 参照権限
     */
    private RoleFlugEnum authorityRead;

    /**
     * 更新権限
     */
    private RoleFlugEnum authorityUpdate;

    /**
     * 管理者権限
     */
    private RoleFlugEnum authorityAdmin;

}
