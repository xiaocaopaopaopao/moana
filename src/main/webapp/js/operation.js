function pop_loginBox(){
	$("#cover").show();
	$("#loginBox").show();
}

function close_loginBox(){
	$("#cover").hide();
	$("#loginBox").hide();
}

function switchDiv(){
	var display =$(".login_content").css("display");
	if(display == "none"){
		$(".login_content").show();
		$(".register_content").hide();
	}else{
		$(".login_content").hide();
		$(".register_content").show();
	}
}
