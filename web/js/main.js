function showResult(result) {
	var i;		
	for ( i = 0; i <= $('.category').length; i++ ) {
		var categoryHolder = document.createElement("div");		
		$(categoryHolder).attr('id', 'holder' + i);
		$(categoryHolder).addClass("categoryHolder");
		$("body").append(categoryHolder);
	}
	
	for ( i = 0; i < result.length; i++ ) {
		var prevDiv = document.createElement("div");
		prevDiv.innerHTML = "<a href=\"http://twitter.com/statuses/" + result[i].id + "\" target=\"blank\"><img src=\"" + result[i].user_dp + "\" style=\"width:50px\">" + result[i].user + "<br>" + result[i].msg + "<br>" + result[i].date + "</a><br><br>";
		$(prevDiv).addClass('result');

		if ( result[i].category > 0 ) {		
			$("#holder" + result[i].category).append(prevDiv);
		} else {	
			$("#holder0").append(prevDiv);		
		}
	}
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

$(document).ready(function(){
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
		if ( $('.category').length <= 2 ) {
			var div = $("<div></div>").addClass("category");
			var div2 = $("<div></div>").addClass("tag-holder");
			div2.attr('id', 'tag-' + $('.category').length);
			var inputfield1 = "<input type=\"text\" class=\"bigger-text categ-name\" placeholder=\"Category\" name=\"name" + $('.category').length + "\">";
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
		} else {
			alert("Sorry, you only can add up to " + $('.category').length + " categories!");
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
	
});