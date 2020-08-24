<?php 
$connection = mysqli_connect("localhost", "root", "", "phplecture");

if(mysqli_connect_error()){
die("Failed to connect to database");
}
$query = "SELECT * FROM user WHERE name = 'garnnet'";

if($result = mysqli_query($connection, $query)){
	;
	while ( $row = mysqli_fetch_array($result)) {
		print_r($row);
	}
	
}else{
	echo "query error";
}
?>