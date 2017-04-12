
function getRecipesIngs(){
	// loading all recipes
	$.getJSON("/recipe/all", function(data){
		if(data.length>0){
			$('#trecipes').append('<thead><tr><th data-field="id">ID</th><th data-field="name">Name</th><tbody></tbody>');
		}
		
		$.each(data, function(key, val){	
			// filling recipes-ingredients map
			recIngsMap[val.key] = val.ingredients;
			
			$('#trecipes').append('<tr class="pointer" onClick="rowClicked(this);"><td>'+val.key+'</td>'
					+'<td>'+val.name+'</td>'
					+'</tr>');	
		});
	}).done(function() {
		$('#trecipes').dataTable({
			"pageLength": 7,
			"sort": false,
	        "searching": false
	    });
		
		$(".dataTables_info, .dataTables_length").remove();
	});
	
	// loading all ingredients
	$.getJSON("/manage/all/ingredients", function(data){
		$.each(data, function (key, val) {
			// filling ingredients map
			ingsMap[val.key] = data[key];
			
			option = '<option data-id=' + val.key + '>' + val.name + '</option>';
            $('.pickData').append(option);
        });
	});
}

// On recipe row click
function rowClicked(row){
	/* highlighting selected recipe row */
	$("tr.selected").removeClass("selected");
	row.classList.add("selected");
	
	var recipeID = row.firstElementChild.textContent;
	var recipe_ings = recIngsMap[recipeID];

	/* setting selected recipe id */
	$("#recipe-id").val(recipeID);
	$(".input-sumbit").show();
	
	/* empty selected options */
	$(".pRemoveAll").click();

	/* looping through recipe_ings map and making ingredients selected */
	$.each(recipe_ings, function (i, val) {
		$("option[data-id='"+val.key+"']").prop('selected', true);
		$(".pAdd").click();
	});
	
	$("option").prop('selected', false);
}


$("#submit-btn").click( function(){
	var recipe_id = $('#recipe-id').val();
	var newIngsIdArray = new Array();
	var newIngsArray = new Array();
	
	/* getting and adding new ingredients ids to array */
	$.each(pick.getValues(), function (i, val) {
		newIngsIdArray.push(val.id);
		newIngsArray.push(ingsMap[val.id]);
	});
	
	/* ajax call with recipe_id & new ingredients id array */
	$.post("/manage/recipe-ingredients", {
		'recipe_id'    : recipe_id,
		'ingredients'  : JSON.stringify(newIngsIdArray)
	}, function(data) {		
		if(data=="1"){
			/* Updating recipe_ings map for selected recipe with new values */
			recIngsMap[recipe_id] = newIngsArray;
			
			alert("Ingredients updated successfully.");
		} else {
			alert("Ooops! It looks like something went wrong.");
		}
	});
});
