<%@page import="com.nguyenthanhbinh.entity.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="header.jsp" />

</head>
<body>
<sticknav>
<div class="wrapper-nav">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">CLB BOOK</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Information Personal<span
							class="sr-only">(current)</span></a></li>
					<li><a href="#title-sanpham">MYBOOK</a></li>
					<li><a href="#">ALL BOOK</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a></li>
				</ul>
				<form class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Search</button>
				</form>
				<ul class="nav navbar-nav navbar-right">

					<li><a class="active" href=""><p
								style="color: green; font-size: 14px; font-weight: bold;">Xin
								chào ${kiemtra.getFullname()}!</p></a></li>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</div>
</sticknav>
	<div class="container"
		style="color: white; font-size: 20px; font-weight: bold; margin-top: 50px;">
		<h2>Information Personal</h2>
		<table class="table" style="text-align: center;">
			<thead>
				<tr>
					<th style="text-align: center;">Fullname</th>
					<th style="text-align: center;">Address</th>
					<th style="text-align: center;">Phone</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${kiemtra.getFullname() }</td>
					<td>${kiemtra.getAddress() }</td>
					<td>${kiemtra.getPhone()}</td>
				</tr>
				<button style="float: right; font-weight: bold;" type="button"
					class="btn btn-success">Update Information</button>

			</tbody>
		</table>
	</div>
	<div id="title-sanpham">
		<span>MYBOOK</span>
		<div style="margin-bottom: 10px;"><a href="addbook/" class="btn btn-success">Add new book</a>
		</div>
		<div class="row">
		
	<%
		List<Book> list= (List<Book>) request.getAttribute("listbook");
		for(Book b : list){
	%>
		<h2 style="color: white"></h2>
			<div class="col-md-3">
				<div class="sanpham">
					<img class="card-img-top" alt="hinh"
						src="../resource/img/<%= b.getImg() %>"/>
					<div class="card-body">
						<h3 class="card-text" style="color:green;font-weight: bold;"><%= b.getBookname() %></h3>
						<h4 class="card-text" style="color:#666;"><%= b.getIntrodue() %></h4>
						<a href="delete/<%=b.getID() %>/" class="btn btn-danger">Delete</a>
						<a href="#" class="btn btn-primary">Update</a>
					</div>
				</div>

			</div>
	<%} %>
	

		
	

		</div>
	</div>
	<div id="title-sanpham">
		<span>ALL BOOK</span>
		<div class="row">
	<%
		List<Book> allbook= (List<Book>) request.getAttribute("allbook");
		for(Book b : allbook){
	%>
		<h2 style="color: white"></h2>
			<div class="col-md-3">
				<div class="sanpham">
					<img class="card-img-top" alt="hinh"
						src="../resource/img/<%= b.getImg() %>"/>
					<div class="card-body">
						<h3 class="card-text" style="color:green; font-weight: bold;"><%= b.getBookname() %></h3>
						<h4 class="card-text" style="color:#666;"><%= b.getIntrodue() %></h4>
						<a href="#" class="btn btn-primary">Change</a>
					</div>
				</div>

			</div>
	<%} %>
	

		
	

		</div>
	</div>
	<script type="text/javascript">
$(document).ready(function() {
var aboveHeight = $('menu').outerHeight();
    $(window).scroll(function(){
        if ($(window).scrollTop() > aboveHeight){
        $('sticknav').addClass('fixed').css('top','0').next().css('padding-top','60px');
        } else {
       $('sticknav').removeClass('fixed').next().css('padding-top','0');
        }
    });
});
jQuery(document).ready(function($) {
	  $(window).load(function() {
	   if ($('.wrapper-nav').length > 0) {
	     var _top = $('.wrapper-nav').offset().top - parseFloat($('.wrapper-nav').css('marginTop').replace(/auto/, 0));
	      $(window).scroll(function(evt) {
	       var _y = $(this).scrollTop();
	       if (_y > _top) {
	       $('.wrapper-nav').addClass('fixed');
	       $('.main-1').css("margin-top", "30px")
	       } else {
	       $('.wrapper-nav').removeClass('fixed');
	       $('.main-1').css("margin-top", "0")
	     }
	    })
	   }
	  });
	 });
</script>
</body>
</html>