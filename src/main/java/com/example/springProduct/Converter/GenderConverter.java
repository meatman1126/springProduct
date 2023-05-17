package com.example.springProduct.Converter;

import com.example.springProduct.domain.model.value.object.GenderEnum;
import org.springframework.core.convert.converter.Converter;

public class GenderConverter implements Converter<String, GenderEnum> {

    @Override
    public GenderEnum convert(String source) {
        return GenderEnum.codeOf(source);
    }

}
