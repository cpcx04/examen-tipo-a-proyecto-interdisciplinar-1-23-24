package com.salesianostriana.dam.rest.error;

import com.salesianostriana.dam.rest.error.exception.IncorrectPasswordException;
import com.salesianostriana.dam.rest.security.errorhandling.TokenControllerAdvice.ErrorMessage;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


public class ExcepctionGlobalRestController {

    @ResponseBody
    @ExceptionHandler({IncorrectPasswordException.class})
    public ResponseEntity<?> handleControllerException(HttpServletRequest request, IncorrectPasswordException ex) {
        HttpStatus status = getStatus(request);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(ErrorMessage.of(
                        HttpStatus.UNAUTHORIZED,
                        ex.getMessage(),
                        request.getRequestURI()));
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer code = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        HttpStatus status = HttpStatus.resolve(code);
        return (status != null) ? status : HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
