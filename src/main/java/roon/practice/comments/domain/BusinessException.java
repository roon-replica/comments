package roon.practice.comments.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public abstract class BusinessException extends RuntimeException {

	private String message;

	public BusinessException(String message) {
		this.message = message;
	}
}
