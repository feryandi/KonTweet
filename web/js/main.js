function showCategory(n) {;	
	for ( i = 0; i <= $('.category-btn').length; i++ ) {
		$('#holder' + i).hide();		
	}
	$('#holder' + n).show();	
}

function showResult(result) {
	var i;		
	var size = [0, 0, 0, 0];
	
	for ( i = 0; i <= $('.category').length; i++ ) {
		var categoryHolder = document.createElement("div");		
		$(categoryHolder).attr('id', 'holder' + i);
		$(categoryHolder).addClass("categoryHolder");
		$(".result").append(categoryHolder);
		
		makeCatButton(i);
	}
	
	
	for ( i = 0; i < result.length; i++ ) {
		var prevDiv = tweetHTML(result, i);

		if ( result[i].category > 0 ) {		
			$("#holder" + result[i].category).prepend(prevDiv);	
			size[result[i].category] += 1;			
		} else {	
			$("#holder0").prepend(prevDiv);		
			size[0] += 1;		
		}
	}
	
	var totalSize = result.length;
	
	$('#analytics').show();
	
	for ( i = 0; i <= $('.category').length; i++ ) {
		switch (i) {
			case 0:
				$(".bar.red").css("width", Math.floor((size[i + 1] / totalSize) * $("#analytics-bar").width()) + "px" );	
				break;
			case 1:
				$(".bar.blue").css("width", + Math.floor((size[i + 1] / totalSize) * $("#analytics-bar").width()) + "px" );		
				break;
			case 2:
				$(".bar.green").css("width", + Math.floor((size[i + 1] / totalSize) * $("#analytics-bar").width()) + "px" );		
				break;
		}
		
		var sorry = document.createElement("div");
		$(sorry).addClass('sorry');
		
		if ( size[i] == 0 ) {			
			$(sorry).html("No Result Found");
		} else {
			$(sorry).html("End of Result");		
		}
		
		$("#holder" + i).append(sorry);	
	}
		
    $('html, body').animate({
          scrollTop: $("#analytics").offset().top
      }, 500);  
}

function tweetHTML(result, i) {	
	var tweet = document.createElement("div");
	$(tweet).addClass('tweet');
	
	var picture = document.createElement("div");
	$(picture).addClass('picture');
	
	var profile = document.createElement("div");
	$(profile).addClass('profile');
	
	var nametime = document.createElement("div");
	$(nametime).addClass('nametime');
	
	var message = document.createElement("div");
	$(message).addClass('message');
	
	var date = document.createElement("div");
	$(date).addClass('date');
	
	var link = $("<a />", {
		href : "http://twitter.com/statuses/" + result[i].id,
		target : "blank"
	});
	
	picture.innerHTML = "<img src=\"" + result[i].user_dp + "\">";
	profile.innerHTML = result[i].user;
	message.innerHTML = result[i].msg;
	
	var d = new Date(result[i].date/1);
	var now = new Date();
	
	if ( now.getHours() - d.getHours() > 0 ) {		
		date.innerHTML += now.getHours() - d.getHours() + " h";	
	} else {
		date.innerHTML += now.getMinutes() - d.getMinutes() + " m";		
	}
	
	date.innerHTML += " ago";		
	
	$(link).append(picture);
	$(link).append(nametime);
	$(link).append(message);
	$(nametime).append(profile);
	$(nametime).append(date);
	$(tweet).append(link);
	
	return tweet;
}

function makeCatButton(i) {

	var categoryButton = document.createElement("div");	
	$(categoryButton).addClass("category-btn");
	
	var colorSample = document.createElement("div");	
	$(colorSample).addClass("color-sample");
		
	switch (i) {
		case 1:
			$(colorSample).addClass("red");			
			break;
		case 2:
			$(colorSample).addClass("blue");		
			break;
		case 3:
			$(colorSample).addClass("green");		
			break;
	}
	
	if ( i > 0 ) {
		$(categoryButton).attr("onclick", "showCategory(" + i + ")");
		(categoryButton).innerHTML += $('.category #tag-' + (i - 1) + " .categ-name").val();
	} else {
		$(categoryButton).attr("onclick", "showCategory(" + 0 + ")");
		(categoryButton).innerHTML += "Unknown";
	}
	$(categoryButton).append(colorSample);
	$("#categoryChooser").append(categoryButton);
}

var eventSource = null;
function getJSON() {
	if (eventSource === null || eventSource.readyState == EventSource.CLOSED) {
		eventSource = new EventSource("index.php?" + $("#form").serialize());
		eventSource.onmessage = function(e) {
			var result = JSON.parse(e.data);	
			showResult(result);
		}
		eventSource.onerror = function(e) {	
			eventSource.close();
		}
	}
}

function cleanResult() {
	var i;
	for ( i = 0; i <= $('.categoryHolder').length; i++ ) {
		$('#holder' + i).remove();
	}
	$('.category-btn').remove();
}

