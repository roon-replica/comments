package roon.practice.comments.domain.comment;

import java.time.LocalDateTime;
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
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private String parentId;
	private int upVoteCount;
	private int downVoteCount;

	public Comment(String id, String postId, String authorId, String contents, String parentId) {
		this.id = id;
		this.postId = postId;
		this.authorId = authorId;
		this.contents = contents;
		this.parentId = parentId;

		this.createdAt = LocalDateTime.now();
		this.upVoteCount = 0;
		this.downVoteCount = 0;
	}

	public void update(String contents) {
		this.contents = contents;
		this.updatedAt = LocalDateTime.now();
	}
}
