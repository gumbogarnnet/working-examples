<?php 
session_start();
?>
<!DOCTYPE html>
<html>
<head>
	<title>session test</title>
</head>
<body>
<h1><?php 
echo $_SESSION['id'];
?></h1>
</body>
</html>