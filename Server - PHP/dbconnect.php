<?php


class Db_Connect{

private $server = "localhost";
private $user = "atharva_droid";
private $password = "droid@*#123";

 function create_connection() {
 
 $conn = mysql_connect($this->server,$this->user,$this->password); 
 return($conn);
 
 }

}

$obj = new Db_Connect();
$conn = $obj->create_connection();

if(!$conn){
die("Cannot connect to database , ".mysql_error());
}

mysql_select_db("atharva_cemp",$conn);







?>