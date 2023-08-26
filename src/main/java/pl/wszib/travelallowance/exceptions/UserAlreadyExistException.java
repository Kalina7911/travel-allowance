package pl.wszib.travelallowance.exceptions;

public class UserAlreadyExistException extends RuntimeException {


    public UserAlreadyExistException(String message) {
        super(message);
    }
}
