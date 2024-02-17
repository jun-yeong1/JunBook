package com.JunBook.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.StringReader;

@Setter
@Getter
@ToString
public class BookCreate {
    @NotBlank(message = "책 제목을 입력하세요.")
    private String title;

    @NotBlank(message = "책의 내용을 입력해주세요.")
    private String content;

    @Builder
    public BookCreate(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
