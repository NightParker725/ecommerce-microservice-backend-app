package com.selimhorri.app.integration;

import com.selimhorri.app.dto.ProductDto;
import com.selimhorri.app.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceIntegrationTest {

    @Autowired
    private ProductService productService;

    @Test
    void testSaveAndFetch() {
        ProductDto dto = ProductDto.builder().productTitle("Monitor").build();
        ProductDto saved = productService.save(dto);
        ProductDto found = productService.findById(saved.getProductId());
        assertEquals("Monitor", found.getProductTitle());
    }
}
