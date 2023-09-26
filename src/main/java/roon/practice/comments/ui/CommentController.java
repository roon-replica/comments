package roon.practice.comments.ui;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import roon.practice.comments.application.CommentService;
import roon.practice.comments.domain.comment.Comment;
import roon.practice.comments.ui.dto.CreateCommentRequest;
import roon.practice.comments.ui.dto.UpdateCommentRequest;

@RequiredArgsConstructor
@RestController
public class CommentController {

	private final CommentService commentService;

	@GetMapping("/comments")
	public List<Comment> comments() {
		return commentService.findAll();
	}

	@GetMapping("/comments/{id}")
	public Comment comment(@PathVariable String id) {
		return commentService.findById(id);
	}

	@PostMapping("/create-comment")
	public String create(@RequestBody CreateCommentRequest request) {
		return commentService.create(request);
	}

	@PostMapping("/update-comment")
	public String update(@RequestBody UpdateCommentRequest request) {
		return commentService.update(request);
	}

	@PostMapping("/delete-comment")
	public String delete(String id) {
		return commentService.delete(id);
	}

}
