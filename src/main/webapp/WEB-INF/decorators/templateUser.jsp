<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
	<%@ include file="/common/hrefsheet.jsp" %>	
	<sitemesh:write property=head></sitemesh:write>
	<title><sitemesh:write property='title'/></title>
<link rel="stylesheet" href="assets/css/newBootrapMin.css">

<style>
.cart-icon-container {
  position: relative;
  display: inline-block;
}

.product-count {
  position: absolute;
  top: -10px;
  right: -10px;
  color: red;
  padding: 4px;
  font-size: 12px;
}
@keyframes bounce {
  0%, 20%, 50%, 80%, 100% {
    transform: translateY(0);
  }
  
  40% {
    transform: translateY(-10px);
  }

  60% {
    transform: translateY(-5px);
  }
}

.product-count {
  animation: bounce 1s infinite;
}

</style>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdn.reflowhq.com/v2/toolkit.min.js" data-reflow-store="408435610"></script>
    <script src="assets/js/bs-init.js"></script>
<!--     <script src="assets/js/grayscale.js"></script>
 -->    <script src="assets/js/decription-product.js"></script>

</head>
<body>
	<%@ include file="/common/header.jsp" %>
	<sitemesh:write property='body'></sitemesh:write>
	<%@ include file="/common/footer.jsp" %>

</body>
</html>