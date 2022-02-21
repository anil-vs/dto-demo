package com.eo.demo.handler;

import com.eo.demo.dto.ErrorResponseDto;
import com.eo.demo.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDto handleNotFoundException(NotFoundException e) {
        return ErrorResponseDto
                .builder()
                .code(HttpStatus.NOT_FOUND.value())
                .message(e.getMessage())
                .build();
    }

}
