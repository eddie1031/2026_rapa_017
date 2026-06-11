package io.eddie.productsservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record ProductRequest(

        @NotBlank
        @Length(min = 10, max= 50)
        @Schema
        String name,

        @NotBlank
        @Schema
        String description,


        @NotNull
        @Min(value = 1000L)
        @Schema
        Long price

) {
}
