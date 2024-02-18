package com.JunBook.service;

import com.JunBook.entity.Book;
import com.JunBook.repository.BookRepository;
import com.JunBook.request.BookCreate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public void register(@Valid BookCreate bookCreate) {
        Book book = Book.builder()
                .title(bookCreate.getTitle())
                .content(bookCreate.getContent())
                .build();
        bookRepository.save(book);
    }
    public Book get(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow( () -> new IllegalArgumentException("존재하지 않는 상품입니다."));
        return book;
    }
}
