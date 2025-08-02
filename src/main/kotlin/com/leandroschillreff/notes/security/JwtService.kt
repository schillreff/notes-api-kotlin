package com.leandroschillreff.notes.security

import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Service

@Service
class JwtService {

    private val secretKey = Keys.hmacShaKeyFor()
}