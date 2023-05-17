package com.example.springProduct.domain.model.value;

/**
 * <p>数値（Long）を値として保持する Value Object の基底クラスです。</p>
 * @param <T> Value Object 具象型
 */
public abstract class AbstractLongValueObject<T extends AbstractLongValueObject<T>>
        extends AbstractNumberValueObject<Long>{

    /**
     * <p>指定された値でこのクラスの新しいインスタンスを初期化します。</p>
     * @param value 値
     */
    protected AbstractLongValueObject(Long value){super(value);}
}
