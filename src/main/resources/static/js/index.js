$(function () {
    // 下拉菜单开始
    $('.dropdown').mouseover(function (e) {
        $(this).css("border", "1px solid #f8f8f8");
        $('.aa').css("display", "block");
    });
    $('.dropdown').mouseout(function (e) {
        $('.aa').css("display", "none");
        $(this).css("border", "none");
    })
    // 下拉菜单结束
    // 轮播图开始
    var a;
    // 轮播图控制时间
    $('#lunbo').carousel({interval: 2000});
    $('.li').mouseover(function (e) {
        // 对应圆点控制
        $(this).addClass("active");
        $(this).siblings().removeClass("active");
        a = $(this).attr("data-slide-to");
        // 轮播图背景图片更换
        $("#lunbotu div").eq(a).addClass("active");
        $("#lunbotu div").eq(a).siblings().removeClass("active")
    });
    //鼠标移上去继续轮播
    $('#lunbo').mouseover(function (e) {
        $('#lunbo').carousel({interval: 2000});
    })
    // 轮播图结束
    //列表兰
    // var index=0;
    // $('.list  li').mouseover(function (e) {
    //     if ($(this) == $('.list  li').eq(0)) {
    //         $(this).siblings().attr('background', '#ff6402')
    //     } else {
    //         $(this).addClass('list-active')
    //         $(this).siblings().removeClass('list-active')
    //     }
    //     // $('.list  li').eq(0).addClass('list-active')
    // })
    $('.carPrice-left a').mouseover(function (e) {
        var index = $(this).attr('id');
        var parent = $(this).parent().siblings()
        var child=parent.children();
        $(this).addClass('car-active')
        $(child).removeClass('car-active')
        $('.showcar-right ul').eq(index).css({'display': 'block'})
        $('.showcar-right ul').eq(index).siblings().css({'display': 'none'})
    })
    $('#ALL').mouseover(function (e) {
        $('#ALLdown')[0].style.display="block"
    })
    $('#ALL').mouseout(function (e) {
        $('#ALLdown')[0].style.display="none"
    })
    $('.Sort li a').click(function (e) {
        var parent=$(this).parent().siblings()
        var child=$(parent).children()
        $(this).addClass('aSort');
        $(child).removeClass('aSort')
        // var li="<li><span></span><span class='close'></span></li>"
        // $('.selected-type').append(li)
    })
    $('#Sort li a').click(function (e) {
        var parent=$(this).parent().parent().siblings()
        console.log(parent)
        for(var i=0;i<parent.length;i++){
            var child=$(parent[i]).children();
            $(child[i]).children().removeClass('aSort')
        }

        $(this).siblings().removeClass('aSort')
        $(this).addClass('aSort');
        console.log($(this)[0].innerHTML)
    })
    // 图片点击
    var num2=6;
    //第一步，通过$符代码分离
    $('ol li').click(function(e){             //当鼠标移动到ol里面的li的时候，执行操作
        var currentchild=$(this).children()
        $(currentchild[1]).attr('class','current')//当前的li它的类变为current,也就是样式发生变化
        var child=$(this).siblings().children()
        for(var i=0;i<child.length;i++){
            $(child[i]).attr('class',''); //当前li的兄弟li的类置空
        }
        var num=$(this).index()      //获取到当前的ol li的index值
        //因为让图片从右边过来，所以一开始先让它位于当前图片的右侧，也就是left值=图片的width
        $('.car-img ul li').eq(num).css('left','450px');
        num2++
        $('.car-img ul li').eq(num).css('z-index',num2);   //注意此处的num2是参数，不需要加''
        $('.car-img ul li').eq(num).animate({left:'0'},500);
    });
    $('.tab li').click(function (e) {
        $(this).addClass('tabcurrent')
        $(this).siblings().removeClass('tabcurrent')
    })
});
