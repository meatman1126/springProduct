package com.example.springProduct.framework.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Locale;

@Controller
@Slf4j
public class LoginController {

    @Autowired
    private MessageSource messageSource;

    /**
     * ログイン処理
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * ログイン成功後処理
     */
    @RequestMapping("/login/success")
    public String successLogin(){
        return "redirect:" + "/user/list";
    }

    @RequestMapping("/login/error")
    public String failureLogin(Model model){
        model.addAttribute("errors", Collections.singletonList(messageSource.getMessage("message.E0001",null,Locale.JAPAN)));
        return "login";
    }

}
