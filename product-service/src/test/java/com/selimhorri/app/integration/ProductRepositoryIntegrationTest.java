package com.selimhorri.app.integration;

import com.selimhorri.app.domain.Product;
import com.selimhorri.app.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class ProductRepositoryIntegrationTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testSaveAndFindById() {
        Product saved = productRepository.save(Product.builder().productTitle("Keyboard").build());
        Product result = productRepository.findById(saved.getProductId()).orElse(null);
        assertThat(result).isNotNull();
        assertThat(result.getProductTitle()).isEqualTo("Keyboard");
    }
}
