package com.selimhorri.app.domain;

import com.selimhorri.app.dto.CategoryDto;
import com.selimhorri.app.helper.CategoryMappingHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMappingHelperTest {

    @Test
    void testMapToDto() {
        Category category = Category.builder().categoryId(1).categoryTitle("Electronics").build();
        CategoryDto dto = CategoryMappingHelper.map(category);
        assertEquals("Electronics", dto.getCategoryTitle());
    }

    @Test
    void testMapToEntity() {
        CategoryDto dto = CategoryDto.builder().categoryId(2).categoryTitle("Books").build();
        Category category = CategoryMappingHelper.map(dto);
        assertEquals(2, category.getCategoryId());
        assertEquals("Books", category.getCategoryTitle());
    }
}
