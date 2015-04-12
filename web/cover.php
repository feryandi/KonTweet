<html>
	<head>
		<title></title>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="js/main.js"></script>
	</head>

	<body>
	<form action="index.php" method="post">
	<input type="hidden" id="counter" name="counter" value="1">
	Keyword: <input type="text" name="hashtag"><br>
	<button type="button" id="addnew">Add category</button>
	
	<div id="categories">
	<div class="category">
		Category<input type="text" name="name0"><input type="text" name="keys0">
	</div>
	</div>
	
	<input type="submit">
	</form>
	</body>
</html>