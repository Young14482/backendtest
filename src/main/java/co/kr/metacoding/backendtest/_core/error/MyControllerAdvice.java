package co.kr.metacoding.backendtest._core.error;

import co.kr.metacoding.backendtest._core.error.ex.Exception400;
import co.kr.metacoding.backendtest._core.error.ex.Exception404;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(Exception400.class)
    public ResponseEntity<?> error400(Exception400 e) {
        ResponseEntity rn = new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        return rn;
    }

    @ExceptionHandler(Exception404.class)
    public ResponseEntity<?> error404(Exception404 e) {
        ResponseEntity rn = new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
        return rn;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<?> error400() {
        ResponseEntity rn = new ResponseEntity<>(new ErrorResponse("유효하지 않은 주소"), HttpStatus.NOT_FOUND);
        return rn;
    }

    // MethodArgumentTypeMismatchException을 처리하여 Exception400 던지기
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        // 예외 처리 후 커스텀 메시지와 함께 400 Bad Request 응답 반환
        String errorMessage = "잘못된 ID 형식입니다. 정수 값을 입력해 주세요.";
        return new ResponseEntity<>(new ErrorResponse(errorMessage), HttpStatus.BAD_REQUEST);
    }

}