package roon.practice.comments.domain;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor
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

	@Builder
	public Post(String id, String forumId, String authorId, String title, String raw){
		this.id = id;
		this.forumId = forumId;
		this.authorId = authorId;
		this.title = title;
		this.raw = raw;

		this.wordCount = raw.length();
		this.replyCount = 0;
		this.createdAt = LocalDateTime.now();
	}

	public void calculateWordCount(){
		this.wordCount = raw.length();
	}
}
