package com.JunBook.service;

import com.JunBook.domain.Book;
import com.JunBook.exception.BookNotFound;
import com.JunBook.repository.BookRepository;
import com.JunBook.request.BookCreate;
import com.JunBook.request.BookEdit;
import com.JunBook.response.BookResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
                .orElseThrow( () -> new BookNotFound());
        return BookResponse.builder()
                .book_id(book.getId())
                .title(book.getTitle())
                .content(book.getContent())
                .build();
    }
    /*
    * raw한 데이터 모두 BookResponse 타입 변경
    * */
    public List<BookResponse> getList(Pageable pageable) {
        return bookRepository.findAll(pageable).stream()
                .map(BookResponse::new)
                .collect(Collectors.toList());
    }
    @Transactional
    public void edit (Long book_id, BookEdit bookEdit) {
        Book book = bookRepository.findById(book_id).orElseThrow(
                () -> new BookNotFound());
        book.setTitle(bookEdit.getTitle());
        book.setContent(bookEdit.getContent());
    }

    public void delete (Long book_id) {
        Book book = bookRepository.findById(book_id).orElseThrow(
                () -> new BookNotFound());
        bookRepository.delete(book);
    }
}
