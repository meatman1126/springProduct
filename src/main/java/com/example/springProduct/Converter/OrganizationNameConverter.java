package com.example.springProduct.Converter;

import com.example.springProduct.domain.model.value.object.OrganizationName;
import org.springframework.core.convert.converter.Converter;

public class OrganizationNameConverter implements Converter<String, OrganizationName> {

    @Override
    public OrganizationName convert(String source) {
        return new OrganizationName(source);
    }

}
