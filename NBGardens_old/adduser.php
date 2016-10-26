<?php

/*** begin our session ***/
session_start();

/*** set a form token ***/
$form_token = md5( uniqid('auth', true) );

/*** set the session form token ***/
$_SESSION['form_token'] = $form_token;
?>


<!DOCTYPE html>
<html lang="en">
<head>
  <title>NB Gardens</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Indie+Flower" rel="stylesheet">
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<body class="w3-container">
  <!--My custom stylesheet & JS-->
  <link rel="stylesheet" href="style.css">
    <script src="script.js"></script>
	<link rel="icon" href="images/gnomeicon.ico" type="image/x-icon"/>
	<link rel="shortcut icon" href="images/gnomeicon.ico" type="image/x-icon"/>
    </head>
  <link rel="shortcut icon" href="images/gnomeicon.ico">
<body>
    <div class="container-fluid">

    <?php include "navbar.php"; ?>
                

  
        <div class="row"><!--Section 1-->
            <div class="col-sm-2"></div>
            <!--Left half of page-->
            <div class="col-xs-12 col-sm-8" id="">
                <br>
                <img src="images/Title-banner.png" alt="Title" id="title-logo">
                <form class="navbar-form" role="search" id="searchbar">
                    <div class="input-group add-on">
                      <input class="form-control" placeholder="Search" name="srch-term" id="srch-term" type="text">
                      <div class="input-group-btn">
                        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                      </div>
                    </div>
                </form>
                
                <img src="images/gardenDesign.jpg" alt="Garden" id="banner-logo">
                <br>
              
                <div>
                 <div class="progress">
  <div class="progress-bar progress-bar-success" role="progressbar" value="33" id="progressBar" aria-valuemin="0" aria-valuemax="100" style="width:33%">
    Step 1 of 3
  </div>
</div>

                <form id="userdetails-form" class="form-inline" action="adduser_submit.php" method="post">
                   <fieldset>
                    <select id="gender" name="gender" class="form-control">
                        <option value="disabled" selected disabled>Gender</option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                        <option value="pnts">Prefer not to say</option>
                    </select>
                    
                    <input type="text" id="firstname" name="firstname" placeholder="First Name" class="form-control field"><br>
                    <input type="text" id="surname" name="surname" placeholder="Surname" class="form-control field"><br>
                   <input type="text" id="phpro_email" name="phpro_email" value="" maxlength="40" placeholder="Email Address" />
                   <input type="password" id="phpro_password" name="phpro_password" value="" maxlength="20" placeholder="Password" />
                   
                       <p>
                            <input type="hidden" name="form_token" value="<?php echo $form_token; ?>" />
                            <input type="submit" value="Next" class="btn btn-success" id="userdetails-submit"/>
                       </p>
                    </fieldset>
                        </form>
                    
                    
                   <!-- <div id="phase2">
                        <input type="text" id="housename" name="housename" placeholder="House Name/No" class="form-control field"><br>
                        <input type="text" id="street" name="street" placeholder="Street" class="form-control field"><br>
                        <input type="text" id="town" name="town" placeholder="Town/City" class="form-control field"><br>
                        <input type="text" id="county" name="county" placeholder="County" class="form-control field"><br> 
                        <input type="text" id="postcode" name="postcode" placeholder="Postcode" class="form-control field"><br> 
                        
                        <input type="submit" value="Previous" class="btn btn-success" id="userdetails-submit" onclick="backToPhase1()">
						<input type="submit" value="Next" class="btn btn-success" id="userdetails-submit" onclick="processPhase2()">
                    </div>
    
                    <div id="phase3">
                        <input type="text" id="cardname" name="nameoncard" placeholder="Name on Card" class="form-control field"><br>
                        <input type="text" id="cardno" name="cardno" placeholder="Card Number" class="form-control field"><br>
                        <input type="text" id="validfrom" name="validfrom" placeholder="Valid From" class="form-control field"><br>
                        <input type="text" id="validto" name="validto" placeholder="Valid To" class="form-control field"><br> 
                        <input type="text" id="csv" name="csv" placeholder="CSV " class="form-control field"><br> 
                        
                        <input type="submit" value="Previous" class="btn btn-success" id="userdetails-submit" onclick="backToPhase2()">
						<input type="submit" value="Next" class="btn btn-success" id="userdetails-submit" onclick="register()">
                        </div>
                    
                        <div id="show_all_data">
                            <p id="confirm-register">Thanks for registering!</p>
                            
                    
                        </div> -->
                    
                    </form>
                   
                </div>
                
                
            </div>
            <div class="col-sm-2"></div>
            </div>
        </div>
        
        
       
   
        
      <div class="row">
            <div id="footer">
                <ul class="footer">
                    <li class="foot"><a class="foot-link" href="contactus.html">Contact Us</a></li>
                    <li class="foot"><a class="foot-link" href="#">Terms & Conditions</a></li> 
                    <li class="foot"><p id="copyright">&copy; NB Gardens & Matthew Carter, 2016</p></li>
                    <div id="icon-pos">
                        <li class="icon" title="Find us on Facebook"><a class="foot-link" href="https://www.facebook.com"><img src="images/facebook.ico"/></a></li>
                        <li class="icon" title="Follow us on Instagram"><a class="foot-link"  href="https://www.twitter.com"><img src="images/twitter.ico"/></a></li>
                        <li class="icon" title="Follow us on Twitter"><a class="foot-link"  href="https://www.instagram.com"><img src="images/instagram.ico"/></a></li>
                    </div>
                </ul>
            </div>       

        </div><!--End of Container div-->   
    

        <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

          <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">Login</h4>
            </div>
            <div class="modal-body">
              <img src="images/modalgnome.jpg">
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
          </div>

        </div>
      </div>
    
</body>
</html>