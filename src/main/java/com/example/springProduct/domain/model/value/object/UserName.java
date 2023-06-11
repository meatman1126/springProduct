package com.example.springProduct.domain.model.value.object;


import com.example.springProduct.domain.model.value.AbstractStringValueObject;
import lombok.Value;

@Value
public class UserName extends AbstractStringValueObject<UserName> {


    public UserName(String value){super(value);}

    public static UserName of(String value){return new UserName(value);}

    @Override
    public String getLogicalName(){return "ユーザ名";}

    @Override
    public String toString(){return super.toString();}


}
