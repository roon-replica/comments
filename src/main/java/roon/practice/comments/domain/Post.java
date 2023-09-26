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
@Document(collection = "post")
public class Post {
	@Id
	private String id;
	private String forumId;
	private String authorId;
	private String title;
	private String raw;
	private String cooked;
	private int wordCount;
	private int replyCount;
	private LocalDateTime createdAt;
}
