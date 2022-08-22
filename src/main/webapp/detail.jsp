<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detail</title>
 <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
 <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <link href="style.css" rel="stylesheet" type="text/css"/>
 <style>
     .gallery-wrap .img-big-wrap img {
         height: 450px;
         width: auto;
         display: inline-block;
         cursor: zoom-in;
     }


     .gallery-wrap .img-small-wrap .item-gallery {
         width: 60px;
         height: 60px;
         border: 1px solid #ddd;
         margin: 7px 2px;
         display: inline-block;
         overflow: hidden;
     }

     .gallery-wrap .img-small-wrap {
         text-align: center;
     }
     .gallery-wrap .img-small-wrap img {
         max-width: 100%;
         max-height: 100%;
         object-fit: cover;
         border-radius: 4px;
         cursor: zoom-in;
     }
     .img-big-wrap img{
         width: 100% !important;
         height: auto !important;
     }
 </style>
</head>
<body>
<div id="show-body">
<jsp:include page="header.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                <div class="col-sm-12">
                    <div class="container">
                        <div class="card">
                            <div class="row">
                                <aside class="col-sm-5 border-right">
                                    <article class="gallery-wrap"> 
                                        <div class="img-big-wrap">
                                            <div> <a href="#"><img src="${detail.img}"></a></div>
                                        </div> <!-- slider-product.// -->
                                        <div class="img-small-wrap">
                                        </div> <!-- slider-nav.// -->
                                    </article> <!-- gallery-wrap .end// -->
                                </aside>
                                <aside class="col-sm-7">
                                    <article class="card-body p-5">
                                        <h3 class="title mb-3">${detail.name}</h3>

                                        <p class="price-detail-wrap"> 
                                            <span class="price h3 text-warning"> 
                                                <span class="currency">US $</span><span class="num">${detail.price}</span>
                                            </span> 
                                        </p> <!-- price-detail-wrap .// -->
                                        <dl class="item-property">
                                            <dt>Description</dt>
                                            <dd><p>
                                                    ${detail.des}
                                                </p></dd>
                                        </dl>

                                        <hr>
                                        <div class="row">
                                            <div class="col-sm-5">
                                                <dl class="param param-inline">
                                                    <dt>Quantity: </dt>
                                                    <dd>
                                                        <select class="form-control form-control-sm" style="width:70px;">
                                                            <option> 1 </option>
                                                            <option> 2 </option>
                                                            <option> 3 </option>
                                                        </select>
                                                    </dd>
                                                </dl>  <!-- item-property .// -->
                                            </div> <!-- col.// -->

                                        </div> <!-- row.// -->
                                        <hr>
                                        <button class="btn btn-lg btn-primary text-uppercase" onclick="getCart()"> Buy now </button>
                                        <button class="btn btn-lg btn-outline-primary text-uppercase" onclick="getMobile(${detail.id})"> <i class="fas fa-shopping-cart"></i> Add to cart </button>
                                    </article> <!-- card-body.// -->
                                </aside> <!-- col.// -->
                            </div> <!-- row.// -->
                        </div> <!-- card.// -->
                    </div>
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