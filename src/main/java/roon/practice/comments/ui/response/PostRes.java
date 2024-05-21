package roon.practice.comments.ui.response;

import java.time.Instant;
import java.util.List;
import roon.practice.comments.domain.Post;

public record PostRes(String id,
					  String categoryId,
					  String authorId,
					  String title,
					  String raw,
					  PostAdditionalInfo additionalInfo,
					  Instant createdAt,
					  Instant updatedAt) {

	public record PostAdditionalInfo(String cooked,
									 int wordCount,
									 int replyCount,
									 List<String> tagIds) {

	}

	public static PostRes from(Post post) {
		var additionalInfo = new PostAdditionalInfo(post.getCooked(), post.getWordCount(), post.getReplyCount(), post.getTagIds());
		return new PostRes(post.getId(), post.getCategoryId(), post.getAuthorId(), post.getTitle(), post.getRaw(), additionalInfo, post.getCreatedAt(),
				post.getUpdatedAt());
	}
}
