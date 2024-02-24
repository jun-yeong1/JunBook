package com.JunBook.response;

import com.JunBook.domain.Book;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BookResponse {
    private final Long bookid;
    private final String title;
    private final String content;

    public BookResponse(Book book) {
        this.bookid = book.getId();
        this.title = book.getTitle();
        this.content = book.getContent();
    }

    @Builder
    public BookResponse(Long bookid, String title, String content) {
        this.bookid = bookid;
        this.title = title.substring(0, Math.min(title.length(), 10));
        this.content = content;
    }
}
