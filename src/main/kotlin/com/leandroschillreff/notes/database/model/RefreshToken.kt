package com.leandroschillreff.notes.database.model

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document

@Document("refresh_token")
data class RefreshToken(
    val userId: ObjectId,
)
