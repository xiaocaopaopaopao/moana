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
		$("#title_logo_word a").text("登录");
	}else{
		$(".login_content").hide();
		$(".register_content").show();
		$("#title_logo_word a").text("注册");
	}
}
