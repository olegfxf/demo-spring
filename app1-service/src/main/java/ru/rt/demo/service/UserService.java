package ru.rt.demo.service;

import ru.rt.demo.dto.user.NewUserRequest;
import ru.rt.demo.dto.user.UserDto;
import ru.rt.demo.dto.user.UserUpdatetDto;
import ru.rt.demo.model.User;

import java.util.List;

public interface UserService {
    /**
     * Добавление нового пользователя
     * @param body Данные добавляемого пользователя
     * @return
     */
    UserDto registerUser(NewUserRequest body);

    /**
     * Возвращает информацию обо всех пользователях
     * (учитываются параметры ограничения выборки),
     * либо о конкретных (учитываются указанные идентификаторы)
     * <p>
     * В случае, если по заданным фильтрам не найдено ни одного пользователя, возвращает пустой список
     * @param ids id пользователей
     * @param from количество элементов, которые нужно пропустить для формирования
     * текущего набора default: 0
     * @param size количество элементов в наборе default: 10
     * @return
     */
    List<UserDto> getUsers(List<Long> ids, Integer from, Integer size);

    /**
     * Обновляет информацию о пользователе по полям, которые присутствовали в
     * request-запросе.
     * @param userId идентификатор обновляемого пользователя
     * @param userUpdatetDto объект с полями пользователя, которые обновляются
     * @return
     */
    User updateUser(Long userId, UserUpdatetDto userUpdatetDto);

    /**
     * Удаление пользователя
     * @param userId
     */
    void deleteUser(long userId);


}
