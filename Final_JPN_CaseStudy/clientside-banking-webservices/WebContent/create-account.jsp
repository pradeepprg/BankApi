<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Account | ABC Bank Web Services</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>

  <body class="bg-light">
   <header>

      <div class="navbar navbar-dark bg-dark shadow-sm">
        <div class="container d-flex justify-content-between">
          <a href="#" class="navbar-brand d-flex align-items-center">
            <strong>ABC Bank Web Services Interface</strong>
          </a>
        </div>
      </div>
    </header>

    <div class="container">
      <div class="py-5 text-center">
        <h2>Account Creation form</h2>
        <p class="lead">Below is an example form built entirely with Bootstrap's form controls. Each required form group has a validation state that can be triggered by attempting to submit the form without completing it.</p>
      </div>

      <div class="row" id="sidebar">
        <div class="col-md-4 order-md-2 mb-4">
          <h4 class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-muted">Documents Required</span>
            <span class="badge badge-secondary badge-pill">3</span>
          </h4>
          <ul class="list-group mb-3">
            <li class="list-group-item d-flex justify-content-between lh-condensed">
              <div>
                <h6 class="my-0">Document 1</h6>
                <small class="text-muted">Social ID Softcopy.</small>
              </div>
              <span class="text-muted" style="color:darkred">*</span>
            </li>
            <li class="list-group-item d-flex justify-content-between lh-condensed">
              <div>
                <h6 class="my-0">Document 2</h6>
                <small class="text-muted">Confirmation that you are not a member of anti-society forces.</small>
              </div>
              <span class="text-muted" style="color:darkred">*</span>
            </li>
            <li class="list-group-item d-flex justify-content-between lh-condensed">
              <div>
                <h6 class="my-0">Document 3</h6>
                <small class="text-muted">Confirmation that you are not a PEPs of foreign countries. </small>
              </div>
              <span class="text-muted">*</span>
            </li>
          </ul>

          <form class="card p-2">            <div class="input-group">
              
              <div class="input-group-append" style="text-align:center">
                <button type="submit" class="btn btn-secondary">Update Details for existing account.</button>
              </div>
            </div>
          </form>
        </div>
        <div class="col-md-8 order-md-1">
          <h4 class="mb-3">Basic details</h4>
          <form action="http://localhost:8080/serverside-banking-webservices/api/v1/account/create/csystem" method="post" enctype="multipart/form-data" id="fcreate" onsubmit="return submit()">
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="firstName">Social ID</label>
                <input type="text" class="form-control" id="sid"  name="sid" placeholder="" value="" required>
                <div class="invalid-feedback">
                  Valid Social ID is required.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="lastName">Name</label>
                <input type="text" class="form-control" id="name"  name="name" placeholder="" value="" required>
                <div class="invalid-feedback">
                  Valid Name is required.
                </div>
              </div>
            </div>
            <div class="row" style="margin-bottom: 3%;">

              <div class="col-md-12">
                <label for="country">Gender</label>
                <select class="custom-select d-block w-100" id="gender" name="gender" required>
                  <option value="">Choose...</option>
                  <option value="M">Male</option>
                  <option value="F">Female</option>
                  <option value="O">Other</option>
                </select>
                <div class="invalid-feedback">
                  Please select a valid gender.
                </div>
              </div>
              </div>

<div class="row" >
            <div class="mb-3 col-md-6">
              <label for="email">Email </label>
              <input type="email" class="form-control" id="email" placeholder="you@example.com" name="email">
              <div class="invalid-feedback">
                Please enter a valid email address for shipping updates.
              </div>
            </div>
            
            <div class="mb-3 col-md-6">
              <label for="email">Password </label>
              <input type="password" class="form-control" id="email" placeholder="**********" name="password">
              <div class="invalid-feedback">
                Please enter a valid email address for shipping updates.
              </div>
            </div>
            </div>

            <div class="mb-3">
              <label for="address">Address</label>
              <input type="text" class="form-control" name="address" id="address" placeholder="1234 Main St" required>
              <div class="invalid-feedback">
                Please enter your address.
              </div>
            </div>

            <div class="mb-3">
              <label for="address2">Phone Number</label>
              <input type="number" class="form-control" id="phone" name="phone">
            </div>
            

            <div class="row">
              <div class="col-md-7 mb-3">
                <label for="country">Type of Account</label>
                <select class="custom-select d-block w-100" id="accounttype" name="type" required>
                  <option value="">Choose...</option>
                  <option value="S">Savings Acccount</option>
                  <option value="C">Current Acccount</option>
                </select>
                <div class="invalid-feedback">
                  Please select a valid account type.
                </div>
              </div>
              <div class="col-md-5 mb-3">
                 <label for="address2">Date of Birth</label>
              <input type="date" class="form-control" id="date" name="dob">
                <div class="invalid-feedback">
                  Please provide a valid state.
                </div>
              </div>
            </div>
            <hr class="mb-4">
            <div class="custom-control custom-checkbox">
              <input type="checkbox" class="custom-control-input" id="same-address">
              <label class="custom-control-label" for="same-address">I agree to terms and conditions.</label>
            </div>
            <hr class="mb-4">

            <h4 class="mb-3">Documents</h4>
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="cc-name">Social ID Document</label>
                <input type="file"  id="sid" placeholder="" name="sid_doc" required>
                <small class="text-muted">Social ID as displayed on card</small>
                
              </div>
              <div class="col-md-6 mb-3">
                <label for="cc-number">Document 2</label>
                <input type="file"  id="doc1" name="doc1" placeholder="" required>
               <small class="text-muted">Confirmation that you are not a member of anti-society forces.</small>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="cc-expiration">Document 3</label>
                <input type="file" id="doc3"  name="doc2" placeholder="" required>
                <small class="text-muted">
                  Confirmation that you are not a PEPs of foreign countries.
                </small>
            </div>
            </div>
            <hr class="mb-4">
            <a href="login.jsp" class="btn btn-primary btn-lg btn-block" type="submit">Continue to Account Creation</a>
          </form>
        </div>
      </div>
      <div>
      <img id="loader" src="https://i.pinimg.com/originals/5a/ee/31/5aee31bffde4bff4a52cf0867dd85572.gif" style="display:none;">
      </div>

      <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; </p>
        <ul class="list-inline">
          <li class="list-inline-item"><a href="#">Privacy</a></li>
          <li class="list-inline-item"><a href="#">Terms</a></li>
          <li class="list-inline-item"><a href="#">Support</a></li>
        </ul>
      </footer>
    </div>
<script>
function submit(){
	console.log("hello");
	document.getElementById("fcreate").style.display="none";
		document.getElementById("sidebar").style.display="none";
			document.getElementById("loader").style.display="block";
}

</script>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
   <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>
