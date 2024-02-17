package com.JunBook.service;

import com.JunBook.entity.Book;
import com.JunBook.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public void register(BookCreate bookCreate) {
        Book book = Book.builder()
                .title(bookCreate.getTitle())
                .content(bookCreate.getContent())
                .build();
        bookRepository.save(book);
    }
}
