<%@page import="com.tcs.ilp.bean.UserDetails" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Top navbar example for Bootstrap</title>

    <!-- Bootstrap core CSS -->
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="navbar-top.css" rel="stylesheet">
  </head>

  <body>

    <nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
      <a class="navbar-brand" href="#">ABC Bank Web Services Interface</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div style="margin-left: 60%;" >
      <a class="btn btn-outline-success my-2 my-sm-0 float-right" href="<%=request.getContextPath() %>/account?action=logout">Logout</a>
      </div>
    </nav>

     <div class="container" style="padding-bottom: 5%;">
      <div class="py-5 text-center">
        <h2>Account Updation form</h2>
        <p class="lead">Below is an example form built entirely with Bootstrap's form controls. Each required form group has a validation state that can be triggered by attempting to submit the form without completing it.</p>
      </div>

      <div class="row" id="sidebar">
<% UserDetails ud = (UserDetails)request.getAttribute("user");  %>
        <div class="col-md-12 order-md-1">
          <h4 class="mb-3">Update Basic details</h4>
          
          <form action="<%=request.getContextPath()%>/account" method="post" id="fcreate">
            <div class="row">
              <div class="col-md-12 mb-3">
                <label for="firstName">Phone No</label>
                <input type="text" class="form-control" id="phone"   placeholder="" value="<%=ud.getPhone() %>" readonly>

              </div>
              </div>
              <div class="row">
              <div class="col-md-12 mb-3">
                <label for="lastName">Name</label>
                <input type="text" class="form-control" id="name"   placeholder="" value="<%=ud.getName() %>" readonly>
              
              </div>
            </div>
             <div class="row">
             <div class="col-md-12 mb-3">
                <label for="lastName">Account No</label>
                <input type="text" class="form-control" id="accNo"  name="accNo" placeholder="" value="<%=ud.getAccno() %>" readonly>
          
              </div>
            </div>
            <div class="row">
            <div class="col-md-12 mb-3">
              <label for="address">Address</label>
              <input type="text" class="form-control" name="addr" id="addr" placeholder="1234 Main St" value="<%=ud.getAddress() %>" required>
              <div class="invalid-feedback">
                Please enter your address.
              </div>
            </div>
            </div>
            <hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" type="submit" name="action" value="update">Change Address</button>
          </form>
        </div>
      </div>
      <div>

      </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

  </body>
</html>
