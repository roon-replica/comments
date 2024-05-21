package roon.practice.comments.ui.response;

import java.time.Instant;
import roon.practice.comments.domain.comment.Comment;

public record CommentRes(String id,
						 String authorId,
						 String postId,
						 String parentId,
						 String contents,
						 Instant createdAt,
						 Instant updatedAt,
						 int upVoteCount,
						 int downVoteCount) {

	public static CommentRes from(Comment c) {
		return new CommentRes(c.getId(), c.getAuthorId(), c.getPostId(), c.getParentId(), c.getContents(), c.getCreatedAt(), c.getUpdatedAt(),
				c.getUpVoteCount(), c.getDownVoteCount());
	}
}
