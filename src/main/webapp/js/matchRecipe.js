
$(document).ready(function () {
	$('.addel').addel({
        events: {
            added: function (event) {
            	updateIngLabels();
            }
        }
    }).on('addel:deleted', function (event) {
    	updateIngLabels();
    });
});

updateIngLabels = function(){
	var labels = $('.new-ing-label');
	
	for(var i = 0; i < labels.length; i++){
		labels[i].textContent = "Ingredient "+(i+1);
	}
}

function setRecipesData(matchedList){	
	if(matchedList!="") {
		$('#trecipedata').append('<thead><tr><th data-field="name">Name</th><th data-field="ingredients">Ingredients</th><th data-field="desc">Description</th></tr></thead><tbody></tbody>');
		
		$.each(matchedList, function(key, val){	
			var ings = "";

			for(var i=0; i<val.ingredients.length; i++){
				ings+= val.ingredients[i].name+",  ";
			}

			$('#trecipedata').append('<tr><td>'+val.name+'</td>'
					+'<td>'+ings.substring(0, ings.length-3)+'</td>'
					+'<td>'+val.description+'</td>'
					+'</tr>');	
		});
	} else {
		if(jQuery.isArray(matchedList)) $("#div-no-matches").show();
	}
}

function toLowerCase(){
	$('input[type=text]').each(function(){
        this.value = this.value.toLowerCase();          
    });
	
	return true;
}


