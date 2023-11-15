function showCategory(category) {
  // Ẩn tất cả các danh sách sản phẩm
  hideAllProductLists();

  // Hiển thị danh sách sản phẩm tương ứng với danh mục được chọn
  if (category === 'Giay') {
    document.querySelectorAll('.product-grid-ban-chay-giay').forEach(function (element) {
      element.style.display = 'block';
    });
  } else if (category === 'Balo') {
    document.querySelectorAll('.product-grid-ban-chay-balo').forEach(function (element) {
      element.style.display = 'block';
    });
  } else if (category === 'QuanAo') {
    document.querySelectorAll('.product-grid-ban-chay-quanao').forEach(function (element) {
      element.style.display = 'block';
    });
  }


function hideAllProductLists() {
  document.querySelectorAll('.product-grid-ban-chay-giay').forEach(function (element) {
    element.style.display = 'none';
  });
  document.querySelectorAll('.product-grid-ban-chay-balo').forEach(function (element) {
    element.style.display = 'none';
  });
    document.querySelectorAll('.product-grid-ban-chay-quanao').forEach(function (element) {
    element.style.display = 'none';
  });
  }
}