<?php
require_once("dbcontroller.php");
$db_handle = new DBController();
if(!empty($_POST["keyword"])) {
$query ="SELECT * FROM `cartegory-iterm` WHERE name like '" . $_POST["keyword"] . "%' ORDER BY name LIMIT 0,6";
$result = $db_handle->runQuery($query);
if(!empty($result)) {
?>
<div class="alert alert-success">
<ul id="country-list">
<?php
foreach($result as $country) {
?>
<li  onClick="selectCountry('<?php echo $country["name"]; ?>');"><?php echo $country["name"]; ?></li>
<?php } ?>
</ul></div>
<?php } } ?>