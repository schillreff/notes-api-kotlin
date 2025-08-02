package com.leandroschillreff.notes.security

import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class JwtService(@Value("JWT_SECRET_BASE64") private val jwtSecret: String) {

    private val secretKey = Keys.hmacShaKeyFor()
}