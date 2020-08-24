<?php 
if ($_GET["btnsub"]) {
if ($_GET["name"]) {
	echo "your name is".$_GET['name'];
}else{
	echo "enter your name";
}
}
 ?>
 <!DOCTYPE html>
 <html>
 <head>
 	<title>my first php</title>
 </head>
 <body>
 <form>
 	<label>name</label>
 	<input type="text" name="name">
 	<input type="submit" name="btnsub" value="ok">
 </form>
 </body>
 </html>