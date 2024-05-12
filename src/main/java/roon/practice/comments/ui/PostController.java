package roon.practice.comments.ui;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import roon.practice.comments.application.PostService;
import roon.practice.comments.ui.request.CreatePostReq;
import roon.practice.comments.ui.request.UpdatePostReq;
import roon.practice.comments.ui.response.PostRes;

@RequiredArgsConstructor
@RestController
public class PostController {

	private final PostService postService;

	@GetMapping("/posts")
	public List<PostRes> findAll() {
		return postService.findAll();
	}

	@GetMapping("/posts/{id}")
	public PostRes findById(@PathVariable String id) {
		return postService.findById(id);
	}

	@PostMapping("/create-post")
	public String create(@RequestBody CreatePostReq request) {
		return postService.create(request);
	}

	@PostMapping("/update-post")
	public String update(@RequestBody UpdatePostReq request) {
		return postService.update(request);
	}

	@PostMapping("/delete-post")
	public String delete(String postId) {
		return postService.delete(postId);
	}

}
