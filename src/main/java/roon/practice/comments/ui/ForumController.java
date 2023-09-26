package roon.practice.comments.ui;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import roon.practice.comments.application.ForumService;
import roon.practice.comments.domain.Forum;

@RestController
public class ForumController {

	private final ForumService forumService;

	public ForumController(ForumService forumService) {
		this.forumService = forumService;
	}

	@GetMapping("/forums")
	public List<Forum> findAll() {
		return forumService.findAll();
	}

	@GetMapping("/forums/{id}")
	public Forum findById(@PathVariable String id) {
		return forumService.findById(id);
	}

	@PostMapping("/create-forum")
	public String save(@RequestBody Forum forum) {
		return forumService.save(forum);
	}

}
