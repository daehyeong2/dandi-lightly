package lightly.lightly_kiosk.service;

import java.util.List;
import java.util.Optional;
import lightly.lightly_kiosk.domain.Product;
import lightly.lightly_kiosk.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ProductService {
  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Long save(Product product) {
    productRepository.save(product);
    return product.getId();
  }

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Optional<Product> findById(Long id) {
    return productRepository.findById(id);
  }

  public List<Product> findByCategoryId(Long categoryId) {
    return productRepository.findByCategoryId(categoryId);
  }
}
