package com.example.springProduct.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.formLogin(login -> login

                //指定したURLがリクエストされるとログイン認証を行う
                .loginProcessingUrl("/login")
                //ログイン時のURLの指定
                .loginPage("/login")

                //ユーザ名とパスワードが入力されるフィールド名
                .usernameParameter("user")
                .passwordParameter("password")

                //ログイン成功時のURL
                .defaultSuccessUrl("/login/success")

                //ログイン失敗時のURL
                .failureUrl("/login/error")

                //全てのユーザがアクセス可能
                .permitAll()
        ).logout(logout -> logout

                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll()
        ).authorizeHttpRequests(ahr -> {
            ahr
                    .requestMatchers("/login", "/login" + "?**")
                    .permitAll()
                    .requestMatchers("/logout")
                    .permitAll()
                    .anyRequest()
                    .authenticated();
        });

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
}
