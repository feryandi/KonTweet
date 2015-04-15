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
		Keywords: <input type="text" class="bigger-text" name="hashtag"><br>
		<!--<button type="button" id="addnew">Add category</button>-->
		
		<div id="categories">
		<div class="category">
			Category<input type="text" class="bigger-text" name="name0">
			<div id="tag-0" class="tag-holder">
				<input type="hidden" id="keys" name="keys0" value="">
				<input type="text" id="adder" class="hidden" value="">
			</div>
		</div>
		</div>
		
		<input type="radio" name="algo" value="0">KMP<br>
		<input type="radio" name="algo" value="1">BM
		
		<input type="submit">
	</form>
	</body>
</html>