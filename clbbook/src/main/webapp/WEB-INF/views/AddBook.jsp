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
			<div id="container-login-right1">
				<div id="header-top-right">
					<span><p>ADD BOOK</p></span>
					

				</div>
				<div id="header-bot-right">
					<p style="color: green; font-size: 20px; font-style: italic; "> ${success}</p>
					<br />
					<form action="/clbbook/dangnhap/addbook/" name="flogin"
						onsubmit="return(checkform());" method="POST">
						<input id="material-input" type="text" name="bookName"
							placeholder="(*) BookName" />
						<p id="err" style="color: red; font-style: italic;"></p>
						</br> <input id="material-input" type="text" name="introdue"
							placeholder="(*) Introdue" />
						<p id="err1" style="color: red; font-style: italic;"></p>
						</br> <input id="material-input" type="text" name="content"
							placeholder="(*) Content" />
						<p id="err2" style="color: red; font-style: italic;"></p>
						</br> <input id="material-input" type="text" name="username"
							placeholder="Username" />
						<p id="err3" style="color: red; font-style: italic;"></p>
						</br> <input id="material-input" type="file" name="img"
							placeholder="(*) Images" />
						<p id="err4" style="color: red; font-style: italic;"></p>
						</br> <input id="material" type="submit" name="submit" value="Submit">
					</form>
					<a href="/clbbook/dangnhap/">quayve</a>
				</div>

			</div>
		</div>
	</div>
	<script type="text/javascript">
       function checkform(){
    	  if(document.flogin.bookName.value==""){
    		 document.getElementById("err").innerHTML="(*)Book name not null";
               document.flogin.bookName.focus( );

               return false;
    	  }
    	  if(document.flogin.introdue.value==""){
     		 document.getElementById("err1").innerHTML="(*)Introdue not null";
                document.flogin.introdue.focus( );

                return false;
     	  }
    	  if(document.flogin.content.value==""){
      		 document.getElementById("err2").innerHTML="(*)Content not null";
                 document.flogin.content.focus( );

                 return false;
      	  }
    	  if(document.flogin.img.value==""){
       		 document.getElementById("err4").innerHTML="(*)Images not null";
                  document.flogin.img.focus( );

                  return false;
       	  }
       }
      </script>

</body>
</html>