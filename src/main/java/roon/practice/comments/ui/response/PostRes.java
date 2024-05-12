package roon.practice.comments.ui.response;

import java.time.Instant;
import java.util.List;

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
}
