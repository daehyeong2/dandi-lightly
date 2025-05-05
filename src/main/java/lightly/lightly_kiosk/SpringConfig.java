package lightly.lightly_kiosk;

import lightly.lightly_kiosk.repository.ProductRepository;
import lightly.lightly_kiosk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
  private final ProductRepository productRepository;

  @Autowired
  public SpringConfig(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Bean
  public ProductService productService() {
    return new ProductService(productRepository);
  }
}
