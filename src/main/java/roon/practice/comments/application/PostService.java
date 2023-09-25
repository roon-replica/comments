package roon.practice.comments.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import roon.practice.comments.domain.DocumentNotFoundException;
import roon.practice.comments.domain.Post;
import roon.practice.comments.domain.PostRepository;

@RequiredArgsConstructor
@Service
public class PostService {

	private final PostRepository postRepository;

	public String create(Post post) {
		return postRepository.save(post).getId();
	}

	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public Post findById(String id) {
		return postRepository.findById(id)
				.orElseThrow(DocumentNotFoundException::new);
	}
}
