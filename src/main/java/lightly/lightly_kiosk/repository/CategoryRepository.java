package lightly.lightly_kiosk.repository;

import java.util.List;
import java.util.Optional;
import lightly.lightly_kiosk.domain.Category;

public interface CategoryRepository {
  Category save(Category category);
  Optional<Category> findById(Long id);
  List<Category> findAll();
}
