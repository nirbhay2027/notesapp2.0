package com.nirbhay.notesapp;

import com.nirbhay.notesapp.model.User;
import com.nirbhay.notesapp.repository.UserRepository;
import com.nirbhay.notesapp.service.CustomUserDetailsService;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CustomUserDetailsServiceTest {

    @Test
    void shouldLoadUserSuccessfully() {

        UserRepository mockRepo = Mockito.mock(UserRepository.class);

        User user = new User();
        user.setUsername("nirbhay");
        user.setPassword("123");

        Mockito.when(mockRepo.findByUsername("nirbhay"))
                .thenReturn(Optional.of(user));

        CustomUserDetailsService service = new CustomUserDetailsService(mockRepo);

        var userDetails = service.loadUserByUsername("nirbhay");

        assertEquals("nirbhay", userDetails.getUsername());
        assertEquals("123", userDetails.getPassword());
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {

        UserRepository mockRepo = Mockito.mock(UserRepository.class);

        Mockito.when(mockRepo.findByUsername("unknown"))
                .thenReturn(Optional.empty());

        CustomUserDetailsService service = new CustomUserDetailsService(mockRepo);

        assertThrows(Exception.class, () -> {
            service.loadUserByUsername("unknown");
        });
    }
}