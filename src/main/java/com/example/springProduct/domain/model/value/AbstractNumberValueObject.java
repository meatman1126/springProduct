package com.example.springProduct.domain.model.value;

/**
 * <p>数値を値として保持する Value Object の基底クラスです。</p>
 * @param <T> Value Object 具象型
 */
public abstract class AbstractNumberValueObject<T extends Number>
        extends AbstractValueObject<T>{

    /**
     * <p>指定された値でこのクラスの新しいインスタンスを初期化します。</p>
     * @param value 値
     */
    protected AbstractNumberValueObject(T value){super(value);}
}
