package roon.practice.comments.ui.response;

import java.time.Instant;

public record CommentRes(String id,
						 String authorId,
						 String postId,
						 String parentId,
						 String contents,
						 Instant createdAt,
						 Instant updatedAt,
						 int upVoteCount,
						 int downVoteCount) {

}
