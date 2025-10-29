package com.selimhorri.app.integration;

import com.selimhorri.app.ProductServiceApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = ProductServiceApplication.class)
class FullAppContextTest {

    @Test
    void contextLoads() {
        assertNotNull(ProductServiceApplication.class);
    }
}
