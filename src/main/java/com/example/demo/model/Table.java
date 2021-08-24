package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor
@Setter
public class Table extends Timestamped {
    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long table_id;

    @Column(nullable = false)
    private String table_title;

    @Column(nullable = false)
    private String table_autor;

    @Column(nullable = false)
    private String table_text;

    public Table(String table_title, String table_autor, String table_text) { // << PersonRequestDto에서 가져옴
        this.table_title = table_title;
        this.table_autor = table_autor;
        this.table_text = table_text;
    }

}
