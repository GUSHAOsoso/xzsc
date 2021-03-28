<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>在线网上图书商城注册页面</title>
    <link href="../css/header.css" rel="stylesheet"/>
    <link href="../css/footer.css" rel="stylesheet"/>
    <link href="../css/animate.css" rel="stylesheet"/>
    <link href="../css/login.css" rel="stylesheet" />
</head>
<body>
<!--模态框-->
<div class="modal">
  <div class="modal_header">
    提示信息
  </div>
  <div class="modal_content">
    恭喜您已成功注册在线网上图书商城！
  </div>
</div>
<!-- 页面顶部-->
<header id="top">
  <div class="top">
    <img src="../img/header/logo.png" alt=""/>
    <span>欢迎注册</span>
  </div>
</header>
<div class="parent">
  <div class="container">
    <div class="panel rt">
      <form id="fm-register" method="post" action="userRegist">
        <div class="txt">
          <p id="newuser">新用户注册
            <span>
              <a href="login.html" id="dlogin">直接登录</a>
            </span>
          </p>
        </div>
        <div class="form-group">
          <label for="uname">用户名：</label>
          <input autocomplete required minlength="6" maxlength="9" type="text" placeholder="请输入用户名" autofocus name="uname" id="uname"/>
          <span id="unameError" class="msg-default">用户名长度在6到9位之间</span>
        </div>
        <div class="form-group">
          <label for="upwd">登录密码：</label>
          <input required type="password" minlength="6" maxlength="12" placeholder="请输入密码" name="upwd" autofocus id="upwd"/>
          <span id="upwdError" class="msg-default hidden">密码长度在6到12位之间</span>
        </div>
        <div class="form-group">
          <label for="email">邮箱：</label>
          <input autocomplete required type="email" placeholder="请输入邮箱地址" name="email" id="email"/>
          <span id="emailError" class="msg-default hidden">请输入合法的邮箱地址</span>
        </div>
        <div class="form-group">
          <label for="phone">手机号：</label>
          <input id="phone" name="phone" placeholder="请输入您的手机号" pattern="(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$" required type="text" />
          <span id="phoneError" class="msg-default hidden">请输入合法的手机号</span>
        </div>
        <div class="form-group">
          <label></label>
          <input type="button" value="提交注册信息" id="bt-register"/>
        </div>
      </form>
    </div>
  </div>
</div>

<!-- 品质保障，私人定制等-->
<div id="foot_box">
  <div class="icon1 lf">
    <img src="../img/footer/icon1.png" alt=""/>
    <h3>品质保障</h3>
  </div>
  <div class="icon2 lf">
    <img src="../img/footer/icon2.png" alt=""/>
    <h3>私人定制</h3>
  </div>
  <div class="icon3 lf">
    <img src="../img/footer/icon3.png" alt=""/>
    <h3>学生特供</h3>
  </div>
  <div class="icon4 lf">
    <img src="../img/footer/icon4.png" alt=""/>
    <h3>专属特权</h3>
  </div>
</div>
<!-- 页面底部-->
<div class="foot_bj">
  <div id="foot">
    <div class="lf">
      <p class="footer1"><img src="../img/footer/tedu.png" alt="" class=" footLogo"/></p>
      <p class="footer2"><img src="../img/footer/footerFont.png"alt=""/></p>
      <!-- 页面底部-备案号 #footer -->
      <div class="record">
        2001-2016 版权所有 京ICP证8000853号-56
      </div>
    </div>
    <div class="foot_left lf" >
      <ul>
        <li><a href="#"><h3>买家帮助</h3></a></li>
        <li><a href="#">新手指南</a></li>
        <li><a href="#">服务保障</a></li>
        <li><a href="#">常见问题</a></li>
      </ul>
      <ul>
        <li><a href="#"><h3>商家帮助</h3></a></li>
        <li><a href="#">商家入驻</a></li>
        <li><a href="#">商家后台</a></li>
      </ul>
      <ul>
        <li><a href="#"><h3>关于我们</h3></a></li>
        <li><a href="#">联系我们</a></li>
        <li>
          <img src="../img/footer/wechat.png" alt=""/>
          <img src="../img/footer/sinablog.png" alt=""/>
        </li>
      </ul>
    </div>
    <div class="service">
      <p>达内商城客户端</p>
      <img src="../img/footer/ios.png" class="lf">
      <img src="../img/footer/android.png" alt="" class="lf"/>
    </div>
    <div class="download">
      <img src="../img/footer/erweima.png">
    </div>
  </div>
