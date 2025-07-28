package com.leandroschillreff.notes.security

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class HashEncoder {

    private val bcrypt = BCryptPasswordEncoder()

    fun encode(raw: String): String = bcrypt.encode(raw)

    fun matches(raw: String, hashed: String): Boolean = bcrypt.matches(raw, hashed)
}