<?php
	require_once("dbconnect.php");
	
	if($json = $_SERVER['HTTP_JSON']){

		$query = file_get_contents('php://input');
		$result=mysql_query($query,$conn);
		if($result==1)
			echo "Successfully Registered";
		else
			echo "Failed to Register";
	}
?>
