package cat.itacademy.barcelonactiva.martos.sandra.s05.t01.n02.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.util.BindErrorUtils;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex){
        return ResponseEntity.badRequest().body("Input not valid\n" + BindErrorUtils.resolveAndJoin(ex.getFieldErrors()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(EntityNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No element found with this id");
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handlePrimaryKeyViolation(DataIntegrityViolationException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Element already exists");
    }

    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<String> handleInvalidInput(HttpMessageConversionException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Incorrect data type");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something unexpected went wrong\n" + ex.getMessage());
    }
}
