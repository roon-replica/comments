package roon.practice.comments.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import roon.practice.comments.domain.DocumentNotFoundException;
import roon.practice.comments.domain.CategoryRepository;
import roon.practice.comments.domain.Post;
import roon.practice.comments.domain.PostRepository;
import roon.practice.comments.infra.IdGenerator;
import roon.practice.comments.ui.request.CreatePostReq;
import roon.practice.comments.ui.request.UpdatePostReq;

@Transactional
@RequiredArgsConstructor
@Service
public class PostService {

	private final PostRepository postRepository;
	private final CategoryRepository categoryRepository;

	public String create(CreatePostReq request) {
		var category = categoryRepository.findById(request.categoryId())
				.orElseThrow(() -> new DocumentNotFoundException(request.categoryId()));

		var post = new Post(IdGenerator.id(), request.categoryId(), request.authorId(), request.title(), request.contents(), request.tagIds());

		category.increasePostsCount();
		categoryRepository.save(category);
		return postRepository.save(post).getId();
	}

	public String update(UpdatePostReq request) {
		categoryRepository.findById(request.categoryId())
				.orElseThrow(() -> new DocumentNotFoundException(request.categoryId()));

		var post = postRepository.findById(request.id())
				.orElseThrow(() -> new DocumentNotFoundException(request.id()));

		post.update(request.title(), request.contents(), request.tagIds());

		return postRepository.save(post).getId();
	}

	public String delete(String postId) {
		var post = postRepository.findById(postId)
				.orElseThrow(() -> new DocumentNotFoundException(postId));
		var category = categoryRepository.findById(post.getCategoryId())
				.orElseThrow(() -> new DocumentNotFoundException(post.getCategoryId()));

		postRepository.delete(post);

		category.decreasePostsCount();
		categoryRepository.save(category);

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
