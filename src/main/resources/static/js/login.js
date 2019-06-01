var username = document.getElementsByTagName("input")[0];
var password = document.getElementsByTagName("input")[1];
console.log(username)
var reg=/^(?![0-9]+$)(?![a-zA-Z]+$)[A-Za-z_][A-Za-z_0-9]{5,16}$/
//用户框失去焦点后验证value值
function oBlur_1() {
    if (username.value == "") { //用户框value值为空
        document.getElementById("remind_1").innerHTML = "请输入用户名！";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
    }
    else { //用户框value值不为空
        document.getElementById("remind_1").innerHTML = "";
        document.getElementById("change_margin_1").style.marginBottom = 19 + "px";
    }
}

//密码框失去焦点后验证value值
function oBlur_2() {
    if (password.value == "") { //密码框value值为空
        document.getElementById("remind_2").innerHTML = "请输入密码！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
    } else { //密码框value值不为空
        document.getElementById("remind_2").innerHTML = "";
        document.getElementById("change_margin_2").style.marginBottom = 19 + "px";
        document.getElementById("change_margin_3").style.marginTop = 19 + "px";
    }
}
function oBlur_3(val) {
    var confirm_number=  $('#confirm_number')[0].innerText.toUpperCase()
    if (val == "") { //验证码框value值为空
        document.getElementById("remind_2").innerHTML = "请输入验证码！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
        return false
    } else if(confirm_number!=val.toUpperCase()){
        document.getElementById("remind_2").innerHTML = "验证码错误，请重新输入！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
        return false
    }else { //验证码框value值不为空
        document.getElementById("remind_2").innerHTML = "";
        document.getElementById("change_margin_2").style.marginBottom = 19 + "px";
        document.getElementById("change_margin_3").style.marginTop = 19 + "px";
        return true
    }
}
function oBlur_4(val) {
    if(val==""){
        document.getElementById("remind_4").innerHTML = "请输入新密码！";
        document.getElementById("change_margin_4").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_5").style.marginTop = 2 + "px";
    }
}
function oBlur_5(val) {
    var password_number1Value=$('#password_number').val()
    if(val==""){
        document.getElementById("remind_5").innerHTML = "请确认新密码！";
        document.getElementById("change_margin_5").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_6").style.marginTop = 2 + "px";
    }else if(val!=password_number1Value){
        document.getElementById("remind_5").innerHTML = "两次密码不一致，请重新输入！";
        document.getElementById("change_margin_5").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_6").style.marginTop = 2 + "px";
    }
}
//用户框获得焦点的隐藏提醒
function oFocus_1() {
    document.getElementById("remind_1").innerHTML = "";
    document.getElementById("change_margin_1").style.marginBottom = 19 + "px";
}

//密码框获得焦点的隐藏提醒
function oFocus_2() {
    document.getElementById("remind_2").innerHTML = "";
    document.getElementById("change_margin_2").style.marginBottom = 19 + "px";
    document.getElementById("change_margin_3").style.marginTop = 19 + "px";
}
function oFocus_4() {
    document.getElementById("remind_4").innerHTML = "";
    document.getElementById("change_margin_4").style.marginBottom = 19 + "px";
    document.getElementById("change_margin_5").style.marginTop = 19 + "px";
}
function oFocus_5() {
    document.getElementById("remind_5").innerHTML = "";
    document.getElementById("change_margin_5").style.marginBottom = 19 + "px";
    document.getElementById("change_margin_6").style.marginTop = 19 + "px";
}

function checkAmount2() {
    var usernameValue = username.value
    var passwordVlaue = password.value
    if (usernameValue == "" && passwordVlaue == "") { //用户框value值和密码框value值都为空
        document.getElementById("remind_1").innerHTML = "请输入用户名！";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
        document.getElementById("remind_2").innerHTML = "请输入密码！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
        return false; //只有返回true表单才会提交
    } else if (usernameValue == "") { //用户框value值为空
        document.getElementById("remind_1").innerHTML = "请输入用户名！";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
        return false;
    } else if (passwordVlaue == "") { //密码框value值为空
        document.getElementById("remind_2").innerHTML = "请输入密码！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
        return false;
    }else if(!reg.test(usernameValue)){
        document.getElementById("remind_1").innerHTML = "数字，字母和下划线（至少包含其中两种，数字不能开头，长度为6-16位）";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
        return false;
    }
    else if(!reg.test(passwordVlaue)){
        document.getElementById("remind_2").innerHTML = "数字，字母和下划线（至少包含其中两种，数字不能开头，长度为6-16位）";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        return false;
    }
    return true;
}

