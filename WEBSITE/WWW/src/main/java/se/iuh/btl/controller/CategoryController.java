package se.iuh.btl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import se.iuh.btl.entities.Category;
import se.iuh.btl.service.categoryservice.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	public CategoryService categoryService;

	@Autowired(required = true)
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/listcategorys")
	public String listCategorys(Model model) {
		List<Category> categorys = categoryService.getCategorys();
		model.addAttribute("categorys", categorys);
		return "list-categorys";
	}

	@GetMapping("/showCategoryForm")
	public String showFormForAdd(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "category-form";
	}

	@PostMapping("/saveCategory")
	public String saveCategory(@ModelAttribute("category") Category category) {
		categoryService.saveCategory(category);
		return "redirect:/category/listcategorys";
	}

	@GetMapping("/updateCategoryForm/{id}")
	public String showFormForUpdate(@PathVariable("id") int id, Model model) {
		Category category = categoryService.getCategory(id);
		model.addAttribute("category", category);
		return "Category-form";
	}

	@GetMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable("id") int id) {
		categoryService.deleteCategory(id);
		return "redirect:/category/listCategorys";
	}
}
