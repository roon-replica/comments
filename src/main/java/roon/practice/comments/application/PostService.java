package roon.practice.comments.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import roon.practice.comments.domain.DocumentNotFoundException;
import roon.practice.comments.domain.ForumRepository;
import roon.practice.comments.domain.Post;
import roon.practice.comments.domain.PostRepository;
import roon.practice.comments.infra.IdGenerator;
import roon.practice.comments.ui.dto.CreatePostRequest;

@Transactional
@RequiredArgsConstructor
@Service
public class PostService {

	private final PostRepository postRepository;
	private final ForumRepository forumRepository;

	public String create(CreatePostRequest request) {
		var forum = forumRepository.findById(request.forumId())
				.orElseThrow(DocumentNotFoundException::new);

		var post = new Post(IdGenerator.id(), request.forumId(), request.authorId(), request.title(), request.contents());

		forum.increasePostsCount();
		forumRepository.save(forum);
		return postRepository.save(post).getId();
	}

	public String delete(String postId) {
		var post = postRepository.findById(postId)
				.orElseThrow(DocumentNotFoundException::new);
		var forum = forumRepository.findById(post.getForumId())
				.orElseThrow(DocumentNotFoundException::new);

		postRepository.delete(post);

		forum.decreasePostsCount();
		forumRepository.save(forum);

		return postId;
	}

	public List<Post> findAll() {
		return postRepository.findAll();
	}

	public Post findById(String id) {
		return postRepository.findById(id)
				.orElseThrow(DocumentNotFoundException::new);
	}
}
