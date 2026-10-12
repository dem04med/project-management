package com.example.projectmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice //indica que esta classe fica responsável por tratar as exceções lançadas em alternativa a esta função ser desempenhada por cada um dos controllers.
public class GlobalExceptionHandler {

    @ExceptionHandler(ProjectNotFoundException.class) //indica que o seguinte metodo trata exceçoes do tipo ProjectNotFoundException
    public ResponseEntity<Map<String, String>> handleProjectNotFound(ProjectNotFoundException exception){
        Map<String, String> error = Map.of("message", exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgument(IllegalArgumentException exception){
        Map<String, String> error = Map.of("message", exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Map<String, String>>> handleValidationErrors(
            MethodArgumentNotValidException exception) {

        Map<String, String> fieldErrors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        error -> error.getField(),
                        error -> error.getDefaultMessage(),
                        (existing, replacement) -> existing
                ));

        Map<String, Map<String, String>> response = Map.of(
                "errors", fieldErrors
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class) //trata valores inválidos, como os do status, que possui valores fixos
    public ResponseEntity<Map<String, Map<String, String>>> handleInvalidJson(
            HttpMessageNotReadableException exception) {

        Map<String, String> details = Map.of(
                "request", "O corpo do pedido contém JSON inválido ou valores incompatíveis."
        );

        var response = Map.of(
                "errors", details
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
}
