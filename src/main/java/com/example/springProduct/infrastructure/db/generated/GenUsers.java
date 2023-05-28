package com.example.springProduct.infrastructure.db.generated;

import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.domain.model.value.object.LoginId;
import com.example.springProduct.domain.model.value.object.UserName;
import lombok.Builder;
import lombok.Data;

/**
 * Table: users
 */
@Data
@Builder
public class GenUsers {
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
}