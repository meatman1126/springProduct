package com.example.springProduct.domain.repostiory.user;

import com.example.springProduct.domain.model.user.UserModel;
import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.infrastructure.db.dto.user.UserDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    public List<UserModel> findUserInfo();

    public UserModel findUserInfoByUserId(Id userId);

    public Id registerUser(UserDto userDto);

    public int updateUser(UserDto userDto);

    public void deleteUser(Id userId);
}
