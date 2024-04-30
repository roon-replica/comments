package roon.practice.comments.domain;

import java.time.Instant;
import java.util.List;
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
	private String categoryId;
	private String authorId;
	private String title;
	private String raw;
	private String cooked;
	private int wordCount;
	private int replyCount;

	private List<String> tagIds;
	private Instant createdAt;
	private Instant updatedAt;

	@Builder
	public Post(String id, String categoryId, String authorId, String title, String raw, List<String> tagIds) {
		validateLength(raw.length());

		this.id = id;
		this.categoryId = categoryId;
		this.authorId = authorId;
		this.title = title;
		this.raw = raw;

		this.wordCount = raw.length();
		this.replyCount = 0;

		this.tagIds = tagIds;

		this.createdAt = Instant.now();
	}

	public void update(String title, String raw, List<String> tagIds) {
		validateLength(raw.length());

		this.title = title;
		this.raw = raw;
		this.wordCount = raw.length();
		this.tagIds = tagIds;
		this.updatedAt = Instant.now();
	}

	private void validateLength(int length) {
		if (length > MAX_LENGTH) {
			String message = "length: " + length + ", max length: " + MAX_LENGTH;
			throw new MaxPostLengthExceededException(message);
		}
	}

	public void increaseReplyCount() {
		this.replyCount++;
	}

	public void decreaseReplyCount() {
		this.replyCount--;
	}
}
