<?php
	function send_message($message) {
	    echo "data: " . json_encode($message) . PHP_EOL;
	    echo PHP_EOL;
	      
	    ob_flush();
	    flush();
	}
	
	function doExec($query) {
		exec("java -jar jar/Main.jar \"" . $query . "\" 2>&1", $output);
		$result = json_decode(utf8_encode(preg_replace('/("\w+"):(\d+)/', '\\1:"\\2"', $output[0])), true);
		
		send_message($result);
	}

	if ( $_SERVER['REQUEST_METHOD'] == 'GET' ) {
		if (isset($_GET["hashtag"])) {
			header('Content-Type: text/event-stream');
			header('Cache-Control: no-cache');
			
			$count = $_GET['counter']; 
		
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
			$q->hashtag = $_GET['hashtag'];
			
			if(isset($_GET['algo'])) {
				$q->algorithm = 0;
			} else {
				$q->algorithm = 1;
			}

			for ( $i = 0; $i < $count; $i++ ) {
				$k = new Keywords();
				$k->name = $_GET['name'.$i]; 
				$k->keys = explode(",", $_GET['keys'.$i]);
				
				foreach ($k->keys as &$key) {
					$key = trim($key);
				}
				
				array_push($q->category,$k);
			}
					
			$query = json_encode($q);
			$query = str_replace("\"","\\\"",$query);

			doExec($query);
		} else {
		
			readfile(__DIR__ . '\cover.php');
			
		}
	}
	
?>
