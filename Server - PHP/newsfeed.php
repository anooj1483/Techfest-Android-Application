<?php
		require_once("dbconnect.php");
	if($_SERVER['HTTP_JSON'])
	{
		$json = $_SERVER['HTTP_JSON'];
		$obj = json_decode($json);
		$key=$obj->{'key'};
		if($key=="atharva")
		{
			$query = "SELECT * FROM tbl_newsfeed";
			$rt = mysql_query($query, $conn);
			$i=0;
			while ($rw = mysql_fetch_array($rt)) {
				$id = $rw['id'];
				$msg = $rw['message'];
				$arr[$i] =array('id' => $id, 'message' => $msg);
				$i++;
		}
		echo json_encode($arr);
		}
		else
			echo "error";
	}
?>