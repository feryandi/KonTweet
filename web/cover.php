<html>
	<head>
		<title></title>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

		<link rel="stylesheet" type="text/css" href="css/global.css">
		<script src="js/jquery.mobile.touch.js"></script>
		<script src="js/main.js"></script>
	</head>

	<body>
	
	<div id="main" class="main-holder">
		<div class="ghost"></div>
		<div class="form-holder">
			<form id="form">
				<div class="form-element">
					<label>Topic <button type="button" id="customtopic">Customize</button></label>
					<div id="topic-chooser">			
						<div class="topic">Technology</div>
						<input id="topic-input" type="text" class="bigger-text" name="topic">
					</div>
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
							<button type="button" id="delete">-</button>
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
		<div class="ghost"></div>
	</div>
	
	<div id="analytics" class="main-holder">		
		<div style="float: left; width: 100%; box-sizing: border-box;">
			<div class="ghost little"></div>		
			<div class="analytics-holder">
				<label class="big-text">Analytics</label>
				<div id="analytics-bar">
					<div class="bar green" style="width: 0px"></div>
					<div class="bar red" style="width: 0px"></div>
					<div class="bar blue" style="width: 0px"></div>
				</div>
				<div id="categoryChooser">
					<!--<div class="category-btn">
						All Recent Tweets
					</div>
					<div class="category-btn">
						<div class="color-sample"></div>Unknown
					</div>-->
				</div>
				<div class="result">
				</div>
			</div>
			<div class="ghost little"></div>
		</div>
	</div>
	
	</body>
</html>