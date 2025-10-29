package com.selimhorri.app.service;

import com.selimhorri.app.domain.Product;
import com.selimhorri.app.dto.ProductDto;
import com.selimhorri.app.repository.ProductRepository;
import com.selimhorri.app.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    private final ProductRepository repository = mock(ProductRepository.class);
    private final ProductServiceImpl service = new ProductServiceImpl(repository);

    @Test
    void testFindById() {
        Product product = Product.builder().productId(1).productTitle("Phone").build();
        when(repository.findById(1)).thenReturn(Optional.of(product));
        ProductDto result = service.findById(1);
        assertEquals("Phone", result.getProductTitle());
    }

    @Test
    void testSave() {
        Product product = Product.builder().productTitle("Laptop").build();
        when(repository.save(any())).thenReturn(product);
        ProductDto saved = service.save(ProductDto.builder().productTitle("Laptop").build());
        assertEquals("Laptop", saved.getProductTitle());
    }
}
