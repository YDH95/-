<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>freshbsSlider.jsp</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css"> 
<script src="http://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script> 
<script>
import portion from module;
</script>
<script>
	$(document).ready(function() {
		$('.slider').bxSlider({ //
			auto: true, //자동으로 작동하는게 참이다
			speed: 1000, //1초만에 페이지 넘김
			pause: 2500, //2.5동안 화면 멈춤
			mode: 'fade', //수평 스크롤 방식을 사용할것이다
			pager: true, //페이지 양옆 방향버튼을 보이게 할것인가
			autoHover: true //마우스를 올리면 멈추게 하기
		});
	});
</script>
</head>
<body>
	<div class="title">
		<nav id="header">
			<div class="header_menu">
				<ul class="header_menu">
					<li class="header_menu_item"><a href="login.jsp">로그인</a></li>
					<li class="header_menu_item1"><a href="regist.jsp">회원가입</a></li>
					<li class="header_menu_item2"><a>고객센터</a></li>
				</ul>
			</div>
		</nav>
		
		<div class="logo_search">
			<div class="header_logo">
				<a href="/main"> <img src="images/logo.png" class="logo"> </a>
			</div>
		</div>
	</div>
	
	<div class="menu">
		<div class="navbar">
			<div class="navbar_menu">
				<ul class="navbar_menu_ul">
					<li><a href="/main"> 
						<img src="images/ham.png" class="ham"> 전체상품</a>
						<ul>
							<li><a> 채소 </a>
								<ul>
									<li><a href="/shop/list?c=11&l=10"> 채소 </a></li>
								</ul>
							</li>
							<li><a> 과일·견과·쌀 </a>
								<ul>
									<li><a href="/shop/list?c=21&l=20"> 제철과일 </a></li>
									<li><a href="/shop/list?c=22&l=20"> 과일 </a></li>
									<li><a href="/shop/list?c=23&l=20"> 견과류 </a></li>
									<li><a href="/shop/list?c=24&l=20"> 쌀·잡곡 </a></li>
								</ul>
							</li>
							<li><a> 수산·건어물 </a>
								<ul>
									<li><a href="/shop/list?c=31&l=30"> 제철수산 </a></li>
									<li><a href="/shop/list?c=32&l=30"> 생선류 </a></li>
									<li><a href="/shop/list?c=33&l=30"> 갑각류 </a></li>
									<li><a href="/shop/list?c=34&l=30"> 연체류 </a></li>
									<li><a href="/shop/list?c=35&l=30"> 조개류 </a></li>
									<li><a href="/shop/list?c=36&l=30"> 건어물 </a></li>
								</ul></li>
							<li><a> 정육·계란 </a>
								<ul>
									<li><a href="/shop/list?c=41&l=40"> 소고기 </a></li>
									<li><a href="/shop/list?c=42&l=40"> 돼지고기 </a></li>
									<li><a href="/shop/list?c=43&l=40"> 닭·오리 </a></li>
									<li><a href="/shop/list?c=44&l=40"> 계란류 </a></li>
								</ul>
							</li>
						</ul></li>
					<li> <a href="/shop/list?c=11&l=10"> 농산물 </a> </li>
                    <li> <a href="/shop/list?c=35&l=30"> 수산물 </a> </li>
                    <li> <a href="/shop/list?c=41&l=40"> 축산물 </a> </li>
                    <li> <a href="#benefit_item"> 알뜰쇼핑 </a> </li>
				</ul>
				<div class="search">
					<input type="text" name="keyword" class="search_text"
						placeholder="신선한 바른먹거리" value="${pageMaker.cri.keyword}">
					<input type="image" src="images/search.png"
						class="btn_search">
				</div>
			</div>
		</div>
	</div>

	<div class="slider">
		<div><a href="#"><img src="images/main_banner_1.jpg"></a></div>
		<div><a href="#"><img src="images/main_banner_2.jpg"></a></div>
		<div><a href="#"><img src="images/main_banner_3.gif"></a></div>
		<div><a href="#"><img src="images/main_banner_4.gif"></a></div>
		<div><a href="#"><img src="images/main_banner_5.gif"></a></div>
		<div><a href="#"><img src="images/main_banner_6.gif"></a></div>
		<div><a href="#"><img src="images/main_banner_7.jpg"></a></div>
		<div><a href="#"><img src="images/main_banner_8.gif"></a></div>
	</div>
</body>
</html>
