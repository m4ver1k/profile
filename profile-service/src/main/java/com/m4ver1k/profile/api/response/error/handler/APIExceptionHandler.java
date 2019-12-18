package com.m4ver1k.profile.api.response.error.handler;

import com.m4ver1k.profile.api.response.ErrorResponse;
import com.m4ver1k.profile.exception.ProfileNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
@Slf4j
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle {@link ProfileNotFoundException}
     */
    @ExceptionHandler(ProfileNotFoundException.class)
    protected ResponseEntity<Object> handleProfileNotFound(ProfileNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse("p1001", "Profile Not Found", ex.getMessage());

        logger.error(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

}
