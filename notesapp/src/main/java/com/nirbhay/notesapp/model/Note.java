package com.nirbhay.notesapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "notes")
@Data
public class Note {

    @Id
    private String id;

    private String title;
    private String content;

    private LocalDateTime createdAt;
}
