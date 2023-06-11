package com.example.springProduct.constant.code;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum RoleFlugEnum {

    NO("0", "権限なし"),
    YES("1", "権限あり");

    private final String code;
    private final String displayName;

    /**
     * 権限が有効か田舎を判定します。
     *
     * @return YES：有効 NO：無効
     */
    public Boolean isValid() {
        return this == YES;
    }

    /**
     * Enumの逆引きを行います。
     *
     * @param code 逆引きしたいコード値
     * @return コード値に一致するEnum
     */
    public static RoleFlugEnum codeOf(@NonNull final String code) {
        return Arrays.stream(RoleFlugEnum.values()).filter(v -> Objects.equals(v.getCode(), code))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    @Component
    public static class RoleFlagEnumConverter implements Converter<String, RoleFlugEnum> {

        @Override
        public RoleFlugEnum convert(String source){return RoleFlugEnum.codeOf(source);}
    }




}
