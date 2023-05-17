package com.example.springProduct.Service;

import com.example.springProduct.domain.model.user.UserModel;
import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.domain.repostiory.user.UserRepository;
import com.example.springProduct.infrastructure.db.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public List<UserModel> findUserInfo(){
        return userRepository.findUserInfo();
    }

    public UserModel findUserInfoByUserId(Id userId){
        return userRepository.findUserInfoByUserId(userId);
    }

    public Id registerUser(UserDto userDto){
        return userRepository.registerUser(userDto);
    }

    public int updateUser(UserDto userDto){
        return userRepository.updateUser(userDto);
    }


    public void deleteUser(Id userId){
        userRepository.deleteUser(userId);
    }
}
