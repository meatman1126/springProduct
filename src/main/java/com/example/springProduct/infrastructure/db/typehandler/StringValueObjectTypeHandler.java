package com.example.springProduct.infrastructure.db.typehandler;


import com.example.springProduct.domain.model.value.AbstractValueObject;
import com.example.springProduct.domain.model.value.object.*;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.StringTypeHandler;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <P>Stringを内部値として持つValueObjectのタイプハンドラクラスです。</P>
 */
@MappedTypes({
        Address.class,
        LoginId.class,
        Mail.class,
        OrganizationName.class,
        PhoneNumber.class,
        UserName.class,
})
@Slf4j
public class StringValueObjectTypeHandler<T extends AbstractValueObject<String>> extends BaseTypeHandler<T> {

    /**
     * String値を処理するデフォルトのタイプハンドラ
     */
    private final StringTypeHandler defaultTypeHandler = new StringTypeHandler();

    /**
     * ValueObject
     */
    private final Class<T> valueType;

    /**
     * ValueObject Constructor
     */
    private final Constructor<T> constructor;

    public StringValueObjectTypeHandler(Class<T> valueType) throws NoSuchMethodException{
        log.trace(getClass() + ": StringValueObjectTypeHandler(Class<T> valueType)");
        log.trace(valueType.getCanonicalName());
        this.valueType = valueType;
        this.constructor = valueType.getConstructor(String.class);
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType)throws SQLException{
        log.trace(getClass() + ": setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType)");

        String value = parameter.getValue();
        if (value == null){
            ps.setNull(i, jdbcType.TYPE_CODE);
        }else {
            defaultTypeHandler.setNonNullParameter(ps, i, value, jdbcType);
        }
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName)throws SQLException{
        log.trace(getClass() + ": ResultSet rs, String columnName");
        return getValueObject(defaultTypeHandler.getNullableResult(rs, columnName));
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex)throws SQLException{
        log.trace(getClass() + ": ResultSet rs, String columnIndex");
        return getValueObject(defaultTypeHandler.getNullableResult(rs, columnIndex));
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex)throws SQLException{
        log.trace(getClass() + ": CallableStatement cs, String columnIndex");
        return getValueObject(defaultTypeHandler.getNullableResult(cs, columnIndex));
    }


    /**
     * <p>指定されたString値を持つValueObjectを作成して返します。<br>
     *  値がnullの場合はnullを返します。</p>
     */
    private T getValueObject(String value) throws SQLException{
        log.trace(getClass() + ": getValueObject(String value)");
        try{
            return value == null ? null : constructor.newInstance(value);
        }catch(InstantiationException | IllegalAccessException | InvocationTargetException e){
            throw new SQLException(
                    "Failed to instantiate value object."
                    + "Class: " + valueType.getCanonicalName() + ", Param: " + value, e);
        }
    }

}
