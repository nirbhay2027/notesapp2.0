package com.nirbhay.notesapp.service;

import com.nirbhay.notesapp.model.Note;
import com.nirbhay.notesapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository repo;

    public Note create(Note note){
        note.setCreatedAt(LocalDateTime.now());
        return repo.save(note);
    }

    public List<Note> getAll(){
        return repo.findAll();
    }

    public Note update(String id, Note note){
        Note existing = repo.findById(id).orElseThrow();

        existing.setTitle(note.getTitle());
        existing.setContent(note.getContent());

        return repo.save(existing);
    }

    public void delete(String id){
        repo.deleteById(id);
    }
}
