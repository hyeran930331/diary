<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Grayscale Diary</title>
        <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    
	<body id="page-top">
	       

        <!-- Masthead-->
        <!-- 로그인 성공 -->
		<c:if test="${sessionMember != null }">
		 <!-- Navigation-->
	        <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
	            <div class="container">
	                <a class="navbar-brand js-scroll-trigger" href="#page-top">Grayscale Diary</a>
	                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	                    Menu
	                    <i class="fas fa-bars"></i>
	                </button>
	                <div class="collapse navbar-collapse" id="navbarResponsive">
	                    <ul class="navbar-nav ml-auto">
	                    	<li class="nav-item"> <a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/auth/diary">Diary</a> </li>
	                    </ul>
	                </div>
	            </div>
	        </nav>
		
        <header class="masthead">
            <div class="container d-flex h-100 align-items-center">
                <div class="mx-auto text-center">
                	<div class="col-lg-7 text-center">
                    <h1 class="mx-auto my-0">${ fn:split(sessionMember.memberId,'@')[0] }</h1>
                    </div>
                    <br>
                    <a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/auth/logout">로그아웃</a>
                    <a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/auth/modifyMember">정보수정</a>
                    <a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/auth/removeMember">회원탈퇴</a>
                </div>
            </div>
        </header>
        </c:if>
        
        <!-- 로그인 실페 -->
		<c:if test="${sessionMember == null }">
        <header class="masthead">
            <div class="container d-flex h-100 align-items-center">
                <div class="mx-auto text-center">
                    <h1 class="mx-auto my-0">Do</h1>
                    <br>
                    <br>
                    <h4><a class="nav-link js-scroll-trigger"href="#signup">Login</a></h4>
                    <h4><a class="nav-link js-scroll-trigger" href="${pageContext.request.contextPath}/addMember">Join</a></h4>
                </div>
            </div>
        </header>
        </c:if>
                
        <!-- About-->
        <section class="about-section text-center" id="about">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 mx-auto">
                        <h2 class="text-white mb-4"></h2>
                        <p class="text-white-50">
                        </p>
                    </div>
                </div>
            </div>
        </section>

        
         <!-- fail-->
        <section class="projects-section bg-light" id="fail">
            <div class="container">
                <!-- Featured Project Row-->
                <div class="row align-items-center no-gutters mb-4 mb-lg-5">
                    <div class="col-xl-8 col-lg-7"> </div>
                    <div class="col-xl-4 col-lg-5">
                        <div class="text-center">
                            <h4>로그인 실패</h4>
                            <p class="text-black-50 mb-0"></p>
                        </div>
                    </div>
                </div>       
            </div>
        </section>
                                      
        <!-- Signup-->
        <section class="signup-section" >
        	<div class="container">
                <!-- Featured Project Row-->
                <div class="row align-items-center no-gutters mb-4 mb-lg-5">
                    <div class="col-xl-8 col-lg-7"> </div>
                    <div class="col-xl-4 col-lg-5">
                        <div class="featured-text text-center text-lg-left">
                            <h4>&nbsp;</h4>
                            <p class="text-black-50 mb-0">&nbsp;</p>
                        </div>
                    </div>
                </div>       
            </div>
			
       
        
        <section id="signup">
            <div class="container">
                <div class="row">
                    <div class="col-md-10 col-lg-8 mx-auto text-center">
                       
                        <form action="${pageContext.request.contextPath}/login" method="post">
                        	<div>
                        	<span class="nav-link js-scroll-trigger" ></span><button class="btn btn-primary mx-auto" type="submit">로그인</button>
							</div>
							<br>
							<div class="form-inline">
							 	ID : &nbsp; <input class="form-control flex-fill mr-0 mr-sm-2 mb-3 mb-sm-2" type="text" name="memberId" value="mentorrani0331@gmail.com"> 
							</div>
							<div class="form-inline">
								PW : <input class="form-control flex-fill mr-0 mr-sm-2 mb-3 mb-sm-2" type="password" name="memberPw" value="1234">
							</div>
								
						</form>
                      
                    </div>
                </div>
            </div>
        </section>
        </section>
        
        <!-- Contact-->
        <section class="contact-section bg-black">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 mb-3 mb-md-0">
                        <div class="card py-4 h-100">
                            <div class="card-body text-center">
                                <i class="fas fa-map-marked-alt text-primary mb-2"></i>
                                <h4 class="text-uppercase m-0">Address</h4>
                                <hr class="my-4" />
                                <div class="small text-black-50">Geumchen-Gu, Seoul</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 mb-3 mb-md-0">
                        <div class="card py-4 h-100">
                            <div class="card-body text-center">
                                <i class="fas fa-envelope text-primary mb-2"></i>
                                <h4 class="text-uppercase m-0">Email</h4>
                                <hr class="my-4" />
                                <div class="small text-black-50">mentorrani033@gmail.com</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 mb-3 mb-md-0">
                        <div class="card py-4 h-100">
                            <div class="card-body text-center">
                                <i class="fas fa-mobile-alt text-primary mb-2"></i>
                                <h4 class="text-uppercase m-0">Phone</h4>
                                <hr class="my-4" />
                                <div class="small text-black-50">+82 010 - 3394 - 6562</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
        <!-- Footer-->
        <footer class="footer bg-black small text-center text-white-50"><div class="container">Copyright © Your Website 2020</div></footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>            