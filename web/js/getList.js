//博客列表的刷新
function getList() {

    $.ajax({
        type: "post",
        url: "list",
        //待：传进来的是三个数据还是对象?
        success: function(data) {
            var obj = eval("(" + data + ")");
            for (var i = 0; i < obj.count; i++) {
                $(".article-list").html("");
                var item = "<div class=\"item\">" +
                    "<div>" +
                    "<a href=\"#\" class=\"title\">" + obj[i].title + "</a>" +
                    "<button class=\"btn btn-danger blog_delete\">" + "删除" + "</button>" +
                    "</div>" +
                    "<div class=\"status\">发布于" + obj[i].time + "|类型：#web开发</div>" +
                    "<div class=\"content\">" + obj[i].message + "</div>" +
                    "</div>";
                $(".article-list").html(item);
            }

        },
        error: function(xhr) {
            alert(xhr.status);
        }
    })
}
getList();