function checkAmount(route) {
    var usernameValue = username.value
    var passwordVlaue = password.value
    if (usernameValue == "" && passwordVlaue == "") { //用户框value值和密码框value值都为空
        document.getElementById("remind_1").innerHTML = "请输入用户名！";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
        document.getElementById("remind_2").innerHTML = "请输入密码！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
        return false; //只有返回true表单才会提交
    } else if (usernameValue == "") { //用户框value值为空
        document.getElementById("remind_1").innerHTML = "请输入用户名！";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
        return false;
    } else if (passwordVlaue == "") { //密码框value值为空
        document.getElementById("remind_2").innerHTML = "请输入密码！";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
        document.getElementById("change_margin_3").style.marginTop = 2 + "px";
        return false;
    }else if(!reg.test(usernameValue)){
        document.getElementById("remind_1").innerHTML = "数字，字母和下划线（至少包含其中两种，数字不能开头，长度为6-16位）";
        document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
    }
    else if(!reg.test(passwordVlaue)){
        document.getElementById("remind_2").innerHTML = "数字，字母和下划线（至少包含其中两种，数字不能开头，长度为6-16位）";
        document.getElementById("change_margin_2").style.marginBottom = 1 + "px";
    }
    else {
        var data='username='+usernameValue+'&&userpwd='+passwordVlaue
        console.log(data)
        $.ajax({
            //几个参数需要注意一下
            type: "POST",//方法类型
            
            url: route ,//url
            data: data,
            success: function (reslut) {
                if (reslut=='1') {
                	
                	window.location.href = "/WebCar/userInfo/user_index";
                }if(reslut=='0'){
                	alert("账号密码错误");
                	 var usernameValue = username.value="";
                	    var passwordVlaue = password.value="000";
                };
            },
            error : function() {
                alert("异常！");
            }
        });
    }
}
//生成验证码
function Produce(data) {
    var str="";
    for(var i=0;i<data;i++){
        var c=Math.floor(Math.random()*3);
        if(c==0){
            //数字转换为大写字母
            var a=String.fromCharCode(Math.random()*26+65);
            str=str+a;
        }
        if(c==1){
            //数字转换为小写字母
            var a=String.fromCharCode(Math.random()*26+97);
            str=str+a;
        }
        if(c==2){
            var a=Math.floor(Math.random()*10);
            str=str+a;
        }
    }
    return str
}
function confirmNumber() {
    $('#confirm_number')[0].innerText = Produce(4);
    // console.log($('#confirm_number')[0].innerText.toUpperCase())
    // console.log($('#test')[0].value.toUpperCase())
}
//验证有无这个账号，才能重新找回密码
function Next_step(route) {
    var val=$('#test').val()
    var usernameF=$('#username').val();
     if(usernameF == "") { //用户框value值为空
         document.getElementById("remind_1").innerHTML = "请输入用户名！";
         document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
     } else if(!reg.test(usernameF)) {
         document.getElementById("remind_1").innerHTML = "数字，字母和下划线（至少包含其中两种，数字不能开头，长度为6-16位）";
         document.getElementById("change_margin_1").style.marginBottom = 1 + "px";
     }
     else if(!oBlur_3(val)) {
    	 
     }
     else {    
    	 $('#Next_stup').attr('data-target','#myModal') 
         var data='username='+usernameF
         $.ajax({
             //几个参数需要注意一下
             type: "POST",//方法类型
             dataType: "json",//预期服务器返回的数据类型
             url: route ,//url
             data: data,
             success: function (reslut) {             
                 if (reslut==1) {         	 
                      $('#Retrieve_password').val('确认')
                      $('#Next_stup').val('下一步')
                      $('#confirm_number')[0].innerText = Produce(4);
                      $('#test').val('');
                 }
                 else{
                	 alert("不存在该账户")
                 };
             },
             error : function() {
                 alert("异常！");
             }
         });
     }
}
//
function send_number() {
    var email=$('#email').val();
    var data='useremail='+email;
    var inputEmail=$('#inputEmail').val()
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
//        dataType: "json",//预期服务器返回的数据类型
        url: '/WebCar/userInfo/email' ,//url
        data: data,
        success: function (reslut) {
//            var code=JSON.parse(reslut)
            console.log(reslut);//打印服务端返回的数据(调试用)
            if(reslut!=0){
                // window.location.href = "http://localhost:8088/index";
            }
            else{
            	alert("不存在该邮箱")
            };
        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
            alert("异常！");
            alert(XMLHttpRequest.status); 
         　　                alert(XMLHttpRequest.readyState); 
         　              alert(textStatus);        
        }
    });
}
//确定
function determine() {

    var inputEmail=$('#inputEmail').val()
    var data = 'inputEmail='+inputEmail
    $.ajax({
    	type: "POST",//方法类型
       // dataType: "json",//预期服务器返回的数据类型
        url: '/WebCar/userInfo/email2' ,//url
        data: data,
        success: function (reslut) {
        	if(reslut==1){
        		 $('#numberone').css('display','none');
        	     $('#numbertwo').css('display','block');
        	 	 $("#myModal").modal("hide");
        	 	 $('.close').click();
        	}else {
        		alert('服務異常')
        	}
        }
    })
}
$(function () {
    var btn = $("#confirm_btn");
    $(function() {
        btn.click(settime);
    })
    var countdown = 60;//倒计时总时间，为了演示效果，设为5秒，一般都是60s
    function settime() {
        if (countdown == 0) {
            btn.attr("disabled", false);
            btn.html("获取验证码");
            btn.removeClass("disabled");
            countdown = 60;
            return;
        } else {
            btn.addClass("disabled");
            btn.attr("disabled", true);
            btn.html("重新发送(" + countdown + ")");
            countdown--;
        }
        setTimeout(settime, 1000);
    }
})
//确认找回密码
function Retrieve_password() {

    var password_number=$('#password_number').val();
    var data=''
    $.ajax({
        //几个参数需要注意一下
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: '/users/updateUser' ,//url
        data: data,
        success: function (reslut) {
            var code=JSON.parse(reslut)
            console.log(code);//打印服务端返回的数据(调试用)
            if (code==inputEmail) {
                // window.location.href = "http://localhost:8088/index";
            }
        },
        error : function() {
            alert("异常！");
        }
    });
}