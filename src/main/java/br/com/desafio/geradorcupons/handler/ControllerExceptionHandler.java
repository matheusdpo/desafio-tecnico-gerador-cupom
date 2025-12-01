package br.com.desafio.geradorcupons.handler;

import br.com.desafio.geradorcupons.dto.response.CouponResponseError;
import br.com.desafio.geradorcupons.exception.CouponInvalidException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<CouponResponseError> handleErrorWithCode(DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new CouponResponseError("There was an error while trying to add your code. Please check and try again."));
    }

    @ExceptionHandler(CouponInvalidException.class)
    public ResponseEntity<CouponResponseError> handleErrorIfCouponInvalid(CouponInvalidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new CouponResponseError(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CouponResponseError> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new CouponResponseError("Unexpected error: " + e.getMessage()));
    }
}