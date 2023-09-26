package roon.practice.comments.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import roon.practice.comments.domain.DocumentNotFoundException;
import roon.practice.comments.domain.Forum;
import roon.practice.comments.domain.ForumRepository;

@Transactional
@RequiredArgsConstructor
@Service
public class ForumService {

	private final ForumRepository forumRepository;

	public String save(Forum forum) {
		return forumRepository.save(forum).getId();
	}

	public List<Forum> findAll() {
		return forumRepository.findAll();
	}

	public Forum findById(String id) {
		return forumRepository.findById(id)
				.orElseThrow(DocumentNotFoundException::new);
	}
}
