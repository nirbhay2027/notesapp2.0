package com.nirbhay.notesapp;

import com.nirbhay.notesapp.security.JwtUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JwtUtilTest {

    private final JwtUtil jwtUtil = new JwtUtil();

    @Test
    void testGenerateToken() {
        String token = jwtUtil.generateToken("nirbhay");
        assertNotNull(token);
    }

    @Test
    void testExtractUsername() {
        String token = jwtUtil.generateToken("nirbhay");
        String username = jwtUtil.extractUsername(token);
        assertEquals("nirbhay", username);
    }

    @Test
    void testValidateToken() {
        String token = jwtUtil.generateToken("nirbhay");
        assertTrue(jwtUtil.validateToken(token, "nirbhay"));
    }
}
