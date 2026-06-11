package io.eddie.productsservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record ProductRequest(

        @NotBlank                       // Validation
        @Length(min = 10, max= 50)      // Validation
        @Schema(
            description = "상품 이름"  // 해당 필드에 대한 설명
            , example = "상품 1"      // 해당 필드 예제값
            , requiredMode = Schema.RequiredMode.REQUIRED  // 필드 필수 포함 여부
            , minLength = 10        // 최소 길이
            , maxLength = 50        // 최대 길이
        )
        String name,

        @NotBlank
        @Schema(description = "상품 설명", example = "상품 1에 대한 설명입니다.")
        String description,


        @NotNull
        @Min(value = 1000L)
        @Schema(
            description = "상품 가격"
            , example = "판매하고자 하는 상품의 가격을 입력합니다."
            , requiredMode = Schema.RequiredMode.REQUIRED
            , minimum = "1000" // 최소값
        )
        Long price

) {
}
