<?php  
//$json=$_GET ['json'];
$json = file_get_contents('php://input');
$obj = json_decode($json);
echo $obj->{'Name'};
echo $obj->{'College'};


//echo $json;

//Save
//$con = mysql_connect('localhost','root','123456') 
      // or die('Cannot connect to the DB');
//mysql_select_db('TEST',$con);
  /* grab the posts from the db */
  //$query = "SELECT post_title, guid FROM wp_posts WHERE 
  //  post_author = $user_id AND post_status = 'publish'
  // ORDER BY ID DESC LIMIT $number_of_posts";
//mysql_query("INSERT INTO `test`.`users` (UserName, FullName)


//mysql_close($con);
//
 // $posts = array($json);
 // $posts = array(1);
  //  header('Content-type: application/json');
  //  echo json_encode(array('posts'=>$posts)); 
  ?>