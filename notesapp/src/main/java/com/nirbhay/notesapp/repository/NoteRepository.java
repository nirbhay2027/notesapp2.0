package com.nirbhay.notesapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.nirbhay.notesapp.model.Note;

public interface NoteRepository extends MongoRepository<Note, String> {
}

