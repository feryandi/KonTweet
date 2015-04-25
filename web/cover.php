<!DOCTYPE html>
<head>
	<title>KonTweet</title>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-switch.min.css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/slideshow.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-switch.min.js"></script>
	<script src="js/main.js"></script>
	
</head>

<body>
	<ul class="slideshow">
		<li><span>Image 01</span><div><h3>Masjid Raya Bandung <br> ©2015 Google</h3></div></li>
		<li><span>Image 02</span><div><h3>Jembatan Layang <br> ©2015 Google</h3></div></li>
		<li><span>Image 03</span><div><h3>Plaza Widya ITB <br> ©2015 Google</h3></div></li>
		<li><span>Image 04</span><div><h3>Gedung Merdeka <br> ©2015 Google</h3></div></li>
		<li><span>Image 05</span><div><h3>Braga <br> ©2015 Google</h3></div></li>
		<li><span>Image 06</span><div><h3>Braga Culinary Night <br> ©2015 Google</h3></div></li>
	</ul>
	
	<div class="container">
	<form id="form">
		<div class="row" style="margin-top:20px">
			<div class="col-md-8">
				<div class="well form-search minimum">
					<div id="analytics" >
						<h4 class="text-center title">Analytics</h4>
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
						<div style="overflow: hidden">
							<div class="result well slideInDown animated">
							</div>		
						</div>						
					</div>				
					
					<div id="analyze-btn" class="row row-centered">
						<div class="col-md-3 col-centered">
							<button type="submit" id="submitter" class="btn btn-success hide-button">
							<span class="glyphicon glyphicon-search search-logo" aria-hidden="true"></span>
							<span class="search-text">do another search</span>
							</button>								
						</div>
					</div>
					
					<div id="analyze-load" class="loader">
					  <svg class="circular">
						<circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="10" stroke-miterlimit="10"/>
					  </svg>
					</div>
				</div>
			</div>
			
			
			
			
			
			<div class="col-md-4 row">
				
			<div class="well form-search">
				<h4 class="text-center title">Topic</h4>
				<div id="topic-chooser">			
					<div class="topic btn btn-default btn-block">Sport</div>
					<!-- <input id="topic-input" type="text" class="bigger-text" name="topic"> -->
				</div>
				<br>
				
				<div class="row">
					
					<div class="col-sm-8">
						<input name="hashtag" type="text" class="form-control input" placeholder="Keyword">
					</div>
					<div class="col-sm-4">
						<input type="checkbox" id="algo" name="algo" data-on="primary" data-on-text="KMP" data-off-text="BM" data-label-width="7"/>
					</div>
				
					
				</div>

			</div>

			<div class="well form-search">
				<h4 class="text-center title">Categories</h4>
				<input type="hidden" id="counter" name="counter" value="1">	
				<div id="categories">	
				
					<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
						<div id="cat-0" class="panel panel-default category">
							<div class="panel-heading" role="tab" id="headingOne">  
								<h4 class="panel-title">
								<div class="input-group">				
									<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
										<input name="name0" type="text" class="form-control input" placeholder="New Category" >
									</a>
									<span class="input-group-btn">
										<button type="button" id="delete" class="btn btn-default">
											<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
										</button>
									</span>
								</div>
							  </h4>
							</div>
							<div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
								<div class="panel-body">
									<div id="tag-0" class="tag-holder">
										<input type="hidden" id="keys" name="keys0" value="" >
										<span class="flexible">
											<input type="text" id="adder" placeholder="add key" class="form-control hiding" value="">
										</span>
									</div>							
								</div>
							</div>
						</div>
						
						<div id="cat-1" class="panel panel-default category">
							<div class="panel-heading" role="tab" id="headingTwo">  
								<h4 class="panel-title">
								<div class="input-group">				
									<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
										<input name="name1" type="text" class="form-control input" placeholder="New Category">
									</a>
									<span class="input-group-btn">
										<button type="button" id="delete" class="btn btn-default">
											<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
										</button>
									</span>
								</div>
							  </h4>
							</div>
							<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
								<div class="panel-body">
									<div id="tag-1" class="tag-holder">
										<input type="hidden" id="keys" name="keys1" value="" >
										<span class="flexible">
											<input type="text" id="adder" placeholder="add key" class="form-control hiding" value="">
										</span>
									</div>							
								</div>
							</div>
						</div>
						
						<div id="cat-2" class="panel panel-default category">
							<div class="panel-heading" role="tab" id="headingThree">  
								<h4 class="panel-title">
								<div class="input-group">				
									<a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="true" aria-controls="collapseThree">
										<input name="name2" type="text" class="form-control input" placeholder="New Category">
									</a>
									<span class="input-group-btn">
										<button type="button" id="delete" class="btn btn-default">
											<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
										</button>
									</span>
								</div>
							  </h4>
							</div>
							<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
								<div class="panel-body">
									<div id="tag-2" class="tag-holder">
										<input type="hidden" id="keys" name="keys2" value="" >
										<span class="flexible">
											<input type="text" id="adder" placeholder="add key" class="form-control hiding" value="">
										</span>
									</div>							
								</div>
							</div>
						</div>
						
					</div>
					
					<div class="input-group col-md-1 center-block">				
						<button type="button" id="addnew" class="btn btn-default ">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
						</button>
					</div>
					
				</div>
			</div>
			
		</div>
	</form>
	</div>
</body>

<html>