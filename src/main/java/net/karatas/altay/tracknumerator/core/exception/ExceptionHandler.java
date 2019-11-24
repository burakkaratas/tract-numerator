package net.karatas.altay.tracknumerator.core.exception;

import lombok.extern.log4j.Log4j2;
import net.karatas.altay.tracknumerator.core.context.Context;
import net.karatas.altay.tracknumerator.core.rest.reponse.RestExceptionResponse;
import net.karatas.altay.tracknumerator.core.rest.BaseDTO;
import net.karatas.altay.tracknumerator.core.exception.types.RestException;
import net.karatas.altay.tracknumerator.core.rest.reponse.BaseRestResponse;
import net.karatas.altay.tracknumerator.util.BundlelUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Log4j2
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseRestResponse<RestExceptionResponse>> handleException(MethodArgumentNotValidException exception) {
        log.error("Exception Handler:: ", exception);
        List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
        String errorMessage = allErrors
                .stream()
                .map(t -> BundlelUtil.getMessage(t.getDefaultMessage()))
                .collect(Collectors.joining(" * "));
        BaseRestResponse<BaseDTO> response = BaseRestResponse.builder().body(null)
                .responseStatus(HttpStatus.BAD_REQUEST.toString())
                .transaction(Context.getTx())
                .errors(new RestException(errorMessage)).build();
        ResponseEntity responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<BaseRestResponse<RestExceptionResponse>> handleException(Exception exception) {
        log.error("Exception Handler:: ", exception);
        BaseRestResponse<BaseDTO> response = BaseRestResponse.builder().body(null)
                .responseStatus(HttpStatus.BAD_REQUEST.toString())
                .transaction(Context.getTx())
                .errors(new RestException(exception.getLocalizedMessage())).build();
        ResponseEntity responseEntity = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }


}
