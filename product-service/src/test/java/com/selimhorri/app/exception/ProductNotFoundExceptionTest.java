package com.selimhorri.app.exception;

import org.junit.jupiter.api.Test;

import com.selimhorri.app.exception.wrapper.ProductNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductNotFoundExceptionTest {

    @Test
    void testMessage() {
        ProductNotFoundException exception = new ProductNotFoundException("Not found");
        assertEquals("Not found", exception.getMessage());
    }
}
