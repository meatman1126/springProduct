package com.example.springProduct.domain.model.value.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;

@Getter
@AllArgsConstructor
public enum GenderEnum {

    GENDER_MALE("1", "男性"),
    GENDER_FEMAL("2", "女性"),
    GENDER_OTHER("3", "その他");

    private final String code;
    private final String displayName;


    /**
     * <p>Enumの逆引きを行います</p>
     */
    public static GenderEnum codeOf(@NonNull final String code) {
        return Arrays.stream(GenderEnum.values())
                .filter(genderEnum -> Objects.equals(genderEnum.getCode(), code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }


}
