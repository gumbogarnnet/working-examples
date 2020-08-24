<?php 
$myArray  = array('garnnet', 'tinevimbo', 'makomborero' );

for ($i=0; $i < sizeof($myArray) ; $i++) { 
	echo $myArray[$i]."<br />";
}

foreach ($myArray as $key => $value) {
	echo $value."<br />";
}

for ($i=1; $i < 20 ; $i++) { 
	echo $i + 1;
	echo "<br />";
}
$counter = 0;
while ( $counter <= sizeof($myArray)) {
	echo $counter;
	$counter++;
}

?>