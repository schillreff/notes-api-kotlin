package com.leandroschillreff.notes.database.repository

import com.leandroschillreff.notes.database.model.Note
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface NoteRepository: MongoRepository<Note, ObjectId> {

}