
function setMessage(message, error){
	if(message!="") $('#message').text(message);
	if(error!=""){
		$('#message').text(error).css("color", "#e91e63");
		$('#password').addClass("invalid");
		$('#username').addClass("invalid");
	}
}
