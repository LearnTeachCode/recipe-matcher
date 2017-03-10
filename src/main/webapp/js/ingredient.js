function getAllIngredients(){
	$.getJSON("all/ingredients", function(data){
		
		if(data.length>0){
			$('#tingredients').append('<thead><tr><th data-field="id">ID</th><th data-field="name">Name</th><th data-field="desc">Description</th><th data-field="edit">Edit</th><th data-field="del">Delete</th></tr></thead><tbody></tbody>');
		}

		$.each(data, function(key, val){	
			$('#tingredients').append('<tr><td>'+val.key+'</td>'
					+'<td>'+val.name+'</td>'
					+'<td>'+val.description+'</td>'
					+'<td><a href="#" onclick="editIng('+val.key+')"><i class="material-icons">edit</i></a></td>'
					+'<td><a href="/manage/ingredient/remove/'+val.key+'"><i class="material-icons">delete</i></a></td>'
					+'</tr>');	
		});
	});
}


function editIng(id){
	$.getJSON("/manage/ingredient/edit/"+id, function(data){
		$.each(data, function(key, val){

			$("label[for='key']").addClass("active");
			$('#key').val(val.key);
			
			$('#hidden-key').val(val.key).removeAttr("disabled");	

			$("label[for='name']").addClass("active");
			$('input[name="name"]').val(val.name);
			
			$("label[for='descr']").addClass("active");
			$('#descr').val(val.description);
			
			$('#submit-btn').text("Update Ingredient");
			$('#row-id').removeClass("hide");
		});	
	});
}
