<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <link rel="shortcut icon" href="images/favicon.png" type="">

 

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!--owl slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />
  <!-- nice select  -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha512-CruCP+TD3yXzlvvijET8wV5WxxEh5H8P4cmz0RFbKK6FlZ2sYl3AEsKlLPHbniXKSrDdFewhbmBK5skbdsASbQ==" crossorigin="anonymous" />
  <!-- font awesome style -->
  <link href="css/font-awesome.min.css" rel="stylesheet" />

  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />

</head>

<body class="sub_page">


  

  <!-- food section -->

  <section class="food_section layout_padding">
    <div class="container">
      <div class="heading_container heading_center">
        <h2>
          Products List
        </h2>
      </div>

		<ul class="filters_menu">
			<li class="active" data-filter="*">전체리스트</li>
			<li data-filter=".loasting">원두</li>
			<li data-filter=".greenbeans">생두</li>
			<li data-filter=".gift">선물세트</li>
			<li data-filter=".brewing">추출도구</li>

			<!-- 상품등록 관리자 권한 부여하기 -->
			<li><a href="productForm.do">상품등록</a></li>
		</ul>


	<div class="filters-content">
        <div class="row grid">
          
          
          
          <div class="col-sm-6 col-lg-4 all loasting">
          
          
          
            <div class="box">
              <div>
                <div class="img-box">
                  <img src="images/yirgacheffe.jpg" alt="">
                </div>
                <div class="detail-box">
                  <h5>
                    ${product.pName}
                  </h5>
                  <p>
                    ${product.pContent}
                  </p>
                  <div class="options">
                    <h6>
                      ${product.price}
                    </h6>
                    <a href="">
                      <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 456.029 456.029" style="enable-background:new 0 0 456.029 456.029;" xml:space="preserve">
                        
                      </svg>
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
          
          
          
          
          <div class="col-sm-6 col-lg-4 all greenbeans">
            <div class="box">
              <div>
                <div class="img-box">
                  <img src="images/f2.png" alt="">
                </div>
                <div class="detail-box">
                  <h5>
                    Delicious Burger
                  </h5>
                  <p>
                    Veniam debitis quaerat officiis quasi cupiditate quo, quisquam velit, magnam voluptatem repellendus sed eaque
                  </p>
                  <div class="options">
                    <h6>
                      $15
                    </h6>
                    <a href="">
                      <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 456.029 456.029" style="enable-background:new 0 0 456.029 456.029;" xml:space="preserve">
                        
                      </svg>
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
          
          
          
          
          <div class="col-sm-6 col-lg-4 all gift">
            <div class="box">
              <div>
                <div class="img-box">
                  <img src="images/f3.png" alt="">
                </div>
                <div class="detail-box">
                  <h5>
                    Delicious Pizza
                  </h5>
                  <p>
                    Veniam debitis quaerat officiis quasi cupiditate quo, quisquam velit, magnam voluptatem repellendus sed eaque
                  </p>
                  <div class="options">
                    <h6>
                      $17
                    </h6>
                    <a href="">
                      <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 456.029 456.029" style="enable-background:new 0 0 456.029 456.029;" xml:space="preserve">
                                      
                        
                      </svg>
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
          
          
          
          
          <div class="col-sm-6 col-lg-4 all brewing">
            <div class="box">
              <div>
                <div class="img-box">
                  <img src="images/f4.png" alt="">
                </div>
                <div class="detail-box">
                  <h5>
                    종이필터
                  </h5>
                  <p>
                    Veniam debitis quaerat officiis quasi cupiditate quo, quisquam velit, magnam voluptatem repellendus sed eaque
                  </p>
                  <div class="options">
                    <h6>
                      $18
                    </h6>
                    <a href="">
                      <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 456.029 456.029" style="enable-background:new 0 0 456.029 456.029;" xml:space="preserve">
                    
                      </svg>
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
          
          
          
          
          
          
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

</html>