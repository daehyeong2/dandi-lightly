package lightly.lightly_kiosk.controller;

import java.util.List;
import java.util.Optional;
import lightly.lightly_kiosk.domain.Category;
import lightly.lightly_kiosk.domain.Product;
import lightly.lightly_kiosk.service.CategoryService;
import lightly.lightly_kiosk.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
  private final ProductService productService;
  private final CategoryService categoryService;

  public ProductController(ProductService productService, CategoryService categoryService) {
    this.productService = productService;
    this.categoryService = categoryService;
  }

  @GetMapping("/")
  public String home(Model model, @RequestParam("categoryId") Optional<String> categoryParam){
    if (categoryParam.isEmpty()){
      model.addAttribute("categories", categoryService.findAll());
      return "index";
    }
    Long categoryId;
    try {
      categoryId = Long.parseLong(categoryParam.get());
    } catch(NumberFormatException e) {
      return "404";
    }
    Optional<Category> category = categoryService.findById(categoryId);
    if(category.isEmpty()) {
      model.addAttribute("categories", categoryService.findAll());
      return "index";
    };
    List<Product> products = productService.findByCategoryId(categoryId);
    List<Category> categories = categoryService.findAll();
    model.addAttribute("products", products);
    model.addAttribute("categories", categories);
    model.addAttribute("categoryId", categoryId);
    return "index";
  }

  @GetMapping("/dashboard")
  public String dashboard(Model model, @RequestParam("categoryId") Optional<String> categoryParam){
    if (categoryParam.isEmpty()) {
      model.addAttribute("categories", categoryService.findAll());
      return "dashboard";
    }
    Long categoryId;
    try {
      categoryId = Long.parseLong(categoryParam.get());
    } catch(NumberFormatException e) {
      return "404";
    }
    Optional<Category> category = categoryService.findById(categoryId);
    if(category.isEmpty()){
      model.addAttribute("categories", categoryService.findAll());
      return "dashboard";
    }
    List<Product> products = productService.findByCategoryId(categoryId);
    List<Category> categories = categoryService.findAll();
    model.addAttribute("products", products);
    model.addAttribute("categories", categories);
    model.addAttribute("categoryId", categoryId);
    return "dashboard";
  }

  @PostMapping("/products/create")
  public ResponseEntity<String> createProduct(ProductForm form){
    try {
      Product product = new Product();
      product.setName(form.getName());
      product.setDescription(form.getDescription());
      product.setPrice(form.getPrice());
      product.setImage(form.getImage());
      Optional<Category> category = categoryService.findById(form.getCategoryId());
      if(category.isEmpty()) return new ResponseEntity<>("카테고리가 존재하지 않습니다.", HttpStatus.NOT_FOUND);
      product.setCategory(category.get());

      productService.save(product);
      return new ResponseEntity<>("성공적으로 상품을 생성했습니다.", HttpStatus.OK);
    } catch(Error e){
      return new ResponseEntity<>("상품을 생성하는 중 에러가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
