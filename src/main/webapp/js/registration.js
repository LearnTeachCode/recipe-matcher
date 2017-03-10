
function setValues(errorJson){
	if(typeof errorJson != 'undefined'){
		for(var i = 0; i < errorJson[0].length; i++) { 
			
			// filling validation errors by fields
			if($('#'+errorJson[0][i].field+'-error').text()==""){
				$('#'+errorJson[0][i].field+'-error').text(errorJson[0][i].defaultMessage);
				$("input[name='"+errorJson[0][i].field+"']").addClass("invalid");
				
				if(errorJson[0][i].field=="username")
					$("input[name='username']").val(errorJson[0][i].rejectedValue);
			}
		}
	}
}
