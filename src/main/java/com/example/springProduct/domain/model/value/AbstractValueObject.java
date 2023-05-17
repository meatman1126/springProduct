package com.example.springProduct.domain.model.value;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p>value objectの基底クラスです。</p>
 * @param <T>値の型
 */
public abstract class AbstractValueObject<T> {

    /**
     * 値
     */
    private final T value;

    /**
     * <p>指定された値でこのクラスの新しいインスタンスを初期化します</p>。
     * @param value 値
     */
    protected AbstractValueObject(T value){
        if (value == null){
            throw new NullPointerException("null 不許可");
        }

        this.value = value;
    }

    /**
     * <p>値を取得します。</p>
     * @return 値
     */
    public T getValue(){return this.value; }

    /**
     * <p>論理名を取得します。</p>
     * @return 論理名
     */
    public abstract String getLogicalName();

    /**
     * <p>指定されたオブジェクトがこのインスタンスと等価であるか判定します。<p/>
     * @param object オブジェクト
     * @return 等価の場合 true
     */
    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if (null == object){
            return false;
        }
        if(!getClass().equals(object.getClass())){
            return false;
        }

        AbstractValueObject<?> other = (AbstractValueObject<?>) object;
        return this.value.equals(other.value);
    }

    /**
     * <p>このインスタンスのハッシュ値を取得します。</p>
     * @return このインスタンスのハッシュ値
     */
    @Override
    public int hashCode(){return this.value.hashCode();}

    /**
     * <p>このインスタンスの文字列表現を取得します。</p>
     * @return このインスタンスの文字列表現
     */
    @Override
    public String toString(){return this.value.toString();}

    /**
     * <p>このインスタンスのJson変換時の値を取得します。</p>
     * @return このインスタンスのJson変換時の値
     */
    @JsonValue
    protected Object toJsonValue(){return this.value;}
}
