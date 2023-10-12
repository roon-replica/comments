package roon.practice.comments.domain;

public class IllegalRequestException extends BusinessException{
	public IllegalRequestException(String message){
		super(message);
	}
}
