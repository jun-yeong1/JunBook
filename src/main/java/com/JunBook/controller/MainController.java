package com.JunBook.controller;

import com.JunBook.domain.Book;
import com.JunBook.request.BookCreate;
import com.JunBook.response.BookResponse;
import com.JunBook.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {
    private final BookService bookService;
    @PostMapping("/books")
    public Long post(@RequestBody @Valid BookCreate request){
        Long bookId = bookService.register(request);
        return bookId;
    }
    @GetMapping("/books/{bookId}")
    public BookResponse get(@PathVariable Long bookId) {
        return bookService.get(bookId);
    }

}
