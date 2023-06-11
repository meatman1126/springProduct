package com.example.springProduct.infrastructure.db.typehandler;


import com.example.springProduct.constant.code.RoleFlugEnum;
import com.example.springProduct.domain.model.value.AbstractValueObject;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.StringTypeHandler;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <P>Stringを内部値として持つValueObjectのタイプハンドラクラスです。</P>
 */
@MappedTypes({
        RoleFlugEnum.class,
})
@Slf4j
public class FlugEnumTypeHandler<T extends Enum<T>> extends BaseTypeHandler<Enum<T>> {

    /**
     * Boolean値を処理するデフォルトのタイプハンドラ
     */
    private final StringTypeHandler defaultTypeHandler = new StringTypeHandler();

    /**
     * Enum型
     */
    private final Class<T> enumType;

    /**
     * Enum コード値を取得するメソッド
     */
    private final Method getCode;

    /**
     * Enumの全エントリ
     */
    private final T[] enumEntires;


    /**
     * 指定されたEnum型の処理を行うこのクラスの新しいインスタンスを初期化します。
     * @param enumType 処理するEnum型 (MyBatisから渡される)
     * @throws NoSuchMethodException 対象のEnum型にgetCode() メソッドが見つからない場合
     */
    public FlugEnumTypeHandler(@NonNull Class<T> enumType) throws NoSuchMethodException{
        log.trace(enumType.getCanonicalName());
        this.enumType = enumType;
        this.getCode = enumType.getMethod("getCode");
        this.enumEntires = enumType.getEnumConstants();
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Enum<T> parameter, JdbcType jdbcType)throws SQLException{

        try {
            final String param = String.valueOf(getCode.invoke(parameter));
            defaultTypeHandler.setNonNullParameter(ps, i, param, jdbcType);
        }catch (IllegalAccessException | InvocationTargetException e){
            throw new SQLException("Failed To get enum code", e);
        }
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName)throws SQLException{
        return getEnum(rs.getString(columnName));
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex)throws SQLException{
        return getEnum(rs.getString(columnIndex));
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex)throws SQLException{
        return getEnum(cs.getString(columnIndex));
    }


    /**
     * <p>指定されたコード値に対応するEnumエントリを返します。<br>
     *  コード値がnullの場合はnullを返します。</p>
     */
    private T getEnum(String code) throws SQLException{
        if (code == null){return null;}
        try{
            for(T enumEntry : enumEntires){
                if (getCode.invoke(enumEntry).toString().equals(code)){
                    return enumEntry;
                }
            }
        }catch(IllegalAccessException | InvocationTargetException e){
            throw new SQLException(
                    "Failed to get enum code.", e);
        }
        throw new IllegalArgumentException("Enum: " + enumType.getCanonicalName() + ", Code" + code);
    }

}
