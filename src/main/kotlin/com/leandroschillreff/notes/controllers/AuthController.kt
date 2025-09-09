package com.leandroschillreff.notes.controllers

import com.leandroschillreff.notes.security.AuthService
import jakarta.validation.Valid
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService
) {
    data class AuthRequest(
        @field:Email(message = "Invalid email format.")
        val email: String,
        @field:NotBlank(message = "Password must not be blank.")
        val password: String
    )

    data class RefreshRequest(
        val refreshToken: String
    )

    @PostMapping("/register")
    fun register(@Valid @RequestBody body: AuthRequest) {
        authService.register(body.email, body.password)
    }

    @PostMapping("/login")
    fun login(@Valid @RequestBody body: AuthRequest): AuthService.TokenPair {
        return authService.login(body.email, body.password)
    }

    @PostMapping("/refresh")
    fun refresh(@RequestBody body: RefreshRequest): AuthService.TokenPair {
        return authService.refresh(body.refreshToken)
    }

}