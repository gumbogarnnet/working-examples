<?php 
if ($_POST['btnsub']) {
$emailTo = "gumbogarnnet@gmail.com";
$subject = "comment from ".$_POST['name'];
$body = $_POST['body'];
$header = "from: ".$_POST['header'];

if (mail($emailTo, $subject, $body, $header)){
	echo "success";
}
else{
	echo "failed check your connection";
}
}

?>
<!DOCTYPE html>
<html>
<head>
	<title>email project</title>
</head>
<body>
<form method="POST">
	<h2>Contact Us</h2>
	<label>Your email           :</label>
	<input type="text" name="header"><br/><br/>
	<label>Your Name            :</label>
	<input type="text" name="name"><br/><br/>
	<label>Your Comment:</label>
	<textarea type="text" name="body"></textarea><br/><br/>
	
	<input type="submit" name="btnsub">
</form>
</body>
</html>