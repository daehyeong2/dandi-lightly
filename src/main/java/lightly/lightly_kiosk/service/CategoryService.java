package lightly.lightly_kiosk.service;

import java.util.List;
import java.util.Optional;
import lightly.lightly_kiosk.domain.Category;
import lightly.lightly_kiosk.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CategoryService {
  private final CategoryRepository categoryRepository;

  @Autowired
  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public Long save(Category category) {
    validateDuplicatedName(category);
    categoryRepository.save(category);
    return category.getId();
  }

  private void validateDuplicatedName(Category category) {
    categoryRepository.findByName(category.getName()).ifPresent(c -> {
      throw new IllegalStateException("이미 존재하는 카테고리입니다.");
    });
  }

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public Optional<Category> findById(Long id) {
    return categoryRepository.findById(id);
  }
}
