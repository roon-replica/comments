package roon.practice.comments.domain;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DocumentNotFoundException extends BusinessException {
	public DocumentNotFoundException(String id){
		super("Not found id: "+id);
	}

}