function refreshTags() {
	var i, j;
	for ( i = 0; i < $('.category').length; i++ ) {	
		$('#tag-' + i + ' input#keys').get(0).value = '';
		for ( j = 0; j < $('#tag-' + i + ' .tag').length; j++ ) {
			if ( $('#tag-' + i + ' input#keys').val() != '' ) {
				$('#tag-' + i + ' input#keys').get(0).value += ",";					
			}
			$('#tag-' + i + ' input#keys').get(0).value += $('#tag-' + i + ' span').get(j).innerHTML;
		}			
	}
}

function addCategory(name) {
	if ( $('.category').length <= 2 ) {
		var button = "<button type=\"button\" id=\"delete\">-</button>";
		
		var div = $("<div></div>").addClass("category");
		var div2 = $("<div></div>").addClass("tag-holder");
		div2.attr('id', 'tag-' + $('.category').length);
		var inputfield1 = "<input type=\"text\" class=\"bigger-text categ-name\" placeholder=\"Category\" name=\"name" + $('.category').length + "\">" + button;
		var inputfield2 = "<input type=\"hidden\" id=\"keys\" name=\"keys" + $('.category').length + "\" value=\"\">";
		var span = $("<span></span>").addClass("flexible");
		var inputfield3 = "<input type=\"text\" id=\"adder\" placeholder=\"add key\" class=\"hidden\" value=\"\">"
				
		div2.append(inputfield1);
		div2.append(inputfield2);
		span.append(inputfield3);
		div2.append(span);			
				
		div.append(div2);
		$("#categories").append(div);
		$("#counter").val($('.category').length);
		
		if ( name != "" ) { 
			$("#tag-" + ( $('.category').length - 1 ) + " .categ-name" ).val(name);
		}
	} else {
		alert("Sorry, you only can add up to " + $('.category').length + " categories!");
	}
}

function removeAllCategory() {
	$('.category').remove();
}

function topicClicked(d) {
	var arr = [["Technology", "Computer", "Mobile"],
			   ["Sport","Football","Test001"],
			   ["Travelling","Test002","Test003","Test004"]];		
	var i = 0;
	var n;
	
	while ( arr[i][0] != $("#topic-chooser div").html() ) {
		++i;
	}	
	
	i -= d;
	
	if ( (i+1) >= arr.length ) {
		$("#topic-chooser div").html(arr[0][0]); 
		n = 0;
	} else {		
		$("#topic-chooser div").html(arr[i+1][0]); 
		n = i + 1;
	}		
	
	$('#topic-chooser input').val($("#topic-chooser div").html());
	
	removeAllCategory();
	for ( var j = 1; j < arr[n].length; ++j ) {
		addCategory(arr[n][j]);
	}
}

function deleteCategory(that) {
	var i = 0;
	thet = that;
	while ( $(thet).prev().length > 0) {
		++i;
		
		thet = $(thet).prev();
	}		

	--i;
	saved = that;
	while ( $(that).next().length > 0) {	
		that = $(that).next();
		
		$(that).children(".tag-holder").attr('id', 'tag-' + i);
		($($(that).children())).children(".categ-name").attr('name', 'name' + i);
		($($(that).children())).children("#keys").attr('name', 'keys' + i);
		
		++i;
	}	
	
	$(saved).remove();	
}

$(document).ready(function(){
	topicClicked(1);
	$('#analytics').hide();
	
	$(window).unload(function() {
		if (eventSource != null)
			eventSource.close();
	});
	
	$("#form").submit(function() {
		cleanResult();
		getJSON();
		return false;
	});
	
    $("#addnew").click(function(){ 
		addCategory("");		
    });
	
	$("#customtopic").click(function() {
		if ( $("#topic-chooser div").is(":visible") ) {
			$('#topic-chooser div').hide();		
			$(this).html("Choose from list");
		} else {
			$('#topic-chooser div').show();		
			$(this).html("Customize");	
		}
	});
	
	
	$('#categories').on('focusout','.tag-holder input#adder',function(event){ 
		var txt = this.value.replace(/[^a-zA-Z0-9\+\-\.\#\s]/g,'');
		this.value="";
		txt = $.trim(txt);
		if(txt) {
		  ($(this).parent()).before('<span class="tag">'+ txt.toLowerCase() +'</span>');		  
		  refreshTags();		  
		}
	}).on('keyup','.tag-holder input#adder',function( e ){
		if(/(188|13)/.test(e.which)) {
			$(this).focusout(); 
		}
	});    
	
	$('#categories').on('click','.tag-holder .tag',function(){
		$(this).remove();  
		refreshTags();		  
	});
	
	$('#algorithm div').on('click',function(){
		if ( $(this).html() == "Knuth–Morris–Pratt" ) {
			($(this).next()).removeClass("selected");
			$("input:radio[name=algo]")[0].checked = true;
		} else {
			($(this).prev()).removeClass("selected");	
			$("input:radio[name=algo]")[1].checked = true;	
		}
		$(this).addClass("selected");
	});
		
	$('#topic-chooser div').on('click', function(){
		topicClicked(0);
	});
	
	$('#categories').on('click','.tag-holder #delete', function(){		
		deleteCategory($($(this).parent()).parent());		
		$("#counter").val($('.category').length);

		
		
	});
	
});