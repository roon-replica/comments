package roon.practice.comments.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor
@Document(collection = "post")
public class Post {

	private static final int MAX_LENGTH = 100;

	@Id
	private String id;
	private String forumId;
	private String authorId;
	private String title;
	private String raw;
	private String cooked;
	private int wordCount;
	private int replyCount;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@Builder
	public Post(String id, String forumId, String authorId, String title, String raw) {
		validateLength(raw.length());

		this.id = id;
		this.forumId = forumId;
		this.authorId = authorId;
		this.title = title;
		this.raw = raw;

		this.wordCount = raw.length();
		this.replyCount = 0;
		this.createdAt = LocalDateTime.now();
	}

	public void update(String title, String raw) {
		validateLength(raw.length());

		this.title = title;
		this.raw = raw;
		this.wordCount = raw.length();
		this.updatedAt = LocalDateTime.now();
	}

	private void validateLength(int length) {
		if (length > MAX_LENGTH) {
			String message = "length: " + length + ", max length: " + MAX_LENGTH;
			throw new MaxPostLengthExceededException(message);
		}
	}
}
