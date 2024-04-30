package roon.practice.comments.ui;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import roon.practice.comments.application.CategoryService;
import roon.practice.comments.ui.request.CreateCategoryReq;
import roon.practice.comments.ui.response.CategoryRes;

@RestController
public class CategoryController {

	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/categories")
	public List<CategoryRes> findAll() {
		return categoryService.findAll();
	}

	@GetMapping("/categories/{id}")
	public CategoryRes findById(@PathVariable String id) {
		return categoryService.findById(id);
	}

	@PostMapping("/create-category")
	public String save(@RequestBody CreateCategoryReq category) {
		return categoryService.save(category.title());
	}

}
