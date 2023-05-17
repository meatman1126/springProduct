package com.example.springProduct.domain.model.value.object;

import com.example.springProduct.domain.model.value.AbstractStringValueObject;
import lombok.Value;

@Value
public class PhoneNumber extends AbstractStringValueObject<PhoneNumber> {

    public PhoneNumber(String value) {super(value);}
    public static PhoneNumber of(String value){return new PhoneNumber(value);}

    public String getLogicalName(){return "電話番号";}

}
