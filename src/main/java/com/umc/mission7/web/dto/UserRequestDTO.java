package com.umc.mission7.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.umc.mission7.domain.Gender;
import com.umc.mission7.validation.annotation.ExistCategories;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDateTime;
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

    @Getter
    public static class addMissionDTO {
        @NotNull
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        @Schema(example = "2024-01-01T09:00:00", description = "Start date in yyyy-MM-dd'T'HH:mm:ss format")
        LocalDateTime startDate;

        @NotNull
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
        @Schema(example = "2024-01-01T09:00:00", description = "duedate in yyyy-MM-dd'T'HH:mm:ss format")
        LocalDateTime dueDate;
    }
}
