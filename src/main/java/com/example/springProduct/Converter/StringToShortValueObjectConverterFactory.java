package com.example.springProduct.Converter;

import com.example.springProduct.domain.model.value.AbstractShortValueObject;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.util.NumberUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * <p>文字列を数値型 Value Object に変換するConverterのファクトリクラスです。</p>
 */
@Slf4j
public class StringToShortValueObjectConverterFactory implements ConverterFactory<String, AbstractShortValueObject<?>> {

    @Override
    public <T extends AbstractShortValueObject<?>> Converter<String, T> getConverter(@NonNull Class<T> targetType){
        return new StringToShortValueObjectConverter<>(targetType);
    }


    /**
     * <p>文字列を数値型 Value Object に変換するConverterクラスです。</p>
     * @param <T> 文字列 Value Object の型
     */
    private static final class StringToShortValueObjectConverter<T extends AbstractShortValueObject<?>> implements Converter<String, T>{

        /**
         * 数値 Value Object の型
         */
        private final Class<T> valueType;

        /**
         * <p>指定された型への変換を行うこのクラスの新しいインスタンスを初期化します。</p>
         * @param valueType 変換先の Value Object の型
         *
         */
        private StringToShortValueObjectConverter(Class<T> valueType){
            this.valueType = valueType;
        }

        @Override
        public T convert(String source){
            if (source.isEmpty()){
                return null;
            }

            Short value = NumberUtils.parseNumber(source, Short.class);
            try {
                return valueType.getConstructor(Short.class).newInstance(value);
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
