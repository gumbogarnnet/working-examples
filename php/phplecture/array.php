<?php
$myArray = array("garnnet", "gumbo", "mako");
$myArray[3] = "tinevimbo";
unset($myArray[2]);
echo $myArray[0];
print_r($myArray);
?>