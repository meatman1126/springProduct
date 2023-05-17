package com.example.springProduct.domain.model.value;

/**
 * <p>数値（Short）を値として保持する Value Object の基底クラスです。</p>
 * @param <T> Value Object 具象型
 */
public abstract class AbstractShortValueObject<T extends AbstractShortValueObject<T>>
        extends AbstractNumberValueObject<Short>{

    /**
     * <p>指定された値でこのクラスの新しいインスタンスを初期化します。</p>
     * @param value 値
     */
    protected AbstractShortValueObject(Short value){super(value);}
}
