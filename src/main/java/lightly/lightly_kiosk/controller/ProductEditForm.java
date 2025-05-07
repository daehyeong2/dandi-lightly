package lightly.lightly_kiosk.controller;

import java.util.Optional;

public class ProductEditForm {
  private Long id;
  private Optional<String> name = Optional.empty();
  private Optional<String> description = Optional.empty();
  private Optional<Long> price = Optional.empty();
  private Optional<String> image = Optional.empty();
  private Optional<Long> categoryId = Optional.empty();

  public Optional<String> getName() {
    return name;
  }

  public void setName(Optional<String> name) {
    if(name.isPresent()){
      this.name = name;
    }
  }

  public Optional<String> getDescription() {
    return description;
  }

  public void setDescription(Optional<String> description) {
    if(description.isPresent()){
      this.description = description;
    }
  }

  public Optional<Long> getPrice() {
    return price;
  }

  public void setPrice(Optional<Long> price) {
    if(price.isPresent()){
      this.price = price;
    }
  }

  public Optional<String> getImage() {
    return image;
  }

  public void setImage(Optional<String> image) {
    this.image = image;
  }

  public Optional<Long> getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Optional<Long> categoryId) {
    if(categoryId.isPresent()){
      this.categoryId = categoryId;
    };
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
