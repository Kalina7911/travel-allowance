package pl.wszib.travelallowance.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class MyExceptionHandler {


    @ExceptionHandler(value = {UserAlreadyExistException.class})
    public ResponseEntity<String> handleResourceAlreadyExists(RuntimeException ex) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());

    }

    @ExceptionHandler(value = {WorkingDaysException.class, ShiftException.class})
    public String handlerWorkingDaysAndShifts(RuntimeException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());

        return "redirect:/preferences";

    }


    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public String handlerNull(MethodArgumentNotValidException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("fieldRequiredError", "All Fields Are Required");

        return "redirect:/preferences";
    }
}

