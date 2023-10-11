package roon.practice.comments.domain;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor
@Document(collection = "tag")
public class Tag {

	private String id;
	private String name;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public Tag(String id, String name) {
		this.id = id;
		this.name = name;
		this.createdAt = LocalDateTime.now();
	}

	public void update(String name) {
		this.name = name;
		this.updatedAt = LocalDateTime.now();
	}

}
