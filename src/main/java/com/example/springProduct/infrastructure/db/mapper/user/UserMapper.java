package com.example.springProduct.infrastructure.db.mapper.user;

import com.example.springProduct.domain.model.user.UserModel;
import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.domain.model.value.object.LoginId;
import com.example.springProduct.infrastructure.db.dto.user.UserDto;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    public List<UserDto> findUserInfo();

    public UserDto findUserInfoByUserId(@Param("userId") Id userId);

    public Optional<UserDto> findUserInfoByLoginId(@Param("loginId")LoginId loginId);

    public int registerUser(@Param("userDto") UserDto userDto);

    public int updateUser(@Param("userDto") UserDto userDto);

    public Id getLatestUserId();

    public void deleteUser(@Param("userId") Id userId);
}
