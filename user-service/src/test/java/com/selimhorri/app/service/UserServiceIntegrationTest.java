package com.selimhorri.app.service;

import com.selimhorri.app.dto.CredentialDto;
import com.selimhorri.app.dto.UserDto;
import com.selimhorri.app.domain.User;
import com.selimhorri.app.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveAndFindUserByUsername() {
        UserDto userDto = UserDto.builder()
                .firstName("Jane")
                .lastName("Smith")
                .email("jane.smith@email.com")
                .phone("987654321")
                .imageUrl("img2.jpg")
                .credentialDto(
                        CredentialDto.builder()
                                .username("janesmith")
                                .password("securepass123")
                                .isEnabled(true)
                                .build()
                )
                .build();

        userService.save(userDto);

        Optional<User> fetched = userRepository.findByCredentialUsername("janesmith");

        assertThat(fetched).isPresent();
        assertThat(fetched.get().getFirstName()).isEqualTo("Jane");
        assertThat(fetched.get().getCredential().getUsername()).isEqualTo("janesmith");
    }
}
