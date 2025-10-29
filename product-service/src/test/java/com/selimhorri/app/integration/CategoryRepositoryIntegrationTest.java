package com.selimhorri.app.integration;

import com.selimhorri.app.domain.Category;
import com.selimhorri.app.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CategoryRepositoryIntegrationTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void testCreateAndFind() {
        Category saved = categoryRepository.save(Category.builder().categoryTitle("Gaming").build());
        Category found = categoryRepository.findById(saved.getCategoryId()).orElse(null);
        assertThat(found).isNotNull();
        assertThat(found.getCategoryTitle()).isEqualTo("Gaming");
    }
}
