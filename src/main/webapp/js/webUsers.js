
function getAllWebUsers(securityRoles){
	/* getting all webUsers */
	$.getJSON("all/webUsers", function(data){
		if(data.length>0){
			$('#twebusers').append('<thead><tr><th data-field="id">ID</th><th data-field="username">Username</th><th data-field="fname">First Name</th><th data-field="lname">Last Name</th><th data-field="role">Role</th></tr></thead><tbody></tbody>');
		}
		
		$.each(data, function(key, val){	
			$('#twebusers').append('<tr><td>'+val.id+'</td>'
					+'<td>'+val.username+'</td>'
					+'<td contenteditable="true" onBlur="saveField(this,\'FirstName\', '+val.id+')" onClick="showEdit(this);"><span class="editable">'+val.firstName+'</span></td>'
					+'<td contenteditable="true" onBlur="saveField(this,\'LastName\', '+val.id+')" onClick="showEdit(this);"><span class="editable">'+val.lastName+'</span></td>'
					+'<td><select onChange="saveToDatabase(this.value,\'SecurityRoleType\', '+val.id+')" class="select-role"><option>'+val.securityRoleType+'</option></select></td>'
					+'</tr>');	
		});
	}).done(function() {
		/* adding securityRole options if doesn't exist */
		$('.select-role').each(function(i, obj) {
			var currentSel = $(this);

			$.each(securityRoles[0], function(key, val){
				if(currentSel.val()!==val){
					currentSel.append($("<option></option>").text(val)); 
				}
			});
		});
	});
}

// field focus
function showEdit(editableObj) {
	$(editableObj).css("background","#FFF");
	$(editableObj).children().removeClass("editable");
} 


function saveField(editableObj, column, id) {
	var parentRowColor = $(editableObj).closest("tr").css("backgroundColor");
	var editVal = $(editableObj).children().text();
	
	/* if the value is empty putting the value into span */
	if(editVal==""){
		editVal = $(editableObj).text();
		$(editableObj).text("");
		editableObj.innerHTML = "<span class='editable'>"+editVal+"</span>";
	}
	
	$(editableObj).css("background","#FFF url(../../images/loaderIcon.gif) no-repeat right");
	
	/* saving the value */
	saveToDatabase(editVal, column, id);
	
    $(editableObj).css("background", parentRowColor);
    $(editableObj).children().addClass("editable");
}

// ajax call
function saveToDatabase(editVal, column, id){
	$.ajax({
		url: "/manage/user/edit",
		type: "POST",
		data:'column='+column+'&editval='+editVal+'&id='+id,
		success: function(data){
			
		}        
   });
}