</div>
<script src="../js/jquery-3.1.1.min.js"></script>
<script>
	$('#bt-register').click(function(){
		var lengths=0;
		$('.form-group').each(function(){
		  if($(this).find('span').hasClass('msg-success')){
		    lengths++;
		  }
		});
		if(lengths==4){
	        $('#fm-register').submit();
	  }
	}); 
  /*1.对用户名进行验证*/
  $('#uname').blur(function(){
    if(this.validity.valueMissing){
      this.nextElementSibling.innerHTML = '用户名不能为空';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('用户名不能为空');
    }else if(this.validity.tooShort){
      this.nextElementSibling.innerHTML = '用户名不能少于6位';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('用户名不能少于6位');
    }else {
      this.nextElementSibling.innerHTML = '用户名格式正确';
      this.nextElementSibling.className = 'msg-success';
      this.setCustomValidity('');
      var data = $("#uname").val();
      if(!data){   //用户没有输入任何内容
        return;
      }
      /*发起异步请求，询问服务器用户名是否已经存在*/
      $.ajax({
      type:'post',
      data:'uname='+data,
      url:'/xzsc/user/page/CheckUnameServlet',
      success:function(msg){
            console.log('开始处理响应数据');
            // alert("*"+data+"*");
            if(msg=="yes"){
            	$("#uname").next().removeClass().addClass("msg-error");
            	$("#uname").next().text("该用户被占用");
            }
      }
    });
    }
  });
  $('#uname').focus(function(){
    this.nextElementSibling.innerHTML = '用户名长度在6到9位之间';
    this.nextElementSibling.className = 'msg-default';
  });
  /*2.对密码进行验证*/
  $('#upwd').blur(function(){
    if(this.validity.valueMissing){
      this.nextElementSibling.innerHTML = '密码不能为空';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('密码不能为空');
    }else if(this.validity.tooShort){
      this.nextElementSibling.innerHTML = '密码长度在尽量别少于6位';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('密码长度在尽量别少于6位');
    }else {
      this.nextElementSibling.innerHTML = '密码格式正确';
      this.nextElementSibling.className = 'msg-success';
      this.setCustomValidity('');
    }
  });
  $('#upwd').focus(function(){
    this.nextElementSibling.innerHTML = '密码长度在6到12位之间';
    this.nextElementSibling.className = 'msg-default';
  });
  /*3.对邮箱地址进行验证*/
  $('#email').blur(function(){
    if(this.validity.valueMissing){
      this.nextElementSibling.innerHTML = '邮箱不能为空';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('邮箱不能为空');
    }else if(this.validity.typeMismatch){
      this.nextElementSibling.innerHTML = '邮箱格式不正确';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('邮箱格式不正确');
    }else {
      this.nextElementSibling.innerHTML = '邮箱格式正确';
      this.nextElementSibling.className = 'msg-success';
      this.setCustomValidity('');
    //  var data =document.getElementById("email").value;
      var data = $("#email").val();
      if(!data){   //用户没有输入任何内容
        return;
      }
      /*发起异步请求，询问服务器邮箱是否已经存在*/
      $.ajax({
      type:'get',
      data:'email='+data,
      url:'/xzsc/user/page/CheckEmailServlet',
      success:function(data){
            console.log('开始处理响应数据');
            // alert("*"+data+"*");
            if(data=='yes'){
            	$("#email").next().removeClass().addClass("msg-error");
            	$("#email").next().text("该邮箱被占用");
            }
      }
    });
    }
  });
  $('#email').focus(function(){
    this.nextElementSibling.innerHTML = '请输入合法的邮箱地址';
    this.nextElementSibling.className = 'msg-default';
  });
  /*4.对手机号进行验证*/
  $('#phone').blur(function(){
    if(this.validity.valueMissing){
      this.nextElementSibling.innerHTML = '手机号不能为空';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('手机号不能为空');
    }else if(this.validity.patternMismatch){
      this.nextElementSibling.innerHTML = '手机号格式不正确';
      this.nextElementSibling.className = 'msg-error';
      this.setCustomValidity('手机号格式不正确');
    }else {
      this.nextElementSibling.innerHTML = '手机号格式正确';
      this.nextElementSibling.className = 'msg-success';
      this.setCustomValidity('');
      var data = $("#phone").val();
      if(!data){   //用户没有输入任何内容
        return;
      }
      /*发起异步请求，询问服务器手机号是否已经存在*/
      $.ajax({
      type:'get',
      data:'phone='+data,
      url:'/xzsc/user/page/CheckPhoneServlet',
      success:function(data){
            console.log('开始处理响应数据');
            // alert("*"+data+"*");
            if(data=='yes'){
            	$("#phone").next().removeClass().addClass("msg-error");
            	$("#phone").next().text("该手机号被占用");
            }
      }
    });
    }
  });
  $('#phone').focus(function(){
    this.nextElementSibling.innerHTML = '请输入合法的手机号';
    this.nextElementSibling.className = 'msg-default';
  });
  </script>
</body>
</html>
