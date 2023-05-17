package com.example.springProduct.Converter;

import com.example.springProduct.domain.model.value.AbstractStringValueObject;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

import java.lang.reflect.InvocationTargetException;

/**
 * <p>文字列を文字列型 Value Object に変換するConverterのファクトリクラスです。</p>
 */
@Slf4j
public class StringToStringValueObjectConverterFactory implements ConverterFactory<String, AbstractStringValueObject<?>> {

    @Override
    public <T extends AbstractStringValueObject<?>> Converter<String, T> getConverter(@NonNull Class<T> targetType){
        return new StringToStringValueObjectConverter<>(targetType);
    }


    /**
     * <p>文字列を文字列型 Value Object に変換するConverterクラスです。</p>
     * @param <T> 文字列 Value Object の型
     */
    private static final class StringToStringValueObjectConverter<T extends AbstractStringValueObject<?>> implements Converter<String, T>{

        /**
         * 文字列 Value Object の型
         */
        private final Class<T> valueType;

        /**
         * <p>指定された型への変換を行うこのクラスの新しいインスタンスを初期化します。</p>
         * @param valueType 変換先の Value Object の型
         *
         */
        private StringToStringValueObjectConverter(Class<T> valueType){
            this.valueType = valueType;
        }

        @Override
        public T convert(String source){
            if (source.isEmpty()){
                return null;
            }

            try {
                return valueType.getConstructor(String.class).newInstance(source);
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
