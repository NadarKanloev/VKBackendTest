package org.nadarkanloev.vkbackendtest.Controller;

import org.nadarkanloev.vkbackendtest.Exception.ErrorDetails;
import org.nadarkanloev.vkbackendtest.Exception.NotValidEmailException;
import org.nadarkanloev.vkbackendtest.Exception.UserAlreadyExistException;
import org.nadarkanloev.vkbackendtest.Exception.WeakPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(WeakPasswordException.class)
    public ResponseEntity<Object> handleWeakPasswordException(WeakPasswordException weakPasswordException){
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST.value(), weakPasswordException.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExistException userAlreadyExistException){
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST.value(), userAlreadyExistException.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotValidEmailException.class)
    public ResponseEntity<Object> handleNotValidException(NotValidEmailException notValidEmailException){
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST.value(), notValidEmailException.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
