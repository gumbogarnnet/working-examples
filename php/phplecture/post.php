<?php 
$myArray = array('Tinevimbo', 'Makomborero', 'Garnnet' );
if ($_POST["btnsub"]) {
foreach ($myArray as $name) {
	if ($_POST['name'] == $name) {
		$meet =1;
	}
}
if ($meet) {
	echo "You are member of the family ".$_POST['name'];
}else{
	echo "you are not a member of the family ".$_POST['name'];
}
}
 ?>
 <!DOCTYPE html>
 <html>
 <head>
 	<title>my first php</title>
 </head>
 <body>
 <form method="POST">
 	<label>name</label>
 	<input type="text" name="name">
 	<input type="submit" name="btnsub" value="ok">
 </form>
 </body>
 </html>