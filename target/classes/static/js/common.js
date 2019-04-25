
/*
 * 手机号正则表达式
 */
function isPhoneNo(phone) {
    var pattern = /^1[34578]\d{9}$/;
    return pattern.test(phone);
}
/*
 * 邮箱正则表达式
 */
function isEmailNo(email) {
    var pattern = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
    return pattern.test(email);
}

/*
 * 验证手机号
 */
function checkPhone() {
    if ($.trim($('#telephone').val()).length == 0) {
        $('#telephoneError').html('手机号码没有输入');
        return false;
    } else {
        $('#telephoneError').html('');
        if (isPhoneNo($('#telephone').val()) == false) {
            $('#telephoneError').html('手机号码不正确');
            return false;
        } else {
            return true;
        }
    }
}
/*
 * 验证密码
 */
function checkPassword() {
    if ($.trim($('#password').val()).length == 0) {
        $('#passwordError').html('密码没有输入');
        return false;
    } else {
        $('#passwordError').html('');
        var rePass = $.trim($('#rePassword').val());
        var pass = $.trim($('#password').val());
        if (rePass.length != 0) {
            if (rePass != pass) {
                $('#rePasswordError').html('两次密码不一致');
                return false;
            } else {
                $('#rePasswordError').html('');
                return true;
            }
        }
    }
}
/*
 * 重复密码
 */
function checkrePassword() {
    var rePass = $.trim($('#rePassword').val());
    if (rePass.length == 0) {
        $('#rePasswordError').html('密码没有输入');
        return false;
    } else {
        $('#rePasswordError').html('');
        var pass = $.trim($('#password').val());
        if (pass.length == 0) {
            $('#rePassword').val('');
            $('#passwordError').html('密码没有输入');
            return false;
        } else if (rePass != pass) {
            $('#rePasswordError').html('两次密码不一致');
            return false;
        } else {
            $('#rePasswordError').html('');
            return true;
        }
    }
}
/*
 * 验证邮箱
 */
function checkEmail() {
    if ($.trim($('#email').val()).length == 0) {
        $('#emailError').html('邮箱没有输入');
        // $('#email').focus();
        return false;
    } else {
        $('#emailError').html('');
        if (isEmailNo($('#email').val()) == false) {
            $('#emailError').html('邮箱格式不正确');
            // $('#email').focus();
            return false;
        } else {
            $('#emailError').html('');
            return true;
        }
    }
}
/*
 * 注册表单提交时验证
 */
function checkRegister() {
    if (checkPhone()&&checkPassword()&&checkrePassword()&&checkEmail() ) {
        console.log(111111111)
    }else{
        console.log(213213)
    }
}