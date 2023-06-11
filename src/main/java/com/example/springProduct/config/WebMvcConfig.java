package com.example.springProduct.config;

import com.example.springProduct.converter.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverter(new GenderConverter());
//        registry.addConverter(new AgeConverter());
//        registry.addConverter(new IdConverter());
//        registry.addConverter(new OrganizationNameConverter());
//        registry.addConverter(new PhoneNumberConverter());
        registry.addConverterFactory(new StringToStringValueObjectConverterFactory());
        registry.addConverterFactory(new StringToIntValueObjectConverterFactory());
        registry.addConverterFactory(new StringToShortValueObjectConverterFactory());
        registry.addConverterFactory(new StringToLongValueObjectConverterFactory());
        registry.addConverterFactory(new StringToDecimalValueObjectConverterFactory());
        registry.addConverterFactory(new StringToDateValueObjectConverterFactory());
        registry.addConverterFactory(new StringToDateTimeValueObjectConverterFactory());
    }
}
