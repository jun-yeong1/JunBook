package com.JunBook.controller;

import com.JunBook.domain.UserCreateForm;
import com.JunBook.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm) {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }
        /*
         * bindingResult.rejectValue(필드명, 오류 코드, 오류 메시지)
         */
        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }
        userService.create(userCreateForm.getUsername(),
                userCreateForm.getEmail(), userCreateForm.getPassword1());
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login_form";
    }
}
