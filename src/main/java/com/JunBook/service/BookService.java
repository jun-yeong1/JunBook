package com.JunBook.service;

import com.JunBook.domain.Book;
import com.JunBook.repository.BookRepository;
import com.JunBook.request.BookCreate;
import com.JunBook.response.BookResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
    /*
    * bookRepository 불러오기
    * */
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Long register(@Valid BookCreate bookCreate) {
        Book book = Book.builder()
                .title(bookCreate.getTitle())
                .content(bookCreate.getContent())
                .build();
        bookRepository.save(book);
        return book.getId();
    }
    public BookResponse get(Long book_id) {
        Book book = bookRepository.findById(book_id)
                .orElseThrow( () -> new IllegalArgumentException("존재하지 않는 상품입니다."));
        return BookResponse.builder()
                .book_id(book.getId())
                .title(book.getTitle())
                .content(book.getContent())
                .build();
    }
}
