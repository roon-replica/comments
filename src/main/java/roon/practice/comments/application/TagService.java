package roon.practice.comments.application;

import java.util.List;
import org.springframework.stereotype.Service;
import roon.practice.comments.domain.DocumentNotFoundException;
import roon.practice.comments.domain.Tag;
import roon.practice.comments.domain.TagRepository;
import roon.practice.comments.infra.IdGenerator;
import roon.practice.comments.ui.dto.CreateTagRequest;
import roon.practice.comments.ui.dto.UpdateTagRequest;

@Service
public class TagService {

	private TagRepository tagRepository;
	private FeatureToggleFacade featureToggleFacade;


	public TagService(TagRepository tagRepository, FeatureToggleFacade featureToggleFacade) {
		this.tagRepository = tagRepository;
		this.featureToggleFacade = featureToggleFacade;
	}

	public String createTag(CreateTagRequest request) {
		var tag = new Tag(IdGenerator.id(), request.name());
		featureToggleFacade.validateTagName(tag);

		return tagRepository.save(tag).getId();
	}

	public String updateTag(UpdateTagRequest request) {
		var tag = tagRepository.findById(request.id())
				.orElseThrow(DocumentNotFoundException::new);

		tag.update(request.name());
		featureToggleFacade.validateTagName(tag);

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
