
$("#signin").click(function check(e) {
    e.preventDefault();
    $("#error1").html(""); 
    $("#error1").css({'padding':'0', 'border':'0'});
var username =$.trim($("#username").val());

var password = $.trim($("#password").val());
if(username == ""){
$("#error1").html("Bạn chưa điền tên đăng nhập");
$("#error1").css({ 'padding': '12', 'visibility': 'visible;'})
return false;
};

$("#error1").html("");
if(password.length < 5){
$("#error1").html("Mật khẩu tối thiểu 5 ký tự");
$("#error1").css({ 'padding': '12', 'visibility': 'visible;'})
return false;
};
$("#error1").css({ 'padding': '0', 'visibility': 'hidden;'})
$.ajax({
url: '/api/signin',
type: 'POST',
dataType: 'text',
data: {
   
    username: username,
    password: password,
},
success: function(result){
   
   if(result != '0') location.replace('/')
		 else 
		 {
	   $("#error1").html("Sai tên TK hoặc MK"); 
     $("#error1").css({ 'padding': '12', 'visibility': 'visible;'});return false ;}
}
})


});


$("#signup").click(function check(e){
    e.preventDefault();
var username =$.trim($("#username_up").val());
var name =$.trim($("#name").val());
var password = $.trim($("#password_up").val());
var repass =$.trim($("#repass").val());
var capcha =$.trim($("#capcha").val());

$("#error2").html("");
if(username == ""){
	$("#error2").html("Bạn chưa điền tên đăng nhập");
	$("#error2").css({ 'padding': '12', 'visibility': 'visible;'})
	return false;
	};
	$("#error2").html("");
if(username == ""){
	$("#error2").html("Bạn chưa điền tên của bạn");
	$("#error2").css({ 'padding': '12', 'visibility': 'visible;'})
	return false;
	};

$("#error2").html("");
if(password.length < 5){
$("#error2").html("Mật khẩu tối thiểu 5 ký tự");
$("#error2").css({ 'padding': '12', 'visibility': 'visible;'})
return false;

};
if(repass != password){
$("#error2").html("Nhập lại mật khẩu không đúng");
$("#error2").css({ 'padding': '12', 'visibility': 'visible;'})
return false;
};
$("#error2").css({ 'padding': '0', 'visibility': 'hidden;'})
$.ajax({
url: '/api/signup',
type: 'POST',
dataType: 'text',
data: {
	username: username,
	password: password,
	name: name,
},
success: function(result){
	if(result == '0' ) 
	{
		$("#error2").html('Tài khoản đã tồn tại');
		$("#error2").css({ 'padding': '12', 'visibility': 'visible;'})
	}

  else {
	$("#error2").css({ 'padding': '0', 'visibility': 'hidden;'})
		alert('Đăng ký thành công, bây giờ hãy đăng nhập'); }
	
	
}
})


});




