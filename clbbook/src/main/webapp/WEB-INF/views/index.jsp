<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Login to club Book</title>
<jsp:include page="header.jsp" />

</head>
<body id="body-login">
	<div id=body-flex-login>
		<div id="container-login">
			<div id="container-login-left">
				<div id="header-left">
					<span>Welcom to Book Club</span><br /> <span>Hãy mở mang
						kiến thức cùng tôi !</span>
				</div>
			</div>
			<div id="container-login-right">
				<div id="header-top-right">
					<span><p>Login</p></span>

				</div>
				<div id="header-bot-right">
					<p style="color: red; font-size: 14px; font-weight: bold;">${fail}</p>
					<br />
					<form action="/clbbook/dangnhap/" name="flogin"
						onsubmit="return(checkform());" method="POST">
						<input id="material-input" type="text" name="username"
							placeholder="Email" />
						<p id="err" style="color: red; font-style: italic;"></p>
						</br> <input id="material-input" type="password" name="password"
							placeholder="Password" />
						<p id="err1" style="color: red; font-style: italic;"></p>
						</br> <input id="material" type="submit" name="submit" value="Đồng ý">
					</form>
				</div>
				<div id="footer">
					<a href="dangky/"> Register</a>
					<button class="btn btn-primary">Facebook</button>
					<button class="btn btn-danger">Google+</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
       function checkform(){
    	  if(document.flogin.username.value==""){
    		 document.getElementById("err").innerHTML="(*)username not null";
               document.flogin.username.focus( );

               return false;
    	  }
    	  if(document.flogin.password.value==""){
     		 document.getElementById("err1").innerHTML="(*)password not null";
                document.flogin.password.focus( );

                return false;
     	  }
       }
      </script>

</body>
</html>