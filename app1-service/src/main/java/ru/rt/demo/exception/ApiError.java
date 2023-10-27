package ru.rt.demo.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class ApiError {
    @JsonProperty("errors")
    List<String> errors; //Список стектрейсов или описания ошибок

    @JsonProperty("message")
    String message; //Сообщение об ошибке

    @JsonProperty("reason")
    String reason; //Общее описание причины ошибки

    @JsonProperty("status")
    HttpStatus status; //Код статуса HTTP-ответа

    @JsonProperty("timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp = LocalDateTime.now();

}