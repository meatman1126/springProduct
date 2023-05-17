package com.example.springProduct.domain.model.value.object;


import com.example.springProduct.domain.model.value.AbstractShortValueObject;
import lombok.Value;

@Value
public class Age extends AbstractShortValueObject<Age> {

    public Age(Short value){super(value);}

    public static Age of(Short value){
        if (value > 999){
            throw new IllegalArgumentException("年齢は999以上の数値は無効です。");
        }
        return new Age(value);
    }

    public String getLogicalName(){return "年齢";}

}
