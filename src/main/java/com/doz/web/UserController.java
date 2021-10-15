package com.doz.web;

import com.doz.model.User;
import com.doz.model.dto.UserDto;
import com.doz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserDto getUserDto(@PathVariable long id) {
        return this.userService.getUserDto(id);
    }

    @PostMapping
    public UserDto save(@RequestBody User user) {
        return this.userService.save(user);
    }
}
