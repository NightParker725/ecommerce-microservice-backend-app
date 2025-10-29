package com.selimhorri.app.helper;

import com.selimhorri.app.domain.Product;
import com.selimhorri.app.dto.ProductDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductMappingHelperTest {

    @Test
    void testMapToDto() {
        Product product = Product.builder().productId(1).productTitle("Test").build();
        ProductDto dto = ProductMappingHelper.map(product);
        assertEquals(product.getProductId(), dto.getProductId());
        assertEquals(product.getProductTitle(), dto.getProductTitle());
    }

    @Test
    void testMapToEntity() {
        ProductDto dto = ProductDto.builder().productId(2).productTitle("Sample").build();
        Product product = ProductMappingHelper.map(dto);
        assertEquals(dto.getProductId(), product.getProductId());
        assertEquals(dto.getProductTitle(), product.getProductTitle());
    }
}
