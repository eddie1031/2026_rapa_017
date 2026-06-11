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
            summary = "상품 추가 API",                      // API 요약
            description = "상품을 추가하기 위한 API입니다."     // API 설명
    )  // API 엔드포인트의 제목 및 설명 정의
    @ApiResponse(
            responseCode = "201",                       // 응답 코드
            description = "저장된 상품에 대한 내용입니다.",    // 응답 설명
            content = {                                 // 응답 상세정보
                    @Content(
                            mediaType = "application/json",          // 응답 컨텐츠 타입
                            schema = @Schema(                        // 응답 본문 정보
                                    implementation = Products.class  // 응답 본문 타입 참조
                            )
                    )
            }
    )  // API 응답에 대한 내용을 작성
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Products> save(ProductRequest request) {
        return ResponseEntity.ok(service.save(request));
    }

    @Operation(
            summary = "특정 상품 조회 API",
            description = "상품 번호로 상품을 조회합니다."
    )
    @GetMapping("/{id}")
    public ResponseEntity<Products> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(
            summary = "상품 목록 조회 API",
            description = "상품 목록을 조회합니다."
    )
    @GetMapping
    public ResponseEntity<List<Products>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(
            summary = "특정 상품 수정 API",
            description = "상품 번호로 특정 상품을 수정합니다."
    )
    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody ProductRequest request, @PathVariable Long id) {
        service.update(request, id);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "특정 상품 삭제 API",
            description = "상품 번호로 특정 상품을 삭제합니다."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
