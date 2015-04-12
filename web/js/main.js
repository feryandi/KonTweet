$(document).ready(function(){
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