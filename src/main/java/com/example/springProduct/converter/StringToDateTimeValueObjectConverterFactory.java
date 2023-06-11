package com.example.springProduct.converter;

import com.example.springProduct.domain.model.value.AbstractDateTimeValueObject;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>文字列を日時型 Value Object に変換するConverterのファクトリクラスです。</p>
 */
@Slf4j
public class StringToDateTimeValueObjectConverterFactory implements ConverterFactory<String, AbstractDateTimeValueObject<?>> {

    @Override
    public <T extends AbstractDateTimeValueObject<?>> Converter<String, T> getConverter(@NonNull Class<T> targetType){
        return new StringToDateTimeValueObjectConverter<>(targetType);
    }


    /**
     * <p>文字列を数値型 Value Object に変換するConverterクラスです。</p>
     * @param <T> 文字列 Value Object の型
     */
    private static final class StringToDateTimeValueObjectConverter<T extends AbstractDateTimeValueObject<?>> implements Converter<String, T>{

        /**
         * 日時 Value Object の型
         */
        private final Class<T> valueType;

        /**
         * <p>指定された型への変換を行うこのクラスの新しいインスタンスを初期化します。</p>
         * @param valueType 変換先の Value Object の型
         *
         */
        private StringToDateTimeValueObjectConverter(Class<T> valueType){
            this.valueType = valueType;
        }

        @Override
        public T convert(String source){
            if (source.isEmpty()){
                return null;
            }

            LocalDateTime value = LocalDateTime.parse(source, DateTimeFormatter.ISO_DATE_TIME);
            try {
                return valueType.getConstructor(LocalDateTime.class).newInstance(value);
            }catch (NoSuchMethodException | InstantiationException | IllegalAccessException e){
                throw new BeanInstantiationException(valueType, "instantiation failed", e);
            }catch (InvocationTargetException e){
                Throwable targetException = e.getTargetException();
                if (targetException instanceof IllegalArgumentException){
                    log.warn(targetException.getMessage(), targetException);
                }
                throw new BeanInstantiationException(valueType, e.getMessage(), e);
            }
        }
    }
}
