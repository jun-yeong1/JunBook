package com.JunBook.controller;

import com.JunBook.domain.Book;
import com.JunBook.request.BookCreate;
import com.JunBook.request.BookEdit;
import com.JunBook.response.BookResponse;
import com.JunBook.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping("/books")
    public Long post(@RequestBody @Valid BookCreate request){
        Long book_id = bookService.register(request);
        return book_id;
    }
    @GetMapping("/books/{book_id}")
    public BookResponse get(@PathVariable Long book_id) {
        return bookService.get(book_id);
    }
    /*
    * 책 정보 전체 조회하기
    * @PageableDefault 페이징 처리 사이즈 5
    * */
    @GetMapping("/books")
    public List<BookResponse> getList(@PageableDefault(size = 5) Pageable pageable) {
        List<BookResponse> list = bookService.getList(pageable);
        return list;
    }
    /*
     * 책 정보 수정 기능
     * @RequestBody, @Valid 요청 데이터 DTO 대입
     * */
    @PatchMapping("/books/{book_id}")
    public void edit(@PathVariable Long book_id, @RequestBody @Valid BookEdit request) {
        bookService.edit(book_id, request);
    }
    /*
     * 책 정보 삭체 기능
     *
     * */
    @DeleteMapping("/books/{book_id}")
    public void delete(@PathVariable Long book_id) {
        bookService.delete(book_id);
    }

}
