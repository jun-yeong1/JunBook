package com.JunBook.domain;

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
    private Long book_id; // 책 id

    @Column(length = 200)
    private String title; // 책 제목
    
    @Lob
    @Column(columnDefinition = "TEXT")
    private String content; // 책 설명
    public Long getId() {
        return book_id;
    }
    public void setId(Long book_id) {
        this.book_id = book_id;
    }
    @Builder
    public Book(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
