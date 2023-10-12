package roon.practice.comments.domain;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor
@Document(collection = "tag")
public class Tag {

	private String id;
	private String name;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	private static final List<String> bannedWords = List.of("ban1", "ban2");

	private static final int maxLength = 15;

	public Tag(String id, String name) {
		this.id = id;
		this.name = name;

		this.createdAt = LocalDateTime.now();
	}

	public void update(String name) {
		this.name = name;
		this.updatedAt = LocalDateTime.now();
	}

	public void validateTagNameLength() {
		if (name.length() > maxLength) {
			throw new IllegalRequestException("tag name length too long");
		}
	}

	public void validateTagNameWords() {
		for (var bannedWord : bannedWords) {
			if (name.contains(bannedWord)) {
				throw new IllegalRequestException("tag name contains banned words");
			}
		}
	}

}
