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
	
		if ( $('.category').length <= 4 ) {
			var div = $("<div></div>").addClass("category");
			var text = "Category";
			var inputfield1 = "<input type=\"text\" name=\"name" + $('.category').length + "\">";
			var inputfield2 = "<input type=\"text\" name=\"keys" + $('.category').length + "\">";
			div.append(text);
			div.append(inputfield1);
			div.append(inputfield2);
			
			$("#categories").append(div);
			$("#counter").val($('.category').length);
		} else {
			alert("Sorry, you only can add up to 5 categories!");
		}
		
    });
});