package roon.practice.comments.domain;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "category")
public class Category {

	@Id
	private String id;
	private String title;
	private int postsCount;
	private Instant createdAt;

	public void increasePostsCount() {
		this.postsCount++;
	}

	public void decreasePostsCount() {
		this.postsCount--;
	}
}
