package com.example.springProduct.domain.model.value.object;

import com.example.springProduct.domain.model.value.AbstractStringValueObject;
import lombok.Value;

@Value
public class OrganizationName extends AbstractStringValueObject<OrganizationName> {

    public OrganizationName(String value){super(value);}
    public static OrganizationName of(String value){
        if (value.length() > 50){
            throw new IllegalArgumentException("組織名称は50文字以上は無効です。");
        }
        return new OrganizationName(value);
    }

    public String getLogicalName(){return "組織名称";}

}
