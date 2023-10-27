package ru.rt.demo.dto.user;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Size;


@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
public class UserUpdatetDto {
    @Size(min = 6)
    @Size(max = 254)
    String email;

    @Size(min = 6)
    @Size(max = 254)
    String name;
}
