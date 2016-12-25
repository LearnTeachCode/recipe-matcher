/*
function getAllRecipes(){
	$.getJSON("/recipe/", function(data){
		$.each(data, function(key, val){
			
			$("ol").append("<li>" + val.name + "</li>");
			
		});
	});
}
*/

function getAllRecipes(){
	$.getJSON("/recipe/all", function(data){
		
		if(data.length>0){
			$('#trecipes').append('<tr><th width="80">ID</th><th width="120">Name</th><th width="120">Description</th><th width="60">Edit</th><th width="60"></th></tr>');
		}

		$.each(data, function(key, val){	
			$('#trecipes').append('<tr><td>'+val.key+'</td>'
					+'<td><a href="/recipe/'+val.key+'">'+val.name+'</a></td>'
					+'<td>'+val.description+'</td>'
					+'<td><a href="#" onclick="editRecipe('+val.key+')">Edit</a></td>'
					+'<td><a href="/recipe/remove/'+val.key+'">Delete</a></td>'
					+'</tr>');	
		});
	});
}


function editRecipe(id){
	$.getJSON("/recipe/edit/"+id, function(data){
		$.each(data, function(key, val){
			$('#key').val(val.key);
			$('#hidden-key').val(val.key).removeAttr("disabled");	
			$('input[name="name"]').val(val.name);
			$('#descr').val(val.description);
			
			$('#submit-btn').val("Update Recipe");
			$('#row-id').show();
		});	
	});
}
