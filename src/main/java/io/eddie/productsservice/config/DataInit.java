package io.eddie.productsservice.config;

import io.eddie.productsservice.dto.ProductRequest;
import io.eddie.productsservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInit implements ApplicationRunner {

    private final ProductService service;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        IntStream.rangeClosed(1, 20)
                .forEach( i -> {

                    ProductRequest request = new ProductRequest(
                            "상품명_%d".formatted(i),
                            "상품_설명_%d".formatted(i),
                            i * 10000L
                    );

                    service.save(request);

                });
    }

}
