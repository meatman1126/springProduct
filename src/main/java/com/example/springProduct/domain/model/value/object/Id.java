package com.example.springProduct.domain.model.value.object;


import com.example.springProduct.domain.model.value.AbstractLongValueObject;
import lombok.Value;

@Value
public class Id extends AbstractLongValueObject<Id> {

    public Id(Long value){super(value);}
    public static Id of(Long value){return new Id(value);}

    public String getLogicalName(){return "ID";}

}
