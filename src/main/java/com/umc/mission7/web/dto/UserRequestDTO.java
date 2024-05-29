package com.umc.mission7.web.dto;

import com.umc.mission7.domain.Gender;
import com.umc.mission7.validation.annotation.ExistCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank String name;
        @NotNull String email;
        @NotNull String nickName;
        @NotNull String birth;
        @NotNull @Size(min = 5, max = 12) String address;
        @NotNull Boolean isAgreeLocation;
        @NotNull Boolean isAgreeMarketing;
        Long point;
        Integer gender;
        @ExistCategories List<Long> userFoodCategory;
    }

}
