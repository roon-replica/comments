package roon.practice.comments.ui.response;

import java.time.Instant;
import roon.practice.comments.domain.Tag;

public record TagRes(String id,
					 String name,
					 Instant createdAt,
					 Instant updatedAt
) {
	public static TagRes from(Tag tag){
		return new TagRes(tag.getId(), tag.getName(), tag.getCreatedAt(), tag.getUpdatedAt());
	}
}
