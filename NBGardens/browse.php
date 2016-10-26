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
	<script src="script.js"></script>
	<link rel="icon" href="images/gnomeicon.ico" type="image/x-icon"/>
	<link rel="shortcut icon" href="images/gnomeicon.ico" type="image/x-icon"/>
    </head>
  <link rel="shortcut icon" href="images/gnomeicon.ico">
<body>
    <div class="container-fluid">

                <nav class="navbar">
                  <div class="container-fluid">
                     <div class="navbar-header">
                          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span> 
                          </button>
                    </div>
                    <div class="collapse navbar-collapse" id="myNavbar">
                      <ul class="nav navbar-nav">
                        <li><a href="index.html">Home</a></li>
                        <li><a href="aboutus.php">About Us</a></li>
                        <li class="active"><a href="browse.php">Browse</a></li>
                        <li><a href="gallery.php">Gallery</a></li>
                      </ul>
                      <ul class="nav navbar-nav navbar-right">
                           
                        <li><a href="register.html"><span class="glyphicon glyphicon-user"></span> Register</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                      </ul>
                    </div>
                  </div>
                </nav>
                <!--END OF NAVBAR CODE-->
                

  
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
                
            </div>
            <div class="col-sm-2"></div>
        </div>
        </div>
    
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-2" id="sidebar">
                <p>Search Catalogue:</p>
                    <div class="input-group add-on">
                      <input class="form-control" placeholder="Search" name="srch-term" id="search-term" type="text">
                      <div class="input-group-btn">
                        <button class="btn btn-default" type="submit" onsubmit="searchProducts(search-term.value)"><i class="glyphicon glyphicon-search"></i></button>
                      </div>
                    </div>
                </form>
                
                <hr>
                <p>Products per page:</p>
                <select id="products" class="form-control" onchange="displayProducts(this.value)">
                    <option value="5">5 Items</option>
                    <option value="10">10 Items</option>
                    <option value="15">15 Items</option>
                    <option selected value="20">20 Items</option>
                </select>
                <hr>
                <form action="">
                <input type="checkbox" name="gnome" value="seasonal" class="gnome-size"> Small Gnomes<br>
                <input type="checkbox" name="gnome" value="" class="gnome-size"> Medium Gnomes<br>
                <input type="checkbox" name="gnome" value="Large gnomes" class="gnome-size"> Large Gnomes<br>
                </form>
                <hr>
                <p>Price range:</p>
               
           <form id="priceform">
			<select id="price-from" class="form-control">                
                   <option selected value="£500">£500</option>
                   <option value="1000">£1,000</option>
                   <option value="2000">£2,000</option>
                   <option value="3000">£3,000</option>
                   <option value="4000">£4,000</option>
                   <option value="5000">£5,000</option>
                   <option value="10000">£10,000</option>
                   <option value="20000">£20,000</option>
                </select></li>
                   <p id="to">To</p>
                <select id="price-to" class="form-control">
               
                   <option value="500">£500</option>
                   <option value="1000">£1,000</option>
                   <option value="2000">£2,000</option>
                   <option value="3000">£3,000</option>
                   <option value="4000">£4,000</option>
                   <option value="5000">£5,000</option>
                   <option value="10000">£10,000</option>
                   <option selected value="20000">£20,000</option>
                 </select>
			</form>
            <hr style="clear:both;">
             
            </div>
            <div class="col-sm-8">
                <div class="container-fluid">
					<div id="section1">
						<div class="browse-image 4999">
							<a href="#">
							<p class="price" value="4999"><?php $row['product_title'] ?></p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
						 <div class="browse-image 6999">
							<a href="#">
							<p class="price" value="6999">£6,999</p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
						<div class="browse-image 1999">
							<a href="#">
							<p class="price" value="1999">£1,999</p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
						<div class="browse-image 5299">
							<a href="#">
							<p class="price" value="5299">£5,200</p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
						<div class="browse-image 12999">
							<a href="#">
							<p class="price" value="12999">£12,999</p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
					</div>
					<div id="section2">
						<div class="browse-image 19999">
							<a href="#">
							<p class="price">£19,999</p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
						<div class="browse-image 4529">
							<a href="#">
							<p class="price">£4,529</p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
						<div class="browse-image 6199">
							<a href="#">
							<p class="price">£6,199</p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
						<div class="browse-image 2799">
							<a href="#">
							<p class="price">£2,799</p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
						<div class="browse-image 4500">
							<a href="#">
							<p class="price">£4,500</p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
					</div>
					<div id="section3">
						<div class="browse-image">
							<a href="#">
							<p class="price">£4,999</p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
						<div class="browse-image">
							<a href="#">
							<p class="price">£4,999</p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
						<div class="browse-image">
							<a href="#">
							<p class="price">£4,999</p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
						<div class="browse-image">
							<a href="#">
							<p class="price">£4,999</p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
						<div class="browse-image">
							<a href="#">
							<p class="price">£4,999</p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
					</div>
					<div id="section4">
						<div class="browse-image">
							<a href="#">
							<p class="price">£4,999</p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
						<div class="browse-image">
							<a href="#">
							<p class="price">£4,999</p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
						<div class="browse-image">
							<a href="#">
							<p class="price">£4,999</p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
						<div class="browse-image">
							<a href="#">
							<p class="price">£4,999</p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
						<div class="browse-image">
							<a href="#">
							<p class="price">£4,999</p>
							<img src="images/gnome_swing.jpg" width="200px" class="thumb">
							<figcaption>Swingset Gnomes</figcaption></a>
						</div>
					</div>
                </div>
				<br>
            </div>
            <div class="col-md-1"></div>

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