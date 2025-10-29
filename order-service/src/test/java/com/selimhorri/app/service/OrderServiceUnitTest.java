package com.selimhorri.app.service;

import com.selimhorri.app.domain.Order;
import com.selimhorri.app.dto.OrderDto;
import com.selimhorri.app.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceUnitTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    private OrderDto mockOrder;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockOrder = OrderDto.builder()
                .orderId(1)
                .orderDate(LocalDateTime.now())
                .orderDesc("Electronics arts order")
                .orderFee(99.99)
                .build();
    }

    @Test
    public void testFindById() {
        when(orderRepository.findById(1)).thenReturn(Optional.of(
                Order.builder()
                        .orderId(1)
                        .orderDate(LocalDateTime.now())
                        .orderDesc("Electronics arts order")
                        .orderFee(99.99)
                        .build()
        ));
        OrderDto found = orderService.findById(1);
        assertNotNull(found);
        assertEquals("Electronics arts order", found.getOrderDesc());
    }

    @Test
    public void testSaveOrder() {
        when(orderRepository.save(any(Order.class))).thenReturn(
                Order.builder()
                        .orderId(1)
                        .orderDate(LocalDateTime.now())
                        .orderDesc("Electronics arts order")
                        .orderFee(99.99)
                        .build()
        );
        OrderDto saved = orderService.save(mockOrder);
        assertNotNull(saved);
        assertEquals(99.99, saved.getOrderFee());
    }
}
