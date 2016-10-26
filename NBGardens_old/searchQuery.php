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

	
	$min = (isset($_GET['min']) ? $_GET['min'] : null);
	$max = (isset($_GET['max']) ? $_GET['max'] : null);
	$cat = (isset($_GET['cat']) ? $_GET['cat'] : null);
	$items = (isset($_GET['items']) ? $_GET['items'] : null);
    $search = (isset($_GET['search']) ? $_GET['search'] : null);
	$count = 0;
    if($items == ""){
        $items = 15;
    }

    $results = mysqli_query($con,"SELECT COUNT(*) FROM products");
    $get_total_rows = mysqli_fetch_array($results); //total records

	
   if($search != ""){
        $sql="SELECT * FROM products WHERE product_title LIKE \"%".$search."%\"";
        
    }
   
	else if($cat == "All"){
		$sql="SELECT * FROM products WHERE product_price >= '".$min."' AND product_price<= '".$max."' AND product_type = product_type";
	}
	else{
		$sql="SELECT * FROM products WHERE product_price >= '".$min."' AND product_price<= '".$max."' AND product_type = '".$cat."'";
	}

	$result = mysqli_query($con,$sql) or die(mysqli_error());

	while($row = mysqli_fetch_assoc($result)){

		echo"<div class='browse-image'>
			<a href='#'>
			<p class='price'>£" . $row['product_price'] . "</p>
			<img src='" . $row['product_image'] . "' width='200px' class='thumb'>
			<figcaption>" . $row['product_title'] . "</figcaption></a></div>";
			$count++;
			
    }

	mysqli_close($con);
?>
