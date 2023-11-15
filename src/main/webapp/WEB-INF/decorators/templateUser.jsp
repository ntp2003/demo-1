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
<link rel="stylesheet" href="assets/css/newBootrapMin.css">

	<%-- <%
	// Kiểm tra sự tồn tại của session "customer"
	if (session.getAttribute("customer") != null) {
	    // Session "customer" đã tồn tại
	    // Ẩn button Login
	%>
	    <style>
	        #loginButton {
	            display: none;
	        }
	        .dropdownHeader {
	        display:block;
	        }
	    </style>
	<%
	} else {
	    // Session "customer" chưa tồn tại
	    // Hiển thị button Login
	%>
	    <style>
	        #loginButton {
	            display: block;
	        }
	       	.dropdownHeader {
	        display:none;
	        }
	    </style>
	<%
	}
	%> --%>
    <script src="assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://cdn.reflowhq.com/v2/toolkit.min.js" data-reflow-store="408435610"></script>
    <script src="assets/js/bs-init.js"></script>
    <script src="assets/js/grayscale.js"></script>
    <script src="assets/js/decription-product.js"></script>

</head>
<body>
	<sec:authorize access="!isAuthenticated()">
  <div>aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</div>
</sec:authorize>
<sec:authorize access="hasRole('ADMIN')">
   <div>bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb</div>
</sec:authorize>
<sec:authorize access="hasRole('CUSTOMER')">
    authenticated as <sec:authentication property="principal.customerAccount.password" />  aaabb
</sec:authorize>
	<%@ include file="/common/header.jsp" %>
	<sitemesh:write property='body'></sitemesh:write>
	<%@ include file="/common/footer.jsp" %>

</body>
</html>