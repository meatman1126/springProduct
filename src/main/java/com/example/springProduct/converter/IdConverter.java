package com.example.springProduct.converter;

import com.example.springProduct.domain.model.value.object.Id;
import org.springframework.core.convert.converter.Converter;

public class IdConverter implements Converter<String, Id> {

    @Override
    public Id convert(String source) {
        return new Id(Long.valueOf(source));
    }

}
