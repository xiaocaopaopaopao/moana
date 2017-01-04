function updown_onmouseover(){
	$("#head_login").css("color","#FFF");
	$("#updown").css("background", "url(images/up.png) no-repeat");
	$("#updown").css("background-position","center");
	$(".m_list").show();
}

function updown_onmouseout(){
	$("#head_login").css("color","#e8e7e7");
	$("#updown").css("background", "url(images/down.png) no-repeat");
	$("#updown").css("background-position","center");
	$(".m_list").hide();
}

function pop_loginBox(){
	$("#cover").show();
	$("#loginBox").show();
}

function close_loginBox(){
	$("#cover").hide();
	$("#loginBox").hide();
}