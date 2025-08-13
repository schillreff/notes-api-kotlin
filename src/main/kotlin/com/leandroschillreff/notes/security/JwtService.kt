package com.leandroschillreff.notes.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*

@Service
class JwtService(@Value("\${jwt.secret}") private val jwtSecret: String) {

    private val secretKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(jwtSecret))
    private val accessTokenValidityMs = 15L * 60L * 1000L
    val refreshTokenValidityMs = 24L * 60L * 60L * 1000L

    private fun generateToken(
        userId: String, type: String, expiry: Long
    ): String {
        val now = Date()
        val expiryDate = Date(now.time + expiry)
        return Jwts.builder().subject(userId).claim("type", type).issuedAt(now).expiration(expiryDate)
            .signWith(secretKey, Jwts.SIG.HS256).compact()
    }

    fun generateAccessToken(userId: String): String {
        return generateToken(userId, type = "access", accessTokenValidityMs)
    }

    fun generateRefreshToken(userId: String): String {
        return generateToken(userId, type = "refresh", refreshTokenValidityMs)
    }

    
}