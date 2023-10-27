package ru.rt.demo.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.rt.demo.model.User;

import javax.validation.constraints.NotNull;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestInitDataUtil {
    public static User makeUser(long id, String name, String email) {
        return User.builder()
                .id(id)
                .name(name)
                .email(email)
                .build();
    }

    @NotNull
    public static List<User> getUserList() {
        return List.of(
                makeUser(1L, "Jon", "jon@mail.ru"),
                makeUser(2L, "Jane", "jane@mail.ru"),
                makeUser(3L, "Mary", "mary@mail.ru")
        );
    }

}
