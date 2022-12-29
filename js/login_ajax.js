//@ sourceURL=login_ajax.js
var dest;
$(function() {
    let url = window.location.href;
    // let searcher = new URLSearchParams(url);
    // console.log(url);
    // let mode = searcher.get('mode');
    // console.log(mode);
    let res = url.match(/mode=(\d+)/);
    if (res == null) { //前端登录
        dest = "index.html";
        $('#mtitle').html('欢迎登录EasyMall');
    } else { //后台
        dest = "manage.html";
        $('#mtitle').html('欢迎登录EasyMall后台');
    }

    //给form表单添加submit事件
    $("form").submit(function() {
        return login();
    });

});

function login() {
    //获取页面数据
    var userName = $("form input[name=username]").val();
    var userPassword = $("form input[name=password]").val();
    if (userName == "") {
        $("form table tr:eq(0) td span").html("用户名不能为空");
        return false;
    }
    if (userPassword == "") {
        $("form table tr:eq(1) td span").html("密码不能为空");
        return false;
    }

    $.ajax({
        url: "http://www.easymall.com/user/login",
        type: "get",
        data: { "userName": userName, "userPassword": userPassword },
        dataType: "json",
        success: function(result) {
            //result是服务端返回的数据
            if (result.status == 200) {
                //window.location.href="index.html";
                window.location.href = dest;
            } else {
                alert("登录失败");
            }
        },
        error: function() {
            alert("请求失败!");
        }
    });

    return false;
}