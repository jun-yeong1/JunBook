package com.JunBook.exception;

public class BookNotFound extends RuntimeException {
    /*
    * 조회한 책이 없는 경우 (id가 없는 경우)
    * BookNotFound 객체 호출하면서 생성자를 통해
    * 메세지 출력
    * */
    private static final String MESSAGE = "존재하지 않는 책입니다.";

    public BookNotFound() { super(MESSAGE); };
}
