package com.dpkprojects.app.ui.exception.handlers;

import com.dpkprojects.app.ui.exception.exceptionClasses.UserServiceExceptionClass;
import com.dpkprojects.app.ui.models.exceptionModels.ExceptionHandlerObj;
import jakarta.validation.constraints.Null;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class appExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * handles any kind of exception in the application
     * @param ex
     * @return
     */
    @ExceptionHandler(value={Exception.class})
    public ResponseEntity<ExceptionHandlerObj> handleAnyException(Exception ex){
        String exceptionMessageDescription = ex.getLocalizedMessage();
        ExceptionHandlerObj exceptionHandlerObj = new ExceptionHandlerObj(new Date(),exceptionMessageDescription);
        return new ResponseEntity<ExceptionHandlerObj>(
                exceptionHandlerObj,HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    /**
     * handle null pointer exception
     * @param ex
     * @return
     */
    @ExceptionHandler(value={NullPointerException.class})
    public ResponseEntity<ExceptionHandlerObj> handleNullPointerException(NullPointerException ex){
        String exceptionMessageDescription = ex.getLocalizedMessage();
        ExceptionHandlerObj exceptionHandlerObj = new ExceptionHandlerObj(new Date(),exceptionMessageDescription);
        return new ResponseEntity<ExceptionHandlerObj>(
                exceptionHandlerObj,HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    /**
     * handles user service exceptions
     * @param userServiceex
     * @return
     */
    @ExceptionHandler(value = {UserServiceExceptionClass.class})
    public ResponseEntity<ExceptionHandlerObj> handleUserServiceException(UserServiceExceptionClass userServiceex){
        String exceptionMessageDescription = userServiceex.getLocalizedMessage();
        ExceptionHandlerObj exceptionHandlerObj = new ExceptionHandlerObj(new Date(),exceptionMessageDescription);
        return new ResponseEntity<ExceptionHandlerObj>(
                exceptionHandlerObj,HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
