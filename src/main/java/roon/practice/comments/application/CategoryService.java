package roon.practice.comments.application;

import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

	public Page<CategoryRes> findByPage(int pageNumber, int pageSize) {
		var pageable = PageRequest.of(pageNumber, pageSize);
		return categoryRepository.findAll(pageable)
				.map(CategoryRes::from);
	}

	public CategoryRes findById(String id) {
		var category = categoryRepository.findById(id)
				.orElseThrow(DocumentNotFoundException::new);

		return CategoryRes.from(category);
	}
}
