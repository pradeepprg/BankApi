<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ABC Bank Web Services Interface</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="content">
 <header>

      <div class="navbar navbar-dark bg-dark shadow-sm">
        <div class="container d-flex justify-content-between">
          <a href="#" class="navbar-brand d-flex align-items-center">
            <strong>ABC Bank Web Services Interface</strong>
          </a>
        </div>
      </div>
    </header>

    <main role="main">

      <section class="jumbotron text-center">
        <div class="container">
          <h1 class="jumbotron-heading">ABC Bank Web Services Interface</h1>
          <p class="lead text-muted">ABC Bank is a leading bank in Japan. The bank offers many financial products to its customers. Retail banking is its major revenue area for the bank.</p>
          <p>
          
            <a href="create-account.jsp" class="btn btn-primary my-2" >Create Account</a>
            
            <%
            
            if(session.getAttribute("sid") != null) {
            if(session.getAttribute("sid").equals("0")) {%>
            <a href="login.jsp" class="btn btn-secondary my-2">Change Details for existing account</a>
            <%}else{%>
            <a href="<%=request.getContextPath()%>/account?action=getDetails" class="btn btn-secondary my-2">Update your Details</a>
            
            <%}} else{%>
           <a href="login.jsp" class="btn btn-secondary my-2">Change Details for existing account</a>
            
            <%}%>

          </p>
        </div>
      </section>

      <div class="album py-5 bg-light">
        <div class="container" style=" text-align:center;">
            </div>
          </div>
        </div>
      </div>

    </main>


</div>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>