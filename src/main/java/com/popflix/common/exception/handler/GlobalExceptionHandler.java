package com.popflix.common.exception.handler;

import com.popflix.global.util.ApiUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatusCode statusCode, WebRequest request) {
        log.error(ex.getMessage(), ex);

        ApiUtil.ApiError<String> error = ApiUtil.error(statusCode.value(), "알 수 없는 오류가 발생했습니다. 문의 바랍니다.");
        return super.handleExceptionInternal(ex, error, headers, statusCode, request);
    }
}
