package io.eddie.productsservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record ProductRequest(

        @NotBlank
        @Length(min = 10, max= 50)
        @Schema(
                description = "추가될 아이템의 이름",
                example = "백엔드 기술강사가 사용하는 무거운 롱소드",
                requiredMode = Schema.RequiredMode.REQUIRED,
                minLength = 10,
                maxLength = 50
        )
        String name,

        @NotBlank
        @Schema(
                description = "추가될 아이템의 내용",
                example = "크고 아름다운 검. 멋져",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        String description,


        @NotNull
        @Min(value = 1000L)
        @Schema(
                description = "아이템의 가격",
                example = "1000",
                requiredMode = Schema.RequiredMode.REQUIRED,
                minimum = "1000"
        )
        Long price

) {
}
