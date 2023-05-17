package com.example.springProduct.domain.model.value;

import java.math.BigDecimal;

/**
 * <p>数値（Decimal）を値として保持する Value Object の基底クラスです。</p>
 * @param <T> Value Object 具象型
 */
public abstract class AbstractDecimalValueObject<T extends AbstractDecimalValueObject<T>>
        extends AbstractNumberValueObject<BigDecimal>{

    /**
     * <p>指定された値でこのクラスの新しいインスタンスを初期化します。</p>
     * @param value 値
     */
    protected AbstractDecimalValueObject(BigDecimal value){super(value);}
}
