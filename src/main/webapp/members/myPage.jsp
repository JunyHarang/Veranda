<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	mypage입니다.
	 <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Blog Hero Begin -->
    <div class="blog-hero set-bg" data-setbg="img/blog/details/blog-hero.jpg">
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="col-lg-7">
                    <div class="blog__hero__text">
                        <div class="label">Recipes</div>
                        <h2>Cooking Cajun Food</h2>
                        <ul>
                            <li>By <span>James Myers</span></li>
                            <li>13 Nov 2020</li>
                            <li>112 Views</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Blog Hero End -->

    <!-- Blog Details Section Begin -->
    <section class="blog-details spad">
        <div class="container">
            <div class="row d-flex justify-content-center">
                <div class="col-lg-8">
                    <div class="blog__details__content">
                        <div class="blog__details__author">
                            <div class="blog__details__author__pic">
                                <img src="img/blog/details/blog-author.jpg" alt="">
                            </div>
                            <div class="blog__details__author__text">
                                <h6>Mitchell Holland</h6>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor
                                incididunt ut labore et dolore magna aliqua.</p>
                            </div>
                            <a href="#" class="primary-btn">Leave a comment</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Blog Details Section End -->

</body>
</html>
<%@ include file="./../common/footer.jsp"%>