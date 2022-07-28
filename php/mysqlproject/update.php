<?php 
session_start();
include("connection.php");
$diary = mysqli_real_escape_string($connection, $_POST['diary']);
$id = $_SESSION['id'];

$query = "UPDATE `user` SET `diary` = '$diary' WHERE `user`.`id` = '$id'";
mysqli_query($connection, $query);
?>
