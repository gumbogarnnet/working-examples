<?php 
include "connection.php";
$id = $_GET['id'];
$query = "SELECT * FROM `products` WHERE `products`.`id` = $id";

$result = mysqli_query($connection, $query);
$row = mysqli_fetch_array($result);


?>

<div class="row">
                                <div class="col-md-6" style="background-image: url('images/bg-title-01.jpg'); background-size: 100%; background-repeat: no-repeat;"></div>
                                <div class="col-md-6">
<p><strong><?php echo $row['tittle'];?></strong>
</p>
                                    <p>
                                <?php echo $row['description'];?>
                               
                            </p><br/>
                            Price: <?php echo $row['price'];?><br/>
                            Brand: <?php echo $row['brand'];?>
                            <br/><br/>
                       
                       <input type="text" name="quantity" class="form-control" placeholder="Quantity eg 24 pcs" />
                        <br/>
                       
                       <input type="text" name="size" class="form-control" placeholder="select size" />
                                </div>
                            </div>
                            
                        