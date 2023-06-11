package openweb.wmc.controllers.errors;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import openweb.wmc.model.exceptions.ContactException;
import openweb.wmc.model.exceptions.errors.ApiError;

@RestControllerAdvice // Loose coupled exception handling
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler{ // ResponseEntityExceptionHanlder - all errors

	// Specific error control.
	@ExceptionHandler(ContactException.class)
	public ResponseEntity<ApiError> handlerContactNotFound(ContactException contactException){
		ApiError apiError = new ApiError();
		apiError.setStatus(HttpStatus.NOT_FOUND); 
		apiError.setDate(LocalDateTime.now()); 
		apiError.setMessage(contactException.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(
			Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ApiError apiError = new ApiError();
		apiError.setStatus(HttpStatus.NOT_FOUND); 
		apiError.setDate(LocalDateTime.now()); 
		apiError.setMessage(ex.getMessage());
		return ResponseEntity.status(status).headers(headers).body(apiError); 
	}
	
}
