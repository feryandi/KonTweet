<html>
	<head>
		<title></title>
		<link rel="stylesheet" type="text/css" href="css/global.css">
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="js/main.js"></script>
	</head>

	<body>
	
	<div id="main" class="main-holder">
		<div class="form-holder">
			<form id="form">
				<div id="topic-chooser">
					<div class="topic"></div>
					<div class="topic"></div>
					<div class="topic"></div>
				</div>
				
				<input type="hidden" id="counter" name="counter" value="1">
				
				<div class="form-element">
					<label>Keywords</label>
					<input type="text" class="bigger-text" name="hashtag">
				</div>
								
				<div class="form-element">
					<div id="categories">
						<label>Categories <button type="button" id="addnew">+</button></label>
						
						<div class="category">
							<div id="tag-0" class="tag-holder">
								<input type="text" class="bigger-text categ-name" placeholder="Category" name="name0">
								<input type="hidden" id="keys" name="keys0" value="" >
								<span class="flexible"><input type="text" id="adder" placeholder="add key" class="hidden" value=""></span>
							</div>
							<!--<button type="button" id="addnew">-</button>-->
						</div>
						
					</div>
				</div>
				
				<div class="form-element">
					<label>Algorithm</label>
					<span id="algorithm">
						<div class="simple-box selected">Knuth–Morris–Pratt</div>
						<div class="simple-box">Boyer–Moore</div>
					</span>
					<input type="radio" class="invisible" name="algo" value="0" checked>
					<input type="radio" class="invisible" name="algo" value="1">
				</div>
				
				<div class="form-element centered">
					<input type="submit" value="Analyze">
				</div>
			</form>
		</div>
		
		<div class="frimg-holder">
		</div>
	</div>
	<!--
	<div id="analytics" class="main-holder">
	</div>
	
	<div id="keys" class="main-holder">
	</div>-->
	
	</body>
</html>