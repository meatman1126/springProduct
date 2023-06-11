package com.example.springProduct.framework.login;

import com.example.springProduct.constant.code.RoleFlugEnum;
import com.example.springProduct.domain.model.user.UserRoles;
import com.example.springProduct.service.UserService;
import com.example.springProduct.domain.model.user.UserModel;
import com.example.springProduct.domain.model.value.object.LoginId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    @Autowired
    private final UserService userService;

    /**
     *
     * @param inputLoginId 入力されたログインID
     * @return ログインユーザ情報
     * @throws UsernameNotFoundException ユーザが見つからない場合の例外
     */
    @Override
    public UserDetails loadUserByUsername(String inputLoginId) throws UsernameNotFoundException{
        Optional<UserModel> optionalUser = userService.findUserInfoByLoginId(new LoginId(inputLoginId));

        if (optionalUser.isEmpty()){
            throw new UsernameNotFoundException("user not found");
        }

        UserModel userModel = optionalUser.get();
        LoginUser loginUser = new LoginUser(inputLoginId,userModel.getPassword(), createRoleList(userModel.getUserRoles()));
        loginUser.setUserId(userModel.getUserId().getValue());
        loginUser.setDisplayUserName(userModel.getUserName().getValue());

        return loginUser;
    }

    private List<GrantedAuthority> createRoleList(UserRoles userRoles){
        return createRoleList(createRoleNameSet(userRoles));
    }

    private List<GrantedAuthority> createRoleList(Set<String> roles){
        List<GrantedAuthority> authorities = new ArrayList<>(roles.size());
        for(String role : roles){
            Assert.isTrue(!role.startsWith("ROLE_"),
                    () -> role + "cannot start with ROLE_ (is is automatically added)");
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
        return authorities;
    }

    private Set<String> createRoleNameSet(UserRoles roles){
        Set<String>  roleSet = new HashSet<>();

        Field[] fields = roles.getClass().getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);

            String fieldName = field.getName();
            Class<?> fieldClass = field.getType();

            if (!isRoleField(fieldName, fieldClass)){
                continue;
            }

            RoleFlugEnum value;
            try {
                value = (RoleFlugEnum) field.get(roles);
                if (value.isValid()){
                    roleSet.add(fieldName);
                }
            }catch (IllegalArgumentException | IllegalAccessException e){
                log.warn("Can't get" + fieldName + "from roles");

            }
        }
        return roleSet;
    }

    //今後UserRolesクラスに権限以外のフィールドが追加された場合本メソッドで抽出しfalseを返却する
    private boolean isRoleField(String fieldName, Class<?> cls){
        return true;
    }
}
