package roon.practice.comments.ui;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionConstants {
	BAD_REQUEST(HttpStatus.BAD_REQUEST, "resource not found"),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "server failed to process request"),
	UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "please login"),
	FORBIDDEN(HttpStatus.UNAUTHORIZED, "check your authority");

	private final HttpStatus status;
	private String message;

	ExceptionConstants(HttpStatus status) {
		this.status = status;
	}

	ExceptionConstants(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}
}
