package com.example.companydemo.config;

import com.unicloud.factory.IResponseFactory;
import com.unicloud.rest.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
@ControllerAdvice
public class GlobalException extends GlobalExceptionHandler {

    protected GlobalException(IResponseFactory iResponseFactory) {
        super(iResponseFactory);
    }
}
