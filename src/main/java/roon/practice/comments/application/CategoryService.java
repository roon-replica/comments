package roon.practice.comments.application;

import java.time.Instant;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import roon.practice.comments.domain.Category;
import roon.practice.comments.domain.CategoryRepository;
import roon.practice.comments.domain.DocumentNotFoundException;
import roon.practice.comments.infra.IdGenerator;
import roon.practice.comments.ui.response.CategoryRes;

@Transactional
@RequiredArgsConstructor
@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public String save(String title) {
		var category = new Category(IdGenerator.id(), title, 0, Instant.now());
		return categoryRepository.save(category).getId();
	}

	public List<CategoryRes> findAll() {
		var categories = categoryRepository.findAll();

		return categories.stream()
				.map(c -> new CategoryRes(c.getId(), c.getTitle(), c.getPostsCount(), c.getCreatedAt()))
				.toList();
	}

	public CategoryRes findById(String id) {
		var category = categoryRepository.findById(id)
				.orElseThrow(DocumentNotFoundException::new);

		return new CategoryRes(category.getId(), category.getTitle(), category.getPostsCount(), category.getCreatedAt());
	}
}
