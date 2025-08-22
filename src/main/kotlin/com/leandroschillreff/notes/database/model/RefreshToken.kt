package com.leandroschillreff.notes.database.model

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document("refresh_tokens")
data class RefreshToken(
    val userId: ObjectId,
    val expiresAt: Instant,
    val token: String,
    val createAt: Instant = Instant.now(),
)
