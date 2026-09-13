package io.github.avocoders.userservicespring.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Ответ API с данными пользователя")
public record UserResponse(
        @Schema(description = "Идентификатор пользователя", example = "10")
        Long id,

        @Schema(description = "Имя пользователя", example = "Nika")
        String name,

        @Schema(description = "Почта пользователя", example = "nika@ya.ru")
        String email,

        @Schema(description = "Возраст пользователя", example = "20")
        Integer age,

        @Schema(
                description = "Дата и время создания пользователя",
                example = "2026-09-13T18:00:00"
        )
        LocalDateTime createdAt
) {
}
