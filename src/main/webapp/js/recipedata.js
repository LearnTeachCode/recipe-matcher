function setRecipeData(recipejson){
	var classAttribute = "";
	
	if(!recipejson[0].enabled) classAttribute = "tr-disabled";
	
	$('#trecipedata').append('<thead><tr><th data-field="id">ID</th><th data-field="name">Name</th><th data-field="desc">Description</th></tr></thead><tbody></tbody>');
	
	$('#trecipedata').append('<tr class="'+classAttribute+'"><td>'+recipejson[0].key+'</td>'
			+'<td>'+recipejson[0].name+'</td>'
			+'<td>'+recipejson[0].description+'</td>'
			+'</tr>');	
}


