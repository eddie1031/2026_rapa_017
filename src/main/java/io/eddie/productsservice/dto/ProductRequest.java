package io.eddie.productsservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record ProductRequest(

        @NotBlank                       // Validation
        @Length(min = 10, max= 50)      // Validation
        String name,

        @NotBlank
        String description,


        @NotNull
        @Min(value = 1000L)
        Long price

) {
}
