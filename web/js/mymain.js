//注册状态
$("#login1").on("click", function(e) {
    var name = $("#userId").val();
    var pwd = $("#userPwd").val();
    if (name == "" | name == null) {
        alert("账号不能为空")
        console.log("aaaa")
    } else if (pwd == "" | pwd == null) {
        alert("密码不能为空")
    } else {
        $.ajax({
            url: "http://localhost:8080/login2",
            type: "post",
            data: {
                "userId": $("#userId").val(),
                "userPwd": $("#userPwd").val()
            },
            dataType: "json",
            success: function(data) {
                var obj = eval("(" + data + ")");
                if (obj.code == 1) {
                    alert("注册成功，请登录")
                } else {
                    alert("注册失败，请注意账号密码格式问题");
                }
            },
            error: function(xhr) {
                alert("服务器出现问题");
            }

        })
    }

})


//登陆状态
$("#login2").on("click", function(e) {
    var name = $("#userId").val();
    var pwd = $("#userPwd").val();
    if (name == "" | name == null) {
        alert("账号不能为空")
    } else if (pwd == "" | pwd == null) {
        alert("密码不能为空")
    } else {
        $.ajax({
            url: "login2",
            type: "GET",
            data: {
                "userId": name,
                "userPwd": pwd
            },
            dataType: "json",
            async:true,
            success: function(data) {
                var obj = data;
                if (obj.code == 1) {
                     window.location.href = "http://localhost:8080/article.html";
                } else {
                    alert("账号或密码错误");
                }
            },
            error: function(xhr) {
                alert(xhr.status)
            }

        })
    }
    return false;
})

//博客添加
$("#blog_submit").on("click", function(e) {
    var title = $("#title").val();
    var content = $("#content").val();
    if (title == "" | title == null) {
        alert("标题不能为空")
    } else if (content == "" | content == null) {
        alert("内容不能为空")
    } else {
        $.ajax({
            url: "submit",
            type: "post",
            data: {
                "title": $("#title").val(),
                "content": $("#content").val()
            },
            dataType: "json",
            success: function(data) {
                var obj = eval("(" + data + ")");
                window.location.href = "article.html";

            },
            error: function(xhr) {
                alert("服务器出现问题");
            }

        })
    }

})

//博客删除

$("#blog_delete").on("click", function(e) {
    $.ajax({
        url: "delete",
        type: "post",
        data: {
            "title": $("#title").val(),
            "content": $("#content").val()
        },
        success: function(data) {
            var obj = eval("(" + data + ")");
            window.location.href = "article.html";

        },
        error: function(xhr) {
            alert("xhr.status");
        }

    })
})