<?php
	require_once("dbconnect.php");
	
		
		$mail = file_get_contents('php://input');
		$query="select password from tbl_profile where email='".$mail."'";
		$result=mysql_query($query,$conn);
		while ($rw = mysql_fetch_array($result)) {
			$pwd = $rw[0];
		}

		mail($mail,"Forget Password","Your Password is: ".$pwd,"atharvacemp@gmail.com");
	
		if($pwd=="")
			echo "Not a registered mail ID";
		else
			echo "Check your mail account for password";
?>
