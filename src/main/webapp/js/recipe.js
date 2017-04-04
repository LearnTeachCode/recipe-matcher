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
			var classAttribute = "";
			
			if(!val.enabled) classAttribute = "tr-disabled";
			    
			var value = "<tr class='"+classAttribute+"'><td>"+val.key+"</td>";
			
			/* if makeCall isDefined show the yellow box */
			if(val.isNew==true && typeof makeCall=='function') value = "<tr><td><div class=\"new-div orange\">&nbsp;</div><div>"+val.key+"</div></td>";
			
			value+= '<td><a href="/recipe/'+val.key+'">'+val.name+'</a></td>'
			+'<td>'+val.description+'</td>'
			+'<td><a href="#" onclick="editRecipe('+val.key+')"><i class="material-icons">edit</i></a></td>'
			+'<td><a href="/recipe/remove/'+val.key+'"><i class="material-icons">delete</i></a></td>'
			+'</tr>';
			
			$('#trecipes').append(value);
		});
	}).done(function() {
		setInterval(changeClass, 300);
		
		/* if makeCall isDefined makeAllRecipesOld */
		if(typeof makeCall=='function') makeAllRecipesOld();
	});
}

changeClass = function(){
	[].forEach.call(
	    document.querySelectorAll('.new-div'),
	    
	    function (el) {
	    	el.classList.toggle('orange');
	    	el.classList.toggle('white');
	    }
	);
}

makeAllRecipesOld = function(){
	var rec_id_array = [];
	var newDiv = $('.new-div');
	
	for(var i=0; i<newDiv.length; i++){
		var r_id = newDiv[i].parentElement.lastElementChild.textContent;
		rec_id_array.push(r_id);					
	}
	
	if(rec_id_array.length>0){
		makeCall(rec_id_array);		
	}
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
			
			if(typeof activate=='function'){
				$('#active-div').remove();
				activate(val.enabled);				
				$('select').material_select();
			}	
		});	
	});
}


