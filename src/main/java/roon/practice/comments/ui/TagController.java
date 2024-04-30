package roon.practice.comments.ui;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import roon.practice.comments.application.TagService;
import roon.practice.comments.domain.Tag;
import roon.practice.comments.ui.request.CreateTagReq;
import roon.practice.comments.ui.request.UpdateTagReq;

@RestController
public class TagController {

	private final TagService tagService;

	public TagController(TagService tagService) {
		this.tagService = tagService;
	}

	@GetMapping("/tags")
	public List<Tag> tags() {
		return tagService.findAll();
	}

	@GetMapping("/tags/{id}")
	public Tag getTagById(String id) {
		return tagService.findById(id);
	}

	@PostMapping("/create-tag")
	public String createTag(@RequestBody CreateTagReq request) {
		return tagService.createTag(request);
	}

	@PostMapping("/update-tag")
	public String updateTag(@RequestBody UpdateTagReq request) {
		return tagService.updateTag(request);
	}

	@DeleteMapping("/delete-tag")
	public String deleteTag(String id) {
		tagService.deleteTag(id);
		return id;
	}
}
