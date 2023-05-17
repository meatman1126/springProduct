package com.example.springProduct.domain.model.value;

import java.time.LocalDateTime;

/**
 * <p>日時を値として保持する Value Object の基底クラスです。</p>
 * @param <T> Value Object 具象型
 */
public abstract class AbstractDateTimeValueObject<T extends AbstractDateTimeValueObject<T>>
        extends AbstractValueObject<LocalDateTime>{

    /**
     * <p>指定された値でこのクラスの新しいインスタンスを初期化します。</p>
     * @param value 値
     */
    protected AbstractDateTimeValueObject(LocalDateTime value){super(value);}
}
