let categoryLoading = false;
let productLoading = false;
let createCategoryButton;
let createProductButton;

const onCreateCategory = async () => {
  if(categoryLoading) return;
  const name = prompt("카테고리 이름을 입력하세요.");
  if(!name) return;
  try {
    categoryLoading = true;
    createCategoryButton.innerText = "로딩 중..";
    const formData = new FormData();
    formData.append("name", name);
    const res = await fetch("/categories/create", {
      method: "POST",
      body: formData,
    });
    if (!res.ok) throw new Error(res.statusText);
    alert("생성 완료");
    document.location.reload();
  } catch (e) {
    console.log(e);
    alert("에러 발생. 콘솔을 확인하세요.")
  } finally {
    categoryLoading = false;
    createCategoryButton.innerText = "만들기";
  }
}

const onCreateProduct = async () => {
  if(productLoading) return;
  const name = prompt("상품 이름을 입력하세요. (1/4)");
  if(!name) return;
  const description = prompt("상품 설명을 입력하세요. (2/4)");
  if(!description) return;
  const price = prompt("상품 가격을 입력하세요. (3/4)");
  if(!price) return;
  const image = prompt("상품 이미지 링크를 입력하세요. (4/4)");
  if(!image) return;
  try {
    productLoading = true;
    createProductButton.innerText = "로딩 중..";
    const formData = new FormData();
    formData.append("name", name);
    formData.append("description", description);
    formData.append("price", price);
    formData.append("image", image);
    const params = new URL(document.location.href).searchParams;
    formData.append("categoryId", params.get("categoryId"));
    const res = await fetch("/products/create", {
      method: "POST",
      body: formData,
    });
    if (!res.ok) throw new Error(res.statusText);
    alert("생성 완료");
    document.location.reload();
  } catch (e) {
    console.log(e);
    alert("에러 발생. 콘솔을 확인하세요.")
  } finally {
    productLoading = false;
    createProductButton.innerText = "만들기";
  }
}

document.addEventListener("DOMContentLoaded", () => {
  createCategoryButton = document.getElementById("category-create");
  createCategoryButton.addEventListener("click", onCreateCategory);
  createProductButton = document.getElementById("product-create");
  createProductButton.addEventListener("click", onCreateProduct);
})

