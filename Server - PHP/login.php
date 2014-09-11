<?php
require_once("dbconnect.php");
	
	
		//$json = file_get_contents('php://input');
if($_SERVER['HTTP_JSON'])
{
		$json = $_SERVER['HTTP_JSON'];
		$obj = json_decode($json);
		$email=$obj->{'email'};
		$password=$obj->{'pwd'};
		
		if(!$email=="" && !$password=="")
		{
		
		$query = "SELECT * FROM tbl_login where email='".$email."' and password='".$password."'";
		$rt = mysql_query($query, $conn);
		while ($rw = mysql_fetch_array($rt)) {
			$mail = $rw['email'];
			$pass = $rw['password'];
		}
		if($email==$mail && $password==$pass){
			//echo "Success";
			$query = "SELECT * FROM tbl_profile where email='".$email."' and password='".$password."'";
			$rst = mysql_query($query, $conn);
			while ($row = mysql_fetch_array($rst)) {
				$email = $row['email'];
				$pwd = $row['password'];
				$name= $row['name'];
				$clg= $row['college'];
				$phn= $row['phone'];
				$gender= $row['gender'];

			}
			$arr = array('name' => $name, 'college' => $clg, 'email' => $email, 'phone' => $phn, 'password' => $pwd, 'gender' => $gender);
			echo json_encode($arr);
		}
		else
			echo "Failed";
		}
		else
			echo "Failed";
	}
	

?>