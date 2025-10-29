package com.selimhorri.app.e2e;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.selimhorri.app.dto.CategoryDto;
import com.selimhorri.app.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductE2ETest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateProductSuccessfully() throws Exception {
        ProductDto product = ProductDto.builder()
                .productTitle("Test Product")
                .imageUrl("http://image.test/product.jpg")
                .sku("TEST-SKU-001")
                .priceUnit(99.99)
                .quantity(20)
                .categoryDto(CategoryDto.builder().categoryId(1).build())
                .build();

        String jsonBody = objectMapper.writeValueAsString(product);

        mockMvc.perform(post("/product-service/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.productId").exists())
                .andExpect(jsonPath("$.productTitle").value("Test Product"))
                .andExpect(jsonPath("$.categoryDto.categoryId").value(1));
    }
}
