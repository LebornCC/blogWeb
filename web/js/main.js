$(function() {
    var newa = $(".blog");
    var nbtn = $(".btn");
    var articleL = $(".article-list");
    var item = $(".item");
    var title = $("input");
    var text = $("textarea");

    $("body").delegate(".comment", "propertychange input", function() {
        if ($(this).val().length > 0) {
            obtn.prop('disabled', false);
        } else {
            obtn.prop('disabled', true);
        }
    });



    function createEle(obj) {
        var article = $("<div class=\"item\">" +
            "                   <a href=\"per_article.html\" class=\"title\">" + obj.title + "</a>" +
            "                   <div class=\"status\">" + obj.status + "</div>" +
            "                   <div class=\"centent\">" + obj.content + "</div>" +
            "               </div>")
    }

    getPage();

    function getPage() {
        $.ajax({
            type: "get",
            url: "#",
            data: "#",
            success: function(msg) {
                var obj = eval("(" + msg + ")");
                item.html("");
                for (var i = 0; i < obj.count; i++) {
                    var $a = $("<a>" + (i + 1) + "</a>");
                    $a.attr({
                        src: "javascript:;",
                        class: "num"
                    });
                    articleL.append($a);
                    if (i == 0) {
                        $a.addClass("current");
                    }
                }
            },
            error: function(xhr) {
                alert(xhr.status);
            }
        });
    }
    getMsgList(1);

    function getMsgList(number) {
        $.ajax({
            type: "get",
            url: "#",
            data: "#",
            success: function(msg) {
                var list = eval("(" + msg + ")");
                articleL.html("");
                $.each(list, function(key, value) {
                    var $blog = createEle(value);
                    $blog.get(0).obj = value;
                    articleL.append($blog);
                });
            },
            error: function(xhr) {
                alert(xhr.status);
            }
        });
    }
    //监听按钮
    obtn.click(function() {
        var $text = text.val();
        $.ajax({
            type: "get",
            url: "#",
            data: "#",
            success: function(msg) {
                var obj = eval("(" + msg + ")");
                obj.content = $text;
                var $blog = createEle(obj);
                $blog.get(0).obj = obj;
                articleL.prepend($blog);
                text.val("");
                if ($(".item").length >= 6) {
                    getMsgList(1);
                    getPage();
                }
            },
            error: function(xhr) {
                alert("发送失败！");
            }
        })
    })

})