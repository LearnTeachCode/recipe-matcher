function getAllRecipes(){
	$.getJSON("/recipe/", function(data){
		$.each(data, function(key, val){
			
			$("ol").append("<li>" + val.name + "</li>");
			
		});
	});
}