package lightly.lightly_kiosk;

import lightly.lightly_kiosk.repository.CategoryRepository;
import lightly.lightly_kiosk.repository.ProductRepository;
import lightly.lightly_kiosk.service.CategoryService;
import lightly.lightly_kiosk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;

  @Autowired
  public SpringConfig(ProductRepository productRepository, CategoryRepository categoryRepository) {
    this.productRepository = productRepository;
    this.categoryRepository = categoryRepository;
  }

  @Bean
  public ProductService productService() {
    return new ProductService(productRepository);
  }

  @Bean
  public CategoryService categoryService() {
    return new CategoryService(categoryRepository);
  }
}
