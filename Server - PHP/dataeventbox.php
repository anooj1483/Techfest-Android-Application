<?php
	require_once("dbconnect.php");
	
	//if($json = $_SERVER['HTTP_JSON']){

		$query = file_get_contents('php://input');
		$rt = mysql_query($query, $conn);

		while ($rw = mysql_fetch_array($rt)) {
			$androwar = $rw['androwar'];
			$codechef = $rw['codechef'];
			$cadkraft = $rw['cadkraft'];
			$owntown = $rw['owntown'];
			$fehelekter = $rw['fehelekter'];
			$defuse_or_decay = $rw['defuse_or_decay'];			
			$fault_detekcia = $rw['fault_detekcia'];
			$wagers_electrici = $rw['wagers_electrici'];			
			$battle_of_bands = $rw['battle_of_bands'];
			$voice_of_atharva = $rw['voice_of_atharva'];			
			$chasse_au_tresor = $rw['chasse_au_tresor'];
			$stepz_in = $rw['stepz_in'];			
			$street_soccer = $rw['street_soccer'];
			$quiz = $rw['quiz'];			
			$itreasure = $rw['itreasure'];
			$networker = $rw['networker'];			
			$junkyard_wars = $rw['junkyard_wars'];
			$water_rocket = $rw['water_rocket'];			
			$death_race = $rw['death_race'];
			$real_steel = $rw['real_steel'];			
			$battleship = $rw['battleship'];
			$celluloid = $rw['celluloid'];			
			$just_frame_it = $rw['just_frame_it'];
			$ppt_eee = $rw['ppt_eee'];			
			$ppt_cs = $rw['ppt_cs'];
			$ppt_me = $rw['ppt_me'];			
			$ppt_ce = $rw['ppt_ce'];
			
			
		}
		
		$arr = array('androwar' => $androwar, 'codechef' => $codechef, 'cadkraft' => $cadkraft, 'owntown' => $owntown, 'fehelekter' => $fehelekter, 'defuse_or_decay' => $defuse_or_decay,'fault_detekcia' => $fault_detekcia, 'wagers_electrici' => $wagers_electrici, 'battle_of_bands' => $battle_of_bands, 'voice_of_atharva' => $voice_of_atharva, 'chasse_au_tresor' => $chasse_au_tresor, 'stepz_in' => $stepz_in,'street_soccer' => $street_soccer, 'quiz' => $quiz, 'itreasure' => $itreasure, 'networker' => $networker, 'junkyard_wars' => $junkyard_wars, 'water_rocket' => $water_rocket,'death_race' => $death_race, 'real_steel' => $real_steel, 'battleship' => $battleship, 'celluloid' => $celluloid, 'just_frame_it' => $just_frame_it, 'ppt_eee' => $ppt_eee,'ppt_cs' => $ppt_cs, 'ppt_me' => $ppt_me, 'ppt_ce' => $ppt_ce);
		
			echo json_encode($arr);
		
		//echo $status;
	
?>