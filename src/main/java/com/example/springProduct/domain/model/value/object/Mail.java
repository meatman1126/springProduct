package com.example.springProduct.domain.model.value.object;


import com.example.springProduct.domain.model.value.AbstractStringValueObject;
import lombok.Value;

@Value
public class Mail extends AbstractStringValueObject<Mail> {


    public Mail(String value){super(value);}

    public static Mail of(String value){return new Mail(value);}

    @Override
    public String getLogicalName(){return "メールアドレス";}

}
