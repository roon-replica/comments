package roon.practice.comments.application;

import java.util.List;
import org.springframework.stereotype.Service;
import roon.practice.comments.domain.DocumentNotFoundException;
import roon.practice.comments.domain.Tag;
import roon.practice.comments.domain.TagRepository;
import roon.practice.comments.infra.IdGenerator;
import roon.practice.comments.ui.request.CreateTagReq;
import roon.practice.comments.ui.request.UpdateTagReq;

@Service
public class TagService {

	private TagRepository tagRepository;

	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}

	public String createTag(CreateTagReq request) {
		var tag = new Tag(IdGenerator.id(), request.name());
		// validate tag name

		return tagRepository.save(tag).getId();
	}

	public String updateTag(UpdateTagReq request) {
		var tag = tagRepository.findById(request.id())
				.orElseThrow(DocumentNotFoundException::new);

		tag.update(request.name());
		// validate tag name

		return tagRepository.save(tag).getId();
	}

	public void deleteTag(String id) {
		var tag = tagRepository.findById(id)
				.orElseThrow(DocumentNotFoundException::new);

		tagRepository.delete(tag);
	}

	public Tag findById(String id) {
		return tagRepository.findById(id)
				.orElseThrow(DocumentNotFoundException::new);
	}

	public List<Tag> findAll() {
		return tagRepository.findAll();
	}

}
