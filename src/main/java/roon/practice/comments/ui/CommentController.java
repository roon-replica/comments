package roon.practice.comments.ui;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import roon.practice.comments.application.CommentService;
import roon.practice.comments.ui.request.CreateCommentReq;
import roon.practice.comments.ui.request.UpdateCommentReq;
import roon.practice.comments.ui.response.CommentRes;

@RequiredArgsConstructor
@RestController
public class CommentController {

	private final CommentService commentService;

	@GetMapping("/comments")
	public Page<CommentRes> comments(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "10") int pageSize) {
		return commentService.findByPage(pageNumber, pageSize);
	}

	@GetMapping("/comments/{id}")
	public CommentRes comment(@PathVariable String id) {
		return commentService.findById(id);
	}

	@PostMapping("/create-comment")
	public String create(@RequestBody CreateCommentReq request) {
		return commentService.create(request);
	}

	@PostMapping("/update-comment")
	public String update(@RequestBody UpdateCommentReq request) {
		return commentService.update(request);
	}

	@PostMapping("/delete-comment")
	public String delete(String id) {
		return commentService.delete(id);
	}

}
