package com.selimhorri.app.service;

import com.selimhorri.app.domain.Category;
import com.selimhorri.app.dto.CategoryDto;
import com.selimhorri.app.repository.CategoryRepository;
import com.selimhorri.app.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceImplTest {

    private final CategoryRepository repository = mock(CategoryRepository.class);
    private final CategoryServiceImpl service = new CategoryServiceImpl(repository);

    @Test
    void testFindById() {
        Category category = Category.builder().categoryId(1).categoryTitle("Toys").build();
        when(repository.findById(1)).thenReturn(Optional.of(category));
        CategoryDto result = service.findById(1);
        assertEquals("Toys", result.getCategoryTitle());
    }
}
