package com.example.springProduct.infrastructure.db.generated;

import com.example.springProduct.constant.code.RoleFlugEnum;
import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.domain.model.value.object.LoginId;
import com.example.springProduct.domain.model.value.object.UserName;
import lombok.Data;
import lombok.Value;

/**
 * Table: users
 */
@Data
@Value(staticConstructor = "of")
public class Users {
    /**
     * Column: user_id
     * Type: INT
     */
    private Id userId;

    /**
     * Column: user_name
     * Type: VARCHAR(20)
     */
    private UserName userName;

    /**
     * Column: login_id
     * Type: VARCHAR(20)
     */
    private LoginId loginId;

    /**
     * Column: password
     * Type: VARCHAR(100)
     */
    private String password;

    /**
     * Column: authority_read
     * Type: BIT
     * Default value: 0
     */
    private RoleFlugEnum authorityRead;

    /**
     * Column: authority_update
     * Type: BIT
     * Default value: 0
     */
    private RoleFlugEnum authorityUpdate;

    /**
     * Column: authority_admin
     * Type: BIT
     * Default value: 0
     */
    private RoleFlugEnum authorityAdmin;
}