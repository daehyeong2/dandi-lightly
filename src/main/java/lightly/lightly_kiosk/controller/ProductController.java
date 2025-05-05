package lightly.lightly_kiosk.controller;

import java.util.List;
import lightly.lightly_kiosk.domain.Product;
import lightly.lightly_kiosk.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
  private final ProductService productService;

  public ProductController(ProductService productService) {this.productService = productService;}

  @GetMapping("/")
  public String home(Model model){
    List<Product> result = productService.findAll();
    model.addAttribute("products", result);
    return "index";
  }
}
