package com.example.springProduct.converter;

import com.example.springProduct.domain.model.value.object.PhoneNumber;
import org.springframework.core.convert.converter.Converter;

public class PhoneNumberConverter implements Converter<String, PhoneNumber> {

    @Override
    public PhoneNumber convert(String source) {
        return new PhoneNumber(source);
    }

}
