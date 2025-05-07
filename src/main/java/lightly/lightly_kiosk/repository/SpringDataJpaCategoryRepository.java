package lightly.lightly_kiosk.repository;

import java.util.Optional;
import lightly.lightly_kiosk.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaCategoryRepository extends JpaRepository<Category, Long>, CategoryRepository {
  @Override
  Optional<Category> findByName(String name);
}
