<?php
		require_once("dbconnect.php");
	
	//if($json = $_SERVER['HTTP_JSON']){
		$json = file_get_contents('php://input');
		$obj = json_decode($json);
		$key=$obj->{'key'};
		
			//echo "Key:".$key;
			$query = "SELECT * FROM tbl_events where event_name='".$key."'";
			//echo $query;
			$rt = mysql_query($query, $conn);
			
			while ($rw = mysql_fetch_array($rt)) {

				$name = $rw['event_name'];
				$desc=$rw['event_desc'];
				$coname=$rw['event_coname'];
				$conum=$rw['event_conum'];
				
		}
		$arr=array('event_name' => $name, 'event_desc' => $desc,'event_coname' => $coname,'event_conum'=> $conum);
		echo json_encode($arr);
		
	//}
?>