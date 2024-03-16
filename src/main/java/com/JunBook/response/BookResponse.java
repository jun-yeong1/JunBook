package com.JunBook.response;

import com.JunBook.domain.Book;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BookResponse {
    private final Long book_id;
    private final String title;
    private final String content;

    public BookResponse(Book book) {
        this.book_id = book.getId();
        this.title = book.getTitle();
        this.content = book.getContent();
    }

    @Builder
    public BookResponse(Long book_id, String title, String content) {
        this.book_id = book_id;
        this.title = title.substring(0, Math.min(title.length(), 10));
        this.content = content;
    }
}
