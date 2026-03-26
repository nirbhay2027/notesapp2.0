package com.nirbhay.notesapp.controller;

import com.nirbhay.notesapp.model.Note;
import com.nirbhay.notesapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService service;

    @PostMapping
    public Note create(@RequestBody Note note){
        return service.create(note);
    }

    @GetMapping
    public List<Note> getAll(){
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Note update(@PathVariable String id, @RequestBody Note note){
        return service.update(id, note);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
