<?php
	if ( $_SERVER['REQUEST_METHOD'] == 'POST' ) {
		$count = $_POST['counter']; 
	
		class Query {
			public $topic = "";
			public $hashtag = "";
			public $algorithm = "";
			public $category = array();		
		}
		
		class Keywords {
			public $name = "";
			public $keys = array();
		}
		
		$q = new Query();
		$q->topic = "Testcase";
		$q->hashtag = $_POST['hashtag'];
		$q->algorithm = 1;
		
		for ( $i = 0; $i < $count; $i++ ) {
			$k = new Keywords();
			$k->name = $_POST['name'.$i]; 
			$k->keys = explode(",", $_POST['keys'.$i]);
			
			foreach ($k->keys as $key) {
				$key = trim($key);
			}
			
			array_push($q->category,$k);
		}
				
		$query = json_encode($q);
		$query = str_replace("\"","\\\"",$query);

		echo "<pre>";
		exec("java -jar jar/Main.jar \"" . $query . "\" 2>&1", $output);
		$result = json_decode(utf8_encode($output[0]), true);
		print_r($result);
		echo "</pre>";
		
	} else {
	
		echo file_get_contents('cover.php');
		
	}
	
?>
