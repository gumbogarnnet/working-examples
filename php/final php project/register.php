<?php 
 include "connection.php";
 
 $insertbrand = "INSERT INTO `brand` (`id`, `brand`) VALUES (NULL, 'jghyu')";
 $insertCategory = "INSERT INTO `cartegory-iterm` (`id`, `catergory`, `name`, `image`) VALUES (NULL, '1', 'jmkbh', 'hv')";
 if (isset($_POST['btnSub'])) {

     $catergory = $_POST['catergory'];
    $child = $_POST['child'];
    $price = $_POST['price'];
    $title = $_POST['title'];
    $brand = $_POST['brand'];
    $image = $_POST['image'];
    
    $description = $_POST['description'];
   
    $query = "SELECT * FROM `cartegory-iterm` WHERE `catergory` = '$catergory' AND `name` = '$child'";
$result =  mysqli_query($connection, $query); 
  $row = mysqli_fetch_array($result); 
  
  if ($row) {
     $childcat = $row['id'];
      }
  else{

    $insertCategory = "INSERT INTO `cartegory-iterm` (`id`, `catergory`, `name`, `image`) VALUES (NULL, '$catergory', '$child', 'hv')";
    mysqli_query($connection, $insertCategory);
    $childcat =  mysqli_insert_id($connection);
  }

   
    
    $insertProduct =   "INSERT INTO `products` (`id`, `tittle`, `price`, `list-price`, `brand`, `image`, `description`, `catergory`) VALUES (NULL, '$title', '$price', '78', '$brand', '$image', '$description', '$childcat')";
  mysqli_query($connection, $insertProduct);
   
      }

?>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="au theme template">
    <meta name="author" content="Hau Nguyen">
    <meta name="keywords" content="au theme template">

    <!-- Title Page-->
    <title>Register</title>

    <!-- Fontfaces CSS-->
    <link href="css/font-face.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">

    <!-- Bootstrap CSS-->
    <link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">

    <!-- Vendor CSS-->
    <link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <link href="vendor/wow/animate.css" rel="stylesheet" media="all">
    <link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <link href="vendor/slick/slick.css" rel="stylesheet" media="all">
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/theme.css" rel="stylesheet" media="all">
    <style type="text/css">
        #country-list{list-style:none;}

#country-list li:hover{background:#ece3d2;cursor: pointer;}
    </style>

</head>

<body class="animsition">
    <div class="page-wrapper">
        
            <div class="container">
                <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg-6">
                                <div class="card">
                                    <div class="card-header">
                                        <strong>Add Products</strong> Form
                                    </div>
                                    <div class="card-body card-block">
                                        <form action="" method="post" enctype="multipart/form-data" class="form-horizontal">
                                            
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="text-input" class=" form-control-label">Product Name</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="text" id="text-input" name="title" placeholder="Text" class="form-control">
                                                    
                                                </div>
                                            </div>
                                             <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="text-input" class=" form-control-label">Brand</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="number" id="text-input" name="brand" placeholder="Product Brand eg Levis" class="form-control">
                                                    
                                                </div>
                                            </div>
                                            
                                              <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="text-input" class=" form-control-label">Image</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="text" id="text-input" name="image" placeholder="Product image" class="form-control">
                                                    
                                                </div>
                                            </div>
                                            
                                            
                                            
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="textarea-input" class=" form-control-label">Description</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <textarea name="description" id="textarea-input" rows="9" placeholder="Product Description" class="form-control"></textarea>
                                                </div>
                                            </div>
                                            <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="select" class=" form-control-label">Cartegory</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <select name="catergory" id="select" class="form-control">
                                                        <option value="0">All</option>
                                                        <option value="1">Men</option>
                                                        <option value="2">Women</option>
                                                        <option value="3">Boys</option>
                                                        <option value="3">Girls</option>

                                                    </select>
                                                </div>
                                            </div>
                                             <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="text-input" class=" form-control-label">Child Cartegory</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="text" id="search-box" name="child" placeholder="---------ajax suggestion---------" class="form-control">
                                                    <div id="suggesstion-box" ></div>
                                                    
                                                </div>
                                            </div>
                                             <div class="row form-group">
                                                <div class="col col-md-3">
                                                    <label for="text-input" class=" form-control-label">Price</label>
                                                </div>
                                                <div class="col-12 col-md-9">
                                                    <input type="number" id="text-input" name="price" placeholder="eg12.00" class="form-control">
                                                    
                                                </div>
                                            </div>

                                         
                                       
                                    </div>
                                    <div class="card-footer">
                                        <input type="submit" name="btnSub" value="Submit" class="btn btn-primary btn-sm"/>
                                            
                                        <button type="reset" class="btn btn-danger btn-sm">
                                            <i class="fa fa-ban"></i> Reset
                                        </button>
                                    </div> 
                                     </form>
                                </div>
                                
                            </div>
                        </div>
            
        </div>

    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="vendor/slick/slick.min.js">
    </script>
    <script src="vendor/wow/wow.min.js"></script>
    <script src="vendor/animsition/animsition.min.js"></script>
    <script src="vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
    <script src="vendor/counter-up/jquery.waypoints.min.js"></script>
    <script src="vendor/counter-up/jquery.counterup.min.js">
    </script>
    <script src="vendor/circle-progress/circle-progress.min.js"></script>
    <script src="vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="vendor/chartjs/Chart.bundle.min.js"></script>
    <script src="vendor/select2/select2.min.js">
    </script>

    <!-- Main JS-->
    <script src="js/main.js"></script>
    <script>
$(document).ready(function(){
    $("#search-box").keyup(function(){
        $.ajax({
        type: "POST",
        url: "readCountry.php",
        data:'keyword='+$(this).val(),
        beforeSend: function(){
            $("#search-box").css("background","#FFF url(LoaderIcon.gif) no-repeat 165px");
        },
        success: function(data){
            $("#suggesstion-box").show();
            $("#suggesstion-box").html(data);
            $("#search-box").css("background","#FFF");
        }
        });
    });
});

function selectCountry(val) {
$("#search-box").val(val);
$("#suggesstion-box").hide();
}
</script>

</body>

</html>
<!-- end document-->