package lightly.lightly_kiosk.controller;

import lightly.lightly_kiosk.domain.Category;
import lightly.lightly_kiosk.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
  private final CategoryService categoryService;

  @Autowired
  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @PostMapping("/categories/create")
  public ResponseEntity<String> createCategory(CategoryForm form) {
    try {
      Category category = new Category();
      category.setName(form.getName());

      Long categoryId = categoryService.save(category);
      return new ResponseEntity<>("성공적으로 카테고리를 생성했습니다.", HttpStatus.OK);
    } catch (Error e){
      return new ResponseEntity<>("카테고리를 생성하는 중 에러갸 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
