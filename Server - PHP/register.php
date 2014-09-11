<?php
        require_once("dbconnect.php");
		
		$json = file_get_contents('php://input');
		$obj = json_decode($json);
		
		$name=$obj->{'Name'};
		$college=$obj->{'College'};
		$email=$obj->{'Email'};
		$phn=$obj->{'Phn'};
		$gender=$obj->{'Gender'};
		$password=$obj->{'Password'};
                //echo " Email ".$email;
		$order = "INSERT INTO tbl_profile VALUES('" . $name ."','".$college."','".$email."','".$phn."','".$gender."','".$password."')";
		$query="INSERT INTO tbl_login VALUES('".$email."','".$password."')";
		$qry="INSERT INTO tbl_eventbox VALUES('".$email."',0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)";
                $result=mysql_query($order,$conn);
                
                if ($result == 1)
                    echo "Success";
                else
                     {
                    echo "Already_Registered";
                    
                      }
		$result=mysql_query($query, $conn);
		$result=mysql_query($qry,$conn);
              

?>