package com.example.springProduct.domain.model.value.object;

import com.example.springProduct.domain.model.value.AbstractStringValueObject;
import lombok.Value;

@Value
public class Address extends AbstractStringValueObject<Address>{

    public Address(String value){super(value);}

    public static Address of(String value){return new Address(value);}

    @Override
    public String getLogicalName(){return "住所";}

}
