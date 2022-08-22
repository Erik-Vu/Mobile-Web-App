var i = 0;
var show = document.getElementById("show-body");
var login = document.getElementById("login-box");
var register = document.getElementById("register");


function getLogin(){
 if (i % 2 == 0) {
    show.style.opacity = 0.3;
    login.style.visibility = "visible";
 } 
 else {
    show.style.opacity = 1.0;
    login.style.visibility = "hidden";
	}
 i++;
}

function getRegister(){
 if (i % 2 == 0) {
    show.style.opacity = 0.3;	
    register.style.visibility = "visible";
 } 
 else {
    show.style.opacity = 1.0;
    register.style.visibility = "hidden";
	}
 i++;
}

function getCart(){
	location.replace("cart.jsp");
}

function getMobile(id) {
	$.ajax({
        url : "/PRJ321x-A3/cart",
        type : "post",
        dataType:"text",
        data : {
        id : id,
        action : "add" 
         },
         success : function (data){
		alert(data);
         }
     });
}

function deleteMobile(id) {
	$.ajax({
        url : "/PRJ321x-A3/cart",
        type : "post",
        dataType:"text",
        data : {
        id : id,
        action : "delete" 
         },
         success : function (data){
			if (data == 1) location.replace("cart.jsp");
         }
     });
}

function checkLogin(data) {
	if (data == 13) alert("username or password is invalid syntax!");
	if (data == 3) alert("username or password is wrong!");
	if (data == 2) location.replace("admin/index.jsp");
	if (data.includes("Welcome")) {
		var welcome = document.getElementById("welcome");
	    welcome.innerHTML = data;
		getLogin();
	}
	if (data == 4) {
		alert("Successfully");
		getRegister();
	}
}

function send_login(){
    $.ajax({
        url : "/PRJ321x-A3/Login",
        type : "post",
        dataType:"text",
        data : {
        user : $('#user').val(),
        pass : $('#pass').val()
         },
         success : function (data){
         checkLogin(data);
         }
     });
   }
   
 function send_register(){
    $.ajax({
        url : "/PRJ321x-A3/Register",
        type : "post",
        dataType:"text",
        data : {
        user : $('#username').val(),
        pass : $('#password').val(),
        repass: $('#re-password').val()
         },
         success : function (data){
         checkLogin(data);
         }
     });
   }
   
 function send_order(){
	$.ajax({
        url : "/PRJ321x-A3/order",
        type : "post",
        dataType:"text",
        data : {
        cname : $('#cName').val(),
        cphone : $('#cPhone').val(),
        caddress: $('#cAddress').val()
         },
         success : function (data){
         alert(data);
         }
     });
}

function loadPage(page){
	$.ajax({
        url : "/PRJ321x-A3/page",
        type : "post",
        dataType:"text",
        data : {
        page : page 
         },
         success : function (data){
         var row = document.getElementById("content");
         row.innerHTML = data;
         }
     });
}  
   
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
    }
    return "";
}

function writeCookie() {
	if (document.getElementById("cb").checked){
		var username = getCookie("user");
		var password = getCookie("pass");
		$("input:text").val(username);
		$("input:password").val(password);
	}
	else {
		$("input:text").val("");
		$("input:password").val("");
	}
} 

function search() {
	$.ajax({
        url : "/PRJ321x-A3/search",
        type : "post",
        dataType:"text",
        data : {
        search : $('#myInput').val()
         },
         success : function (data){
         var row = document.getElementById("content");
         row.innerHTML = data;
         }
     });
}  