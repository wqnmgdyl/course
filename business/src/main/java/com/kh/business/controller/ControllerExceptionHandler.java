package com.kh.business.controller;

import com.kh.server.dto.ResponseDto;
import com.kh.server.exception.ValidatorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author han.ke
 */
@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = ValidatorException.class)
    @ResponseBody
    public ResponseDto validatorExceptionHandler(ValidatorException e) {
            ResponseDto responseDto = new ResponseDto();
            responseDto.setSuccess(false);
            log.warn(e.getMessage());
            responseDto.setMessage("请求参数异常");
            return responseDto;
    }
}
