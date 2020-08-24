<?php 

if ($_POST['btnsub']) {
$emailTo = "gumbogarnnet@gmail.com";
$subject = "comment from ".$_POST['name'];
$body = $_POST['body'];
$header = "from: ".$_POST['header'];

if (!$_POST['header']) {
	$error = " please enter your email";
}
if (!$_POST['name']) {
	$error .= " <br /> please enter your name";
}
if (!$_POST['body']) {
	$error .= " <br /> please enter your comment";
}
if (!filter_var($_POST['header'], FILTER_VALIDATE_EMAIL) AND $_POST['header']) {
	$error .= "<br /> Incorect email";
}
if ($error) {
	$result = $error;
}else{
if (mail($emailTo, $subject, $body, $header)){
	echo "success";
}else{
	$result =  "Connection error";
}

}



}

?>
<!DOCTYPE html>
<html>
<head>
	<title>email project</title>
</head>
<body>
	<?php 
	
	echo $result; ?>
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