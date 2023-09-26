package roon.practice.comments.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import roon.practice.comments.domain.DocumentNotFoundException;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler({DocumentNotFoundException.class})
	public ResponseEntity<ExceptionConstants> handle(DocumentNotFoundException e) {
		log.error(e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ExceptionConstants.BAD_REQUEST);
	}

	@ExceptionHandler({IllegalArgumentException.class})
	public ResponseEntity<ExceptionConstants> handle(IllegalArgumentException e) {
		log.error(e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ExceptionConstants.BAD_REQUEST);
	}

	@ExceptionHandler({Exception.class})
	public ResponseEntity<ExceptionConstants> handle(Exception e) {
		log.error(e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ExceptionConstants.INTERNAL_SERVER_ERROR);
	}
}
