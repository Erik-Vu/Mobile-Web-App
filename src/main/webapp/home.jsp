<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>My project</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div id="show-body">
	<jsp:include page="header.jsp"></jsp:include>
	<div id="slideshow">
    <div class="slide-wrapper">
        <div class="slide"><img src="image/slider-1.png" alt="slider-1"></div>
        <div class="slide"><img src="image/slider-2.png" alt="slider-2"></div>
        <div class="slide"><img src="image/slider-3.png" alt="slider-3"></div>
    </div>
	</div>
    <div class="center" id="center">
          <div class="col-sm-9 leftcolumn">
                     <div id="content" class="row">
                     <c:forEach items="${listP}" var="o">
                         <div class="product col-12 col-md-6 col-lg-4">
                             <div class="card">
                                 <img class="card-img-top" src="${o.img}" alt="Card image cap">
                                 <div class="card-body">
                                     <h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4>
                                     <p class="card-text show_txt">${o.type}</p>
                                     <div class="row">
                                         <div class="col">
                                             <p class="btn btn-danger btn-block btn-lg">${o.price}</p>
                                         </div>
                                         <div class="col">
                                             <button onclick="getMobile(${o.id})" class="btn btn-success btn-block btn-lg">Add to cart</button>
                                         </div>
                                     </div>
                                 </div>
                             </div>
                         </div>
                     </c:forEach>
                 </div>
                 <button onclick="loadPage(1)" class="btn btn-primary">Page 1</button>
                 <button onclick="loadPage(2)" class="btn btn-primary">Page 2</button>
             </div>
        <div class="col-sm-9 rightcolumn">
            <div class="right-card">
                <h1>Leader Mobile</h1>
                <div class="img">
                    <img src="" alt="">
                </div>
                <h2>The best seller in Viet Nam</h2>
            </div>
            <div class="card card-banner">
                <a href="#"><img class="card-img-top" src="image/banner-1.png" alt=""></a>
            </div>
            <div class="card card-banner">
                <a href="#"><img class="card-img-top" src="image/banner-2.png" alt=""></a>
            </div>
            <div class="card card-banner">
                <a href="#"><img class="card-img-top" src="image/banner-3.png" alt=""></a>
            </div>
    	</div>
    </div>
    </div>
    <jsp:include page="login.jsp"></jsp:include>
    <jsp:include page="register.jsp"></jsp:include>
    <jsp:include page="footer.jsp"></jsp:include>
    <script src="script.js"></script>
</body>
</html>