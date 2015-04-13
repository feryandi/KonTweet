<html>
	<head>
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/global.css">
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="js/main.js"></script>
	</head>

	<body>
	<form id="form">
		<input type="hidden" id="counter" name="counter" value="1">
		Keywords: <input type="text" name="hashtag"><br>
		<button type="button" id="addnew">Add category</button>
		
		<div id="categories">
		<div class="category">
			Category<input type="text" name="name0"><input type="text" name="keys0">
		</div>
		</div>
		
		<input type="radio" name="algo" value="0">KMP<br>
		<input type="radio" name="algo" value="1">BM
		
		<input type="submit">
	</form>
	</body>
</html>