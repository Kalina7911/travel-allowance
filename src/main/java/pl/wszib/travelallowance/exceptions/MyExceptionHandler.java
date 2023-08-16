package pl.wszib.travelallowance.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@ControllerAdvice
public class MyExceptionHandler {


    @ExceptionHandler(value = {UserAlreadyExistException.class})
    public ResponseEntity<String> handleResourceAlreadyExists(RuntimeException ex) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());


    }
}

