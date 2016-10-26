<html>
   
    <body>
        <?php session_start(); ?>
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
                        <li><a href="index.php">Home</a></li>
                        <li><a href="aboutus.php">About Us</a></li>
                        <li><a href="phpproduct.php">Browse</a></li>
                        <li><a href="gallery.php">Gallery</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                       <?php  
                        if(!isset($_SESSION['user_id'])) { ?>
                            <li><a href="register.php"><span class="glyphicon glyphicon-user"></span> Register</a></li>
                            <li><a href="#loginModal" data-toggle="modal" data-target="#loginModal"><span class="glyphicon glyphicon-log-in"></span> Log In</a></li>
                           <?php }
                            else{ ?>
                                <li><a href="logout.php"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
                         <?php   } ?>
                        
                    </ul>
                </div>
            </div>
        </nav>
        <!--END OF NAVBAR CODE-->
        <script>
            $(document).ready(function () {
                    var url = window.location;
                // Will only work if string in href matches with location
                    $('ul.nav a[href="' + url + '"]').parent().addClass('active');
            
                // Will also work for relative and absolute hrefs
                    $('ul.nav a').filter(function () {
                        return this.href == url;
                    }).parent().addClass('active').parent().parent().addClass('active');
                });
                    
        </script>
        <div id="loginModal" class="modal fade" role="dialog" style="display: none;">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">×</button>
                        <h4 class="modal-title">Sign In</h4>
                    </div>
                    <div class="modal-body">
                        <form action="login_submit.php" method="post" id="userdetails-form" class="form-inline" >
                            <fieldset>
                                <p>
                                    <label for="phpro_username">Email Address</label>
                                    <input type="text" id="phpro_email" name="phpro_email" value="" maxlength="40" class="form-control field"/>
                                </p>
                                <p>
                                    <label for="phpro_password">Password</label>
                                    <input type="text" id="phpro_password" name="phpro_password" value="" maxlength="20" class="form-control field"/>
                                </p>
                                <p>
                                    <input type="submit" value="Login" />
                                </p>
                            </fieldset>
                        </form>
                        <div class="modal-footer">
                            <button type="button" id="login-button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>