<%--
  Created by IntelliJ IDEA.
  User: RAC
  Date: 4/11/2020
  Time: 1:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="include/styles.jsp"%>
    
</head>
<body>
<%@include file="include/header.jsp"%>

<!-- ======= Hero Section ======= -->
<section id="hero" class="d-flex flex-column justify-content-center align-items-center">
    <div class="container text-center text-md-left" data-aos="fade-up">
        <h1>Welcome to Udawalawe National Park</h1>
        <h2>The popular tourist destination and the third most visited park in Sri Lanka</h2>
        <a href="#about" class="btn-get-started scrollto">Discover</a>
    </div>


</section><!-- End Hero -->

<!-- ======= About Section ======= -->
<section id="about" class="about">
    <div class="container">

        <div class="row">
            <div class="col-xl-6 col-lg-7" data-aos="fade-right">
                <img src="assets/img/Founder.jpg" class="img-fluid" alt="">
            </div>
            <div class="col-xl-6 col-lg-5 pt-5 pt-lg-0">
                <h3 data-aos="fade-up">Massage from the Chairman</h3>
                <h4 data-aos="fade-up">Sunimal Tissera</h4>
                <p data-aos="fade-up">
                    Chairman naturalist and former wildlife warden
                </p>
                <div class="icon-box" data-aos="fade-up">
                    <i class="bx bx-receipt"></i>
                    <h4>Vision</h4>
                    <p>The Udawalawe National Park website belongs to the Info Sri Lanka group of Websites</p>
                </div>

                <div class="icon-box" data-aos="fade-up" data-aos-delay="100">
                    <i class="bx bx-cube-alt"></i>
                    <h4>Mission</h4>
                    <p>Sri Lanka largest tourists web site</p>
                </div>

                <div class="icon-box" data-aos="fade-up" data-aos-delay="200">
                    <i class="bx bx-cube-alt"></i>
                    <h4>Cooparative Office</h4>
                    <p>3B, 1/4, Havelock Road, Colombo 5</p>
                </div>

            </div>
        </div>

    </div>
</section><!-- End About Section -->


<%@include file="include/footer.jsp"%>
<%@include file="include/scripts.jsp"%>
</body>
</html>
