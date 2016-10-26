<!DOCTYPE html>
<html lang="en">
<head>
  <title>NB Gardens</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Indie+Flower" rel="stylesheet">
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<body class="w3-container">
  <!--My custom stylesheet-->
  <link rel="stylesheet" href="style.css">
	<link rel="icon" href="images/gnomeicon.ico" type="image/x-icon"/>
	<link rel="shortcut icon" href="images/gnomeicon.ico" type="image/x-icon"/>
    </head>
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
              
                </div>
                
				<h1 id="about-us">We sell gnomes.</h1><br><br><br><br><br><br><br><br><br><br><br><br>
                
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
</body>
</html>