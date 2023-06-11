package com.example.springProduct.service;

import com.example.springProduct.domain.model.user.UserModel;
import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.domain.model.value.object.LoginId;
import com.example.springProduct.domain.repostiory.user.UserRepository;
import com.example.springProduct.infrastructure.db.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public List<UserModel> findUserInfo(){
        return userRepository.findUserInfo();
    }

    public UserModel findUserInfoByUserId(Id userId){
        return userRepository.findUserInfoByUserId(userId);
    }

    public Optional<UserModel> findUserInfoByLoginId(LoginId loginId){
        return userRepository.findUserInfoByLoginId(loginId);
    }

    public Id registerUser(UserDto dto)throws IllegalArgumentException{
        Optional<UserModel> optUser = userRepository.findUserInfoByLoginId(dto.getLoginId());
        if (optUser.isPresent()){
            throw new IllegalArgumentException("入力されたログインIDは既に使用されています。");
        }
        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        UserDto userDto = new UserDto();
        userDto.setLoginId(dto.getLoginId());
        userDto.setUserName(dto.getUserName());
        userDto.setPassword(encodedPassword);
        return userRepository.registerUser(userDto);
    }

    public int updateUser(UserDto userDto){
        return userRepository.updateUser(userDto);
    }


    public void deleteUser(Id userId){
        userRepository.deleteUser(userId);
    }
}
