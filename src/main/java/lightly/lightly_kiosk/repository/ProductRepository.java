package lightly.lightly_kiosk.repository;

import java.util.List;
import java.util.Optional;
import lightly.lightly_kiosk.domain.Product;

public interface ProductRepository {
  Product save(Product product);
  Optional<Product> findById(Long id);
  List<Product> findAll();
  List<Product> findByCategoryId(Long categoryId);
}
