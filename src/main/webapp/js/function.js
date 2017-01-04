/**
 * 刷新余票
 */
function refreshPage() {
	var ticketLast = $("#ticket_last");
	$.get("ticket/getNumOfTicket.do", {
		id : "0"
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
		data : {
			"email" : email,
			"password" : password
		},
		success : function(data, status) {
			if(data == "emailIsRegistered")
				alert("该邮箱已经被注册！");
			else if(data == "registerFailed")
				alert("注册失败，请重试！");
			else if(data == "registerSuccess"){
				$(".register_content .emailDiv input").val("");
				$(".register_content .passwordDiv input").val("");
				$(".register_content .repasswordDiv input").val("");
				alert("恭喜您，注册成功！");
				switchDiv();
			}
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
		data : {
			"email" : email,
			"password" : password
		},
		success : function(data, status) {
			if(data == "loginSuccess")
				location.replace(location.href);
			else if(data == "loginFailed")
				alert("登录失败，请重试！");
		}
	});
}

function logout(){
	$.ajax({
		url : "user/logout.do",
		type : "get",
		async : false,
		success : function(data, status) {
			if(data == "logoutSuccess"){
				alert("账号注销成功！");
				location.replace(location.href);
			}
		}
	});
}