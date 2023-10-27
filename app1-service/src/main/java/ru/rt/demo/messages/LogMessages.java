package ru.rt.demo.messages;

public enum LogMessages {
    TRY_ADD("Поступил запрос на добавление: {}"),
    ADD("Успешно добавлен объект: {}"),
    TRY_PATCH("Поступил запрос на частичное обновление: {}"),
    PATCH("Объект успешно частично обновлен: {}"),
    TRY_UPDATE("Поступил запрос на обновление: {}"),
    UPDATE("Успешно обновлен объект : {}"),
    TRY_GET_OBJECT("Поступил запрос на получение объекта по id: {}"),
    GET("Предоставлен объект: {}"),
    TRY_REMOVE_OBJECT("Поступил запрос на удаление объекта: {}"),
    REMOVE("Объект удален по id: {}"),
    TRY_GET_ALL("Поступил запрос на предоставление списка: {}"),
    GET_ALL("Предоставлен список: {}"),
    TRY_GET_SEARCH("Попытка поиска items by = {}");

    private final String textLog;

    LogMessages(String textLog) {
        this.textLog = textLog;
    }

    @Override
    public String toString() {
        return textLog;
    }
}
