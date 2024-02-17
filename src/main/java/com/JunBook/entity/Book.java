package com.JunBook.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 책 id
    
    private String title; // 책 제목
    
    @Lob
    private String content; // 책 설명

    @Builder
    public Book(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
