package com.example.springProduct.converter;

import com.example.springProduct.domain.model.value.object.OrganizationName;
import org.springframework.core.convert.converter.Converter;

public class OrganizationNameConverter implements Converter<String, OrganizationName> {

    @Override
    public OrganizationName convert(String source) {
        return new OrganizationName(source);
    }

}
