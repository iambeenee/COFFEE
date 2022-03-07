<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- food section -->
<body class="sub_page">

 <section class="food_section layout_padding">
  <div class="container">
    <div class="heading_container heading_center">
      <h2>
        Products List
      </h2>
     </div>

    <ul class="filters_menu">
      <li class="active" data-filter="*">전체리스트</li>
      <li data-filter=".a">원두</li>
      <li data-filter=".b">드립백</li>
      <li data-filter=".c">선물세트</li>
      <li data-filter=".d">추출도구</li>

      <!-- 상품등록 관리자 권한 부여하기 -->
      <c:if test="${id eq 'admin_h'}">
        <li><a href="productForm.do">상품등록</a></li>
      </c:if>
    </ul>


    <div class="filters-content">
      <div class="row grid">


<c:forEach items="${products }" var="product">
        <div class="col-sm-6 col-lg-4 all ${product.kind }">
          <div class="box">
            <div>
              <div class="img-box">
                <a href="/product/productDetail/${product.pno }">
                <img src="images/${product.image }"></a>
              </div>
              <div class="detail-box">
                <h5>
                  ${product.pname}
                </h5>
                <p style="height:50px">
                  ${product.pcontent}
                </p>
                <div class="options">
                  <h6>
                    <fmt:formatNumber value="${product.price}" pattern="###,###,###"/>원
                  </h6>
                  <a href="">
               
                    
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div> 
</c:forEach>


        






      </div>
    </div>

    <div class="btn-box">
      <a href="">
        View More
      </a>
    </div>


 
</div>
</section> 
</body>