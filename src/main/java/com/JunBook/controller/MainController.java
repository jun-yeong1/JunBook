package com.JunBook.controller;

import com.JunBook.request.BookCreate;
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
    public String book(@RequestBody @Valid BookCreate params){
        return "d";
    }
    @GetMapping("/books/{bookId")
    public void get(@PathVariable Long bookId) {
    }

}
