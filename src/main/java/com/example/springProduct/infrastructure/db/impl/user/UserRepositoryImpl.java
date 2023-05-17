package com.example.springProduct.infrastructure.db.impl.user;

import com.example.springProduct.domain.model.user.UserModel;
import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.domain.repostiory.user.UserRepository;
import com.example.springProduct.infrastructure.db.dto.user.UserDto;
import com.example.springProduct.infrastructure.db.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserModel> findUserInfo(){
        return userMapper.findUserInfo().stream().map(UserModel::of).collect(Collectors.toList());
    }

    @Override
    public UserModel findUserInfoByUserId(Id userId){
        return UserModel.of(userMapper.findUserInfoByUserId(userId));
    }

    @Override
    public Id registerUser(UserDto userDto){
        userMapper.registerUser(userDto);
        return userDto.getUserId();
//        return userMapper.getLatestUserId();
    }

    @Override
    public int updateUser(UserDto userDto){
        return userMapper.updateUser(userDto);
    }

    @Override
    public void deleteUser(Id userId){
        userMapper.deleteUser(userId);
    }
}
