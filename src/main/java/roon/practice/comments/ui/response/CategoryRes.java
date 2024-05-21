package roon.practice.comments.ui.response;

import java.time.Instant;
import roon.practice.comments.domain.Category;

public record CategoryRes(String id, String title, int postCount, Instant createdAt) {

	public static CategoryRes from(Category category){
		return new CategoryRes(category.getId(), category.getTitle(), category.getPostsCount(), category.getCreatedAt());
	}
}
