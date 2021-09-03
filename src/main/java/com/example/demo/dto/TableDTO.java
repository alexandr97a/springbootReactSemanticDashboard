package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TableDTO {
    private String table_id;
    private String table_title;
    private String table_autor;
    private String table_text;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public TableDTO(String table_title, String table_autor, String table_text) { // << PersonRequestDto에서 가져옴
        this.table_title = table_title;
        this.table_autor = table_autor;
        this.table_text = table_text;
    }
}
