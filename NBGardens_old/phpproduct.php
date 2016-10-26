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
<body onload="setSearch()">
	
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
                
            </div>
            <div class="col-sm-2"></div>
        </div>
        </div>
    
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-2" id="sidebar">
                
                
			
			<form >
                <p>Search Catalogue:</p>
                    <div class="input-group add-on">
                      <input class="form-control" placeholder="Search" value="" id="search-term" type="text">
                      <div class="input-group-btn">
                        <button class="btn btn-default" type="button" onclick="return searchBar()" ><i class="glyphicon glyphicon-search"></i></button>
                      </div>
                    </div>
            
                <hr>
                <p>Products per page:</p>
                <select id="products" class="form-control" onchange="setSearch()">
					<option value="5">5 Items</option>
                    <option value="10">10 Items</option>
                    <option selected value="15">15 Items</option>
                </select>
				<hr>
				<p>Category:</p>
				<select id="product-type" class="form-control" onchange="setSearch()">
					   <option value="All">Everything</option>
					   <option value="Cute">Cute</option>
					   <option value="Funny">Funny</option>
					   <option value="Seasonal">Seasonal</option>
					   <option value="Horror">Horror</option>
				</select>
                <hr>
            
                <p>Price range:</p>
               
            <select id="price-from" class="form-control" onchange="setSearch()">
                   
                   <option selected value="500">£500</option>
                   <option value="1000">£1,000</option>
                   <option value="2000">£2,000</option>
                   <option value="3000">£3,000</option>
                   <option value="4000">£4,000</option>
                   <option value="5000">£5,000</option>
				   <option value="6000">£6,000</option>
				   <option value="7000">£7,000</option>
				   <option value="8000">£8,000</option>
				   <option value="9000">£9,000</option>
                   <option value="10000">£10,000</option>
                   <option value="20000">£20,000</option>
                </select></li>
                   <p id="to">To</p>
                <select id="price-to" class="form-control" onchange="setSearch()">
               
                   <option value="500">£500</option>
                   <option value="1000">£1,000</option>
                   <option value="2000">£2,000</option>
                   <option value="3000">£3,000</option>
                   <option value="4000">£4,000</option>
                   <option value="5000">£5,000</option>
				   <option value="6000">£6,000</option>
				   <option value="7000">£7,000</option>
				   <option value="8000">£8,000</option>
				   <option value="9000">£9,000</option>
                   <option value="10000">£10,000</option>
                   <option selected value="20000">£20,000</option>
                </select>
			
			<button type="submit" class="form-control" id="resetSearch">Reset Search</button>
		
			</form>
            <hr style="clear:both;">
             
            </div>
            <div class="col-sm-8">
                <div class="container-fluid" id="shopbody">
					<div id="shopping-body">
						
						<?php 
							include "searchQuery.php";
						?>
                        
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