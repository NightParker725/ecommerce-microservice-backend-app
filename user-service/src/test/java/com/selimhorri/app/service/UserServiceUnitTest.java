package com.selimhorri.app.service;

import com.selimhorri.app.domain.User;
import com.selimhorri.app.dto.UserDto;
import com.selimhorri.app.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class UserServiceUnitTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        user = User.builder()
                .userId(1)
                .firstName("John")
                .lastName("Doe")
                .email("johndoe@email.com")
                .phone("123456789")
                .imageUrl("algunaimg.jpg")
                .build();
    }

    @Test
    public void testFindAllUsers() {
        when(userRepository.findAll()).thenReturn(List.of(user));
        List<UserDto> result = userService.findAll();
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getEmail()).isEqualTo("johndoe@email.com");
        verify(userRepository).findAll();
    }
}
