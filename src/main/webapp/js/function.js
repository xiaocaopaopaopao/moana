/**
 * 刷新余票
 */
function refreshPage() {
	var ticketLast = $("#ticket_last");
	$.get("ticket/getTicketNum.do", {
		tid : "4028821f5962c187015962c1bb0d0000"
	}, function(data, status) {
		ticketLast.text(data);
	});
}

/**
 * 注册用户
 */
function registerUser() {
	var email = $(".register_content .emailDiv input").val();
	var password = $(".register_content .passwordDiv input").val();
	var repassword = $(".register_content .repasswordDiv input").val();
	if(!validateEmail(email)){
		alert("邮箱格式不正确！");
		return;
	}else if (password != repassword) {
		alert("两次输入的密码不同！");
		return;
	}else if(!validatePassword(password)){
		alert("密码的长度必须介于6跟12之间");
		return;
	}
	$.ajax({
		url : "user/register.do",
		type : "post",
		async : false,
		dataType:"json",
		data : {
			"email" : email,
			"password" : password
		},
		success : function(data, status) {
			if(data.code == "101"){
				$(".register_content .emailDiv input").val("");
				$(".register_content .passwordDiv input").val("");
				$(".register_content .repasswordDiv input").val("");
				alert("恭喜您," + data.message);
				switchDiv();
			}else
				alert("很遗憾," + data.message);
		}
	});
}

/**
 * 验证email合法性
 * @param email
 * @returns {Boolean}
 */
function validateEmail(email) {
	var reg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	return reg.test(email);
}

/**
 * 验证密码合法性
 * @param password
 * @returns {Boolean}
 */
function validatePassword(password) {
	return !(password.length<6 || password.length>12)
}

/**
 * 登录
 */
function login(){
	var email = $(".login_content .usernameDiv input").val();
	var password = $(".login_content .passwordDiv input").val();
	$.ajax({
		url : "user/login.do",
		type : "post",
		async : false,
		dataType:"json",
		data : {
			"email" : email,
			"password" : password
		},
		success : function(data, status) {
			if(data.code == "201")
				location.replace(location.href);
			else
				alert("很遗憾," + data.message);
		}
	});
}

/**
 * 注销登出
 */
function logout(){
	$.ajax({
		url : "user/logout.do",
		type : "get",
		dataType:"json",
		async : false,
		success : function(data, status) {
			if(data.code == "301"){
				alert("恭喜您," + data.message);
				location.replace(location.href);
			}else
				alert("很遗憾," + data.message);
		}
	});
}

/**
 * 购票
 */
function purchaseTicket(){
	var num = $("#ticketSelected").val();
	$.ajax({
		url : "ticket/purchaseTicket.do",
		type : "get",
		async : false,
		dataType:"json",
		data : {
			"tid": "4028821f5962c187015962c1bb0d0000",
			"num" : num
		},
		success : function(data, status) {
			if(data.code == "101")
				alert("恭喜您," + data.message);
			else
				alert("很遗憾," + data.message);
		}
	});
}