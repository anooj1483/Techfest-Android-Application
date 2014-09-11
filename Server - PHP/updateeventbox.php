<?php
		require_once("dbconnect.php");
		$query = file_get_contents('php://input');
		$result = mysql_query($query, $conn);

		if($result==1)
			echo "Updated";
		else 
			echo "Failed";	

	
?>