package ru.rt.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.rt.demo.dto.user.NewUserRequest;
import ru.rt.demo.dto.user.UserDto;
import ru.rt.demo.dto.user.UserUpdatetDto;
import ru.rt.demo.messages.LogMessages;
import ru.rt.demo.model.User;
import ru.rt.demo.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto registerUser(@Valid @RequestBody NewUserRequest newUserRequest) {
        log.debug(String.valueOf(LogMessages.TRY_ADD), "ПОЛЬЗОВАТЕЛЯ");
        return userService.registerUser(newUserRequest);
    }


    @GetMapping
    public List<UserDto> getUsers(@RequestParam(required = false) List<Long> ids,
                                  @RequestParam(defaultValue = "0") int from,
                                  @RequestParam(defaultValue = "10") int size) {
        log.debug(String.valueOf(LogMessages.GET_ALL), "ПОЛЬЗОВАТЕЛЕЙ");
        return userService.getUsers(ids, from, size);
    }


    @PatchMapping("/{userId}")
    public User updateUser(@PathVariable Long userId,
                           @Valid @RequestBody UserUpdatetDto userUpdatetDto) {
        log.debug(String.valueOf(LogMessages.TRY_UPDATE), "ПОЛЬЗОВАТЕЛЯ");
        return userService.updateUser(userId, userUpdatetDto);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "userId") long userId) {
        log.debug(String.valueOf(LogMessages.TRY_REMOVE_OBJECT), "ПОЛЬЗОВАТЕЛЬ");
        userService.deleteUser(userId);
    }
}
