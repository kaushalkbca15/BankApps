<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row" style="height:300px;">
			<div class="col-sm-12" ></div>
		</div>
		<div class="row">
			<div class="col-sm-3" ></div>
			<div class="col-sm-6" >
				<div class="row" style="background-color:lightblue; padding:70px;">
					<form action="login" method="post">
						<div class="col-sm-12" >
							<div>${response}</div>
							<div style=" margin-top:12px;"><input class="form-control input-lg" id="userName"  type="text" name="userName" placeholder="Enter username"></div>
							<div style=" margin-top:12px;"><input class="form-control input-lg" id="pwd"  type="password" name="password" placeholder="Enter password"></div>
							<div align="center" style=" margin-top:12px;"><button  class="btn btn-success btn-lg btn-block">login</button></div>
						</div>
						<div>
							 <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
						</div>
					</form>
				</div>		
			</div>
			<div class="col-sm-3" ></div>
		</div>
		<div class="row">
			<div class="col-sm-12" ></div>
		</div>
	</div>
</body>
</html>