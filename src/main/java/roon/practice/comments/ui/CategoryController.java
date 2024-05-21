package roon.practice.comments.ui;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	public Page<CategoryRes> categories(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "10") int pageSize) {
		return categoryService.findByPage(pageNumber,pageSize);
	}

	@GetMapping("/categories/{id}")
	public CategoryRes getCategoryById(@PathVariable String id) {
		return categoryService.findById(id);
	}

	@PostMapping("/create-category")
	public String save(@RequestBody CreateCategoryReq category) {
		return categoryService.save(category.title());
	}

}
