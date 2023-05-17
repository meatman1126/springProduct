package com.example.springProduct.presentation.Controller;

import com.example.springProduct.Service.UserService;
import com.example.springProduct.domain.model.user.UserModel;
import com.example.springProduct.domain.model.value.object.Id;
import com.example.springProduct.infrastructure.db.dto.user.UserDto;
import com.example.springProduct.presentation.form.UserEditForm;
import com.example.springProduct.presentation.form.UserRegisterForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * ユーザ一覧画面を表示します。
     */
    @RequestMapping("/user/list")
    public String list(Model model){

        List<UserModel> userModelList = userService.findUserInfo();
        model.addAttribute("userInfo", userModelList);
        return "user/list";
    }
    /**
     * ユーザ登録画面を表示します。
     */
    @RequestMapping("/user/new")
    public String form(Model model){

        model.addAttribute("form", new UserRegisterForm());
        return "user/new";
    }
    /**
     * ユーザを新規登録します。
     */
    @RequestMapping("/user/register")
    public String register(UserRegisterForm form){

        UserDto userDto = form.toDto();
        Id userId = userService.registerUser(userDto);
        return "redirect:/user/list";
    }
    /**
     * ユーザを新規登録します。
     */
    @RequestMapping("/user/update")
    public String update(UserEditForm form){

        UserDto userDto = form.toDto();
        userService.updateUser(userDto);
        return "redirect:/user/list";
    }
    /**
     * ユーザ編集画面を表示します。
     */
    @RequestMapping("/user/edit/{userId}")
    public String show(@PathVariable("userId") Id userId, Model model){
        UserModel userModel = userService.findUserInfoByUserId(userId);
        UserEditForm userEditForm = UserEditForm.convertFromDomModel(userModel);
        model.addAttribute("form", userEditForm);
        return "user/edit";
    }

    /**
     * ユーザを削除します。
     */
    @RequestMapping("/user/delete/{userId}")
    public String delete(@PathVariable("userId") Id userId, Model model){
        userService.deleteUser(userId);
        return "redirect:/user/list";
    }
}
