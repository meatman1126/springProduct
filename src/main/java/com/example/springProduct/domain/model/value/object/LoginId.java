package com.example.springProduct.domain.model.value.object;


import com.example.springProduct.domain.model.value.AbstractStringValueObject;
import lombok.Value;

@Value
public class LoginId extends AbstractStringValueObject<LoginId> {


    public LoginId(String value){super(value);}

    public static LoginId of(String value){return new LoginId(value);}

    @Override
    public String getLogicalName(){return "ログインID";}

}
