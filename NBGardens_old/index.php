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
               <div class="container" id="image-container">
                  <ul class="nav nav-tabs">
                    <li class="active"><a class="tab-style" data-toggle="tab" href="#news">News</a></li>
                    <li><a class="tab-style"  data-toggle="tab" href="#arrivals">New Arrivals</a></li>
                    <li><a class="tab-style"  data-toggle="tab" href="#sellers">Best Sellers</a></li>
                  </ul>

                  <div class="tab-content">
                      <!--NEWS TAB-->
                    <div id="news" class="tab-pane fade in active">
                     
                        <div class="news-container">
                            <a class="news-link" href="newspage.html"><img class="news-image "src="images/gnome_placeholder.png" alt="News Image">
                                <p class="news-preview"><b>Breaking:</b> Over 600 Gnomes found left for dead in recycling plant, part of a potential "gnome dumping scheme"</p></a>
                            
                            <a class="news-link" href="newspage.html"><img class="news-image "src="images/gnomefest.jpg" alt="News Image">
                                <p class="news-preview"><b>Gnomefest 2016:</b> Get the latest and greatest coverage of this year's Gnomefest, brought to you by OnlyGnomeTV</p></a>
                        </div>    
                        
                        
                        
                    </div>
                      <!--NEW ARRIVALS TAB-->
                    <div id="arrivals" class="tab-pane fade">
                       <div class="container"> 
                        <div class="img">
                          <a target="_blank" href="/images/drug_gnome.jpg">
                            <img src="images/drug_gnome.jpg" alt="A Gnome on drugs" width="300" height="200">
                          </a>
                          <div class="desc">As High As A Gnome</div>
                            <button type="button" class="btn btn-success btn-cart">Add to Cart</button>  
                        </div>

                        <div class="img">
                          <a target="_blank" href="/images/gnome_swing.jpg">
                            <img src="images/gnome_swing.jpg" alt="Gnome Couple" width="300" height="200">
                          </a>
                          <div class="desc">Gnome Couple Swingset</div>
                            <button type="button" class="btn btn-success btn-cart">Add to Cart</button>
                        </div>

                        <div class="img">
                          <a target="_blank" href="/images/rocket-gnome.jpg">
                            <img src="images/rocket-gnome.jpg" alt="Say hello to my little Gnome" width="300" height="200">
                          </a>
                          <div class="desc">Hasta La Vista Gnome</div>
                            <button type="button" class="btn btn-success btn-cart">Add to Cart</button>
                        </div>

                        <div class="img">
                          <a target="_blank" href="/images/surprise-gnome.jpg">
                            <img src="images/surprise-gnome.jpg" alt="Surprised Gnome" width="300" height="200">
                          </a>
                          <div class="desc">A Very Surprised Gnome</div>
                            <button type="button" class="btn btn-success btn-cart">Add to Cart</button>
                        </div>
                           
                        <div class="img">
                          <a target="_blank" href="/images/relax_gnome.jpg">
                            <img src="images/relax_gnome.jpg" alt="CHilled Gnome" width="300" height="200">
                          </a>
                          <div class="desc">The Big Lazy Gnome</div>
                            <button type="button" class="btn btn-success btn-cart">Add to Cart</button>
                        </div>       
                        </div>    
                        
                    </div>
                      <!--BEST SELLERS TAB-->
                    <div id="sellers" class="tab-pane fade">
                      
                        <div class="container"> 
                        <div class="img">
                          <a target="_blank" href="images/coming-soon.jpg">
                            <img src="images/coming-soon.jpg" alt="" width="300" height="200">
                          </a>
                          <div class="desc">Product #1 Information</div>
                            <button type="button" class="btn btn-success btn-cart">Add to Cart</button>  
                        </div>

                        <div class="img">
                          <a target="_blank" href="images/coming-soon.jpg">
                            <img src="images/coming-soon.jpg" alt="" width="300" height="200">
                          </a>
                          <div class="desc">Product #2 Information</div>
                            <button type="button" class="btn btn-success btn-cart">Add to Cart</button>
                        </div>

                        <div class="img">
                          <a target="_blank" href="images/coming-soon.jpg">
                            <img src="images/coming-soon.jpg" alt="" width="300" height="200">
                          </a>
                          <div class="desc">Product #3 Information</div>
                            <button type="button" class="btn btn-success btn-cart">Add to Cart</button>
                        </div>

                        <div class="img">
                          <a target="_blank" href="images/coming-soon.jpg">
                            <img src="images/coming-soon.jpg" alt="" width="300" height="200">
                          </a>
                          <div class="desc">Product #4 Information</div>
                            <button type="button" class="btn btn-success btn-cart">Add to Cart</button>
                        </div>
                           
                        <div class="img">
                          <a target="_blank" href="images/coming-soon.jpg">
                            <img src="images/coming-soon.jpg" alt="" width="300" height="200">
                          </a>
                          <div class="desc">Product #5 Information</div>
                            <button type="button" class="btn btn-success btn-cart">Add to Cart</button>
                        </div>       
                        </div>     
                        
                        
                        
                    </div>
                  </div>
                </div>
                
                
            </div>
            <div class="col-sm-2"></div>
            </div>
        </div>
        
        
       
   
        
      <div class="row">
            <div id="footer">
                <ul class="footer">
                    <li class="foot"><a class="foot-link" href="#">Contact Us</a></li>
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