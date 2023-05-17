package com.example.springProduct.Converter;

import com.example.springProduct.domain.model.value.object.Age;
import org.springframework.core.convert.converter.Converter;

public class AgeConverter implements Converter<String, Age> {

    @Override
    public Age convert(String source) {
        return new Age(Short.valueOf(source));
    }

}
