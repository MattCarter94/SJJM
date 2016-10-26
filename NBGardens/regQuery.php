<?php 
	

	$con = mysqli_connect('localhost','root','','nbgardens');

    //$host_name  = "db649199510.db.1and1.com";
    //$database   = "db649199510";
    //$user_name  = "dbo649199510";
    //$password   = "gardens";


   // $con = mysqli_connect($host_name, $user_name, $password, $database);
    
	if (!$con) {
    	die('Could not connect: ' . mysqli_error($con));
	}

// Take the variables from Javascript & store to PHP variables (set to 'null' if nothing is found)
	$fname = (isset($_GET['fname']) ? $_GET['fname'] : null);
	$surname = (isset($_GET['surname']) ? $_GET['surname'] : null);
	$email = (isset($_GET['email']) ? $_GET['email'] : null);
	$password = (isset($_GET['password']) ? $_GET['password'] : null);
   

    $sql= "INSERT INTO users (first_name, surname, email_address, password) VALUES ('".$fname."', '".$surname."', '".$email."', '".$password."')";
        


	$result = mysqli_query($con,$sql);

	echo "First name: " . $fname . "<br>Surname: " . $surname . "<br>Email: " . $email . "<br>Password: " . $password;

 //   echo $sql;
	mysqli_close($con);
?>
