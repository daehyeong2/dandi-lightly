package lightly.lightly_kiosk.repository;

import java.util.Optional;
import lightly.lightly_kiosk.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaProductRepository extends JpaRepository<Product, Long>, ProductRepository {}
