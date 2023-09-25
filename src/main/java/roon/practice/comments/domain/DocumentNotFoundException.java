package roon.practice.comments.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DocumentNotFoundException extends RuntimeException {

	private String message;

	public DocumentNotFoundException(String message) {
		this.message = message;
	}

}
