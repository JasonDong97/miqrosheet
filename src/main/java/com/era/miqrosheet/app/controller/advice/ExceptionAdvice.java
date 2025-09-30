package com.era.miqrosheet.app.controller.advice;

import com.era.miqrosheet.domain.model.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public R<Object> handleException(HttpServletRequest request, Exception e) {
        log.error(request.getRequestURL().toString(), e);
        return R.fail(e.getMessage());
    }

}
