package roon.practice.comments.domain;

public class MaxPostLengthExceededException extends BusinessException {

	public MaxPostLengthExceededException(String message) {
		super(message);
	}
}
