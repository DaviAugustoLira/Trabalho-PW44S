package edu.br.utpfr.trabalho_pw44s.server.error;

import edu.br.utpfr.trabalho_pw44s.server.error.exception.Conflict;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handlerValidationException(MethodArgumentNotValidException exception,
                                               HttpServletRequest request) {
        BindingResult result = exception.getBindingResult();
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError fieldError : result.getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return new ApiError(HttpStatus.BAD_REQUEST.value(), "Validation error!",
                request.getServletPath(), validationErrors);
    }

    @ExceptionHandler({IllegalStateException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handlerValidationException(IllegalStateException exception,
                                               HttpServletRequest request) {
        return new ApiError(HttpStatus.BAD_REQUEST.value(), "Validation error!",
                request.getServletPath(), null);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handlerValidationException(HttpMessageNotReadableException exception,
                                               HttpServletRequest request) {
        return new ApiError(HttpStatus.BAD_REQUEST.value(), "Validation error!",
                request.getServletPath(), null);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handlerNotFoundException(EntityNotFoundException exception,
                                             HttpServletRequest request) {
        return new ApiError(HttpStatus.NOT_FOUND.value(), exception.getMessage(),
                request.getServletPath(), null);
    }

    @ExceptionHandler({Conflict.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handlerConflictException(Conflict exception,
                                             HttpServletRequest request) {
        return new ApiError(HttpStatus.CONFLICT.value(), exception.getMessage(),
                request.getServletPath(), null);
    }


}