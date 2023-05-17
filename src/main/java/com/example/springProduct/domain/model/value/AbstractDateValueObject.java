package com.example.springProduct.domain.model.value;

import java.time.LocalDate;

/**
 * <p>日付を値として保持する Value Object の基底クラスです。</p>
 * @param <T> Value Object 具象型
 */
public abstract class AbstractDateValueObject<T extends AbstractDateValueObject<T>>
        extends AbstractValueObject<LocalDate>{

    /**
     * <p>指定された値でこのクラスの新しいインスタンスを初期化します。</p>
     * @param value 値
     */
    protected AbstractDateValueObject(LocalDate value){super(value);}
}
