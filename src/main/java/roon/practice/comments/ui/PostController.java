package roon.practice.comments.ui;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import roon.practice.comments.application.PostService;
import roon.practice.comments.domain.Post;
import roon.practice.comments.ui.dto.CreatePostRequest;

@RequiredArgsConstructor
@RestController
public class PostController {
	private final PostService postService;

	@GetMapping("/posts")
	public List<Post> findAll() {
		return postService.findAll();
	}

	@GetMapping("/posts/{id}")
	public Post findById(@PathVariable String id) {
		return postService.findById(id);
	}

	@PostMapping("/create-post")
	public String create(@RequestBody CreatePostRequest request) {
		return postService.create(request);
	}

	@PostMapping("/delete-post")
	public String delete(String postId){
		return postService.delete(postId);
	}

}
