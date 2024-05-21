package roon.practice.comments.ui;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import roon.practice.comments.application.TagService;
import roon.practice.comments.ui.request.CreateTagReq;
import roon.practice.comments.ui.request.UpdateTagReq;
import roon.practice.comments.ui.response.TagRes;

@RestController
public class TagController {

	private final TagService tagService;

	public TagController(TagService tagService) {
		this.tagService = tagService;
	}

	@GetMapping("/tags")
	public Page<TagRes> tags(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "10") int pageSize) {
		return tagService.findByPage(pageNumber, pageSize);
	}

	@GetMapping("/tags/{id}")
	public TagRes getTagById(String id) {
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
