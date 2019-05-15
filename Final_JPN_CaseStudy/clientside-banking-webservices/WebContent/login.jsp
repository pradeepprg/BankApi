
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Login | ABC Bank Web Services</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.1/examples/sign-in/signin.css" rel="stylesheet">
  </head>

  <body class="text-center">
    <form class="form-signin" action="<%=request.getContextPath() %>/account" method="post">
     <h2 style="color:#563d7c; font-weight:bold; padding-bottom:2%">ABC BANK.</h2><hr>
      <h4 class="h3 mb-3 font-weight-normal">Please sign in</h4>
      <%
      if(session.getAttribute("sid") != null){
    	  if(!session.getAttribute("sid").equals("0")){
    	    	  	response.sendRedirect(request.getContextPath()+"/account?action=getDetails");
        	  }
    	  }
    	  %>
    		  <%
    		  if(request.getAttribute("error") != null){ %>
    		  <div class="alert alert-danger" role="alert">
  <strong>Oh snap! &nbsp;</strong><%=request.getAttribute("error") %>.
</div>
    	      <%} %>
    	
      
      <label for="inputEmail" class="sr-only">Phone Number</label>
      <input type="number" id="inputEmail" class="form-control" name="phone" placeholder="Phone number" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit" name="action" value="login">Sign in</button>
      <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>
  </body>
</html>
