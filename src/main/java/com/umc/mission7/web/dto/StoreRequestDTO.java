package com.umc.mission7.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalTime;

public class StoreRequestDTO {
    @Getter
    public static class ReviewDTO{
        @NotNull
        Integer rate;
        @NotBlank
        String review;
    }

    @Getter
    public static class CreateDTO {
        @NotNull String location;
        @NotNull String address;
        @NotNull String name;
        @NotNull String phoneNumber;

        @NotNull
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
        @Schema(example = "09:00:00", description = "Opening time in hh:mm:ss format")
        LocalTime openTime;

        @NotNull
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
        @Schema(example = "18:00:00", description = "Closing time in hh:mm:ss format")
        LocalTime closeTime;

        @NotNull Long point;
    }
}
