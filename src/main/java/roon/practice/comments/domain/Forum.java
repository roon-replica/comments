package roon.practice.comments.domain;

import java.time.LocalDateTime;
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
@Document(collection = "forum")
public class Forum {

	@Id
	private String id;
	private String title;
	private int postsCount;
	private LocalDateTime createdAt;

	public void increasePostsCount() {
		this.postsCount++;
	}

	public void decreasePostsCount() {
		this.postsCount--;
	}
}
