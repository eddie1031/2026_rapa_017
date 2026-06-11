package io.eddie.productsservice.controller;

import io.eddie.productsservice.dto.ProductRequest;
import io.eddie.productsservice.entity.Products;
import io.eddie.productsservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductApiController {

    private final ProductService service;

    @Operation(
        summary = "상품 추가 API",
        description = """
게임 전반적으로 사용되는 아이템에 대한 내역을 추가하는 API입니다."""
    )
    @ApiResponse(
            responseCode = "201",
            description = "저장된 상품에 대한 내역입니다.",
            content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = Products.class
                            )
                    )
            }
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Products> save(ProductRequest request) {
        return ResponseEntity.ok(service.save(request));
    }


    @Operation(
            summary = "특정 상품 조회 API",
            description = """
게임에서 사용되는 특정 아이템을 조회하기 위한 API입니다."""
    )
    @GetMapping("/{id}")
    public ResponseEntity<Products> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }


    @Operation(
            summary = "상품 목록 조회 API",
            description = """
게임에서 사용되는 전체 아이템을 조회하기 위한 API입니다."""
    )
    @GetMapping
    public ResponseEntity<List<Products>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(
            summary = "특정 상품 수정 API",
            description = """
게임에서 사용되는 특정 아이템의 내용을 수정하기 위한 API입니다."""
    )
    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody ProductRequest request, @PathVariable Long id) {
        service.update(request, id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "특정 상품 삭제 API",
            description = """
게임에서 사용되는 특정 아이템의 내용을 삭제하기 위한 API입니다."""
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
