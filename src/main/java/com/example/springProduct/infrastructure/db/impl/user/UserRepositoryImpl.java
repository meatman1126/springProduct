package com.example.springProduct.infrastructure.db.impl.user;

import com.example.springProduct.domain.model.user.UserModel;
import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.domain.model.value.object.LoginId;
import com.example.springProduct.domain.repostiory.user.UserRepository;
import com.example.springProduct.infrastructure.db.dto.user.UserDto;
import com.example.springProduct.infrastructure.db.generated.GenUsers;
import com.example.springProduct.infrastructure.db.mapper.generated.GenUsersMapper;
import com.example.springProduct.infrastructure.db.mapper.generated.UsersMapper;
import com.example.springProduct.infrastructure.db.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UsersMapper genUsersMapper;

    @Override
    public List<UserModel> findUserInfo(){
        return userMapper.findUserInfo().stream().map(UserModel::of).collect(Collectors.toList());
    }

//    @Override
//    public UserModel findUserInfoByUserId(Id userId){
//        return UserModel.of(genUsersMapper.selectByPrimaryKey(userId));
//    }

    @Override
    public UserModel findUserInfoByUserId(Id userId){
        return UserModel.of(genUsersMapper.selectByPrimaryKey(userId));
    }

    @Override
    public Optional<UserModel> findUserInfoByLoginId(LoginId loginId){
        Optional<UserDto> optUser = userMapper.findUserInfoByLoginId(loginId);
        return optUser.map(UserModel::of);
    }
    @Override
    public Id registerUser(UserDto userDto){
        userMapper.registerUser(userDto);
        return userDto.getUserId();
    }

    @Override
    public int updateUser(UserDto userDto){
        return genUsersMapper.updateByPrimaryKeySelective(userDto.toGenDto());
    }

    @Override
    public void deleteUser(Id userId){
        userMapper.deleteUser(userId);
    }
}
