package roon.practice.comments.domain.comment;

import java.time.Instant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor
@Document(collection = "comment")
public class Comment {

	@Id
	private String id;
	private String authorId;
	private String postId;
	private String contents;
	private Instant createdAt;
	private Instant updatedAt;
	private String parentId;
	private int upVoteCount;
	private int downVoteCount;

	public Comment(String id, String postId, String authorId, String contents, String parentId) {
		this.id = id;
		this.postId = postId;
		this.authorId = authorId;
		this.contents = contents;
		this.parentId = parentId;

		this.createdAt = Instant.now();
		this.upVoteCount = 0;
		this.downVoteCount = 0;
	}

	public void update(String contents) {
		this.contents = contents;
		this.updatedAt = Instant.now();
	}
}
