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
			$('#trecipes').append('<thead><tr><th data-field="id">ID</th><th data-field="name">Name</th><th data-field="desc">Description</th><th data-field="edit">Edit</th><th data-field="del">Delete</th></tr></thead><tbody></tbody>');
		}

		$.each(data, function(key, val){	
			$('#trecipes').append('<tr><td>'+val.key+'</td>'
					+'<td><a href="/recipe/'+val.key+'">'+val.name+'</a></td>'
					+'<td>'+val.description+'</td>'
					+'<td><a href="#" onclick="editRecipe('+val.key+')"><i class="material-icons">edit</i></a></td>'
					+'<td><a href="/recipe/remove/'+val.key+'"><i class="material-icons">delete</i></a></td>'
					+'</tr>');	
		});
	});
}


function editRecipe(id){
	$.getJSON("/recipe/edit/"+id, function(data){
		$.each(data, function(key, val){

			$("label[for='key']").addClass("active");
			$('#key').val(val.key);
			
			$('#hidden-key').val(val.key).removeAttr("disabled");	

			$("label[for='name']").addClass("active");
			$('input[name="name"]').val(val.name);
			
			$("label[for='descr']").addClass("active");
			$('#descr').val(val.description);
			
			$('#submit-btn').text("Update Recipe");
			$('#row-id').removeClass("hide");
		});	
	});
}
