package com.example.springProduct.domain.model.value;

/**
 * <p>文字列を値として保持する Value Object の基底クラスです。</p>
 * @param <T> Value Object 具象型
 */
public abstract class AbstractStringValueObject<T extends AbstractStringValueObject<T>>
        extends AbstractValueObject<String>{

    /**
     * <p>指定された値でこのクラスの新しいインスタンスを初期化します。</p>
     * @param value 値
     */
    protected AbstractStringValueObject(String value){super(value);}
}
