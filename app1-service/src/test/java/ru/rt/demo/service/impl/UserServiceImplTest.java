package ru.rt.demo.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import ru.rt.demo.dto.UserMapper;
import ru.rt.demo.dto.user.NewUserRequest;
import ru.rt.demo.dto.user.UserDto;
import ru.rt.demo.dto.user.UserUpdatetDto;
import ru.rt.demo.model.User;
import ru.rt.demo.repository.UserRepository;
import ru.rt.demo.utils.TestInitDataUtil;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository repository;
    @InjectMocks
    private UserServiceImpl service;
    private List<User> userList;
    private List<Long> ids;
    private List<UserDto> userDtoList;

    private User userOpt;
    private final int from = 0;
    private final int size = 10;

    @BeforeEach
    void setUp() {
        userOpt = User.builder().id(1L).name("test").email("test@mail.ru").build();
        userList = TestInitDataUtil.getUserList();
        userDtoList = userList.stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
        ids = userList.stream()
                .map(User::getId)
                .collect(Collectors.toList());

    }

    @Test
    void registerUser() {
        final NewUserRequest body = NewUserRequest.builder().name("test").email("test@mail.com").build();
        final UserDto dto = UserDto.builder().id(1L).name("test").email("test@mail.com").build();
        final User user = TestInitDataUtil.makeUser(1L, "test", "test@mail.com");
        when(repository.save(any())).thenReturn(user);

        final UserDto actualNewUser = service.registerUser(body);
        assertEquals(dto.toString(), actualNewUser.toString());
    }


    @Test
    void getUsers() {
        when(repository.findAllByIdIn(any(), any())).thenReturn(new PageImpl<User>(userList));

        final List<UserDto> actualUserDtoList = service.getUsers(ids, from, size);
        assertEquals(actualUserDtoList.toString(), userDtoList.toString());
    }

    @Test
    void updateUser() {
        UserUpdatetDto userUpdatetDto = UserUpdatetDto.builder().name("newTest").build();
        when(repository.findById(any()))
                .thenReturn(Optional.ofNullable(userOpt));
        when(repository.save(any())).thenReturn(userOpt);

        User actualUser = service.updateUser(1L, userUpdatetDto);
        assertEquals(actualUser.getName(), "newTest");
    }

    @Test
    void deleteUser() {
        final long userId = 1L;
        Optional<User> user = Optional.of(TestInitDataUtil.makeUser(userId, "test", "test@mail.ru"));
        when(repository.findById(anyLong())).thenReturn(user);
        doNothing().when(repository).deleteById(anyLong());

        service.deleteUser(userId);

        verify(repository, times(1)).deleteById(userId);
    }
}