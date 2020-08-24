<!DOCTYPE html>
<html>
<head>
	<title>j query</title>
</head>
<body>


<script src="js/jquery.min.js"></script>
<script type="text/javascript">
	$.get("project3.php",function (data) {
		alert(data);
	});
</script>
</body>
</html>