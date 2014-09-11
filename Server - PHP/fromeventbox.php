<?php
	require_once("dbconnect.php");
	
	//if($json = $_SERVER['HTTP_JSON']){

		$query = file_get_contents('php://input');
		$rt = mysql_query($query, $conn);

		while ($rw = mysql_fetch_array($rt)) {
			$status = $rw[0];
		}
		
		echo $status;
	
?>
