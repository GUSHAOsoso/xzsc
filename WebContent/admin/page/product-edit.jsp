<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="po.Book" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>商品编辑</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- page style -->
  <style>
  .my-input{
    width: 22.77777778% !important;
  }
  .my-label{
	width: 10.55555555% !important;
  }
  .my-img{
	padding-right: 2.0% !important;
    padding-left: 8.0% !important;
  }
  .datepicker{
    z-index: 9999 !important;
  }
  </style>
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="../css/bootstrap/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="../css/font-awesome/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="../css/Ionicons/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../css/AdminLTE/AdminLTE.min.css">
  <!-- AdminLTE Skin -->
  <link rel="stylesheet" href="../css/AdminLTE/skin/skin-blue.min.css">
  <!-- Google Font -->
  <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic"> -->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="#" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>书城</b></span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg">学子书城管理系统</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">导航切换</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          <!-- /.messages-menu -->
          <!-- User Account Menu -->
          <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <!-- The user image in the navbar-->
              <img src="../img/setting.png" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs">刘铁蛋</span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="../img/word.jpg" class="img-circle" alt="User Image">
                <p>让学习成为一种习惯</p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="../page/password-change.html" class="btn btn-default btn-flat">修改密码</a>
                </div>
                <div class="pull-right">
                  <a href="../page/login.html" class="btn btn-default btn-flat">退出</a>
                </div>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar Menu -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">&nbsp;</li>
        <!-- Optionally, you can add icons to the links -->
        <li class="treeview">
          <a href="#"><i class="fa fa-link"></i> <span>订单管理</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../page/order-list.html">所有订单</a></li>
            <li><a href="#">待处理</a></li>
            <li><a href="#">处理中</a></li>
            <li><a href="#">已发货</a></li>
            <li><a href="#">已交付</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#"><i class="fa fa-link"></i> <span>商品管理</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="../page/product-list.html">所有商品</a></li>
            <li><a href="../page/product-add.html">添加商品</a></li>
          </ul>
        </li>
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1><small></small></h1>
      <ol class="breadcrumb">
        <li><i class="fa fa-dashboard">&nbsp;商品管理</i></li>
        <li><a href="../page/product-list.html"><i class="fa"></i>所有商品</a></li>
        <li class="active">商品编辑</li>
      </ol>
    </section>
    <!-- Main content -->
    <section class="content container-fluid">
      <!-- Horizontal Form -->
      <div class="box box-primary">
        <div class="box-header with-border">
          <h3 class="box-title">详细编辑</h3>
        </div>
        <!-- /.box-header -->
        <!-- form start -->
        <%
        	Book book = (Book)request.getAttribute("book");
    	 %>  
        <form class="form-horizontal" role="form" id="fm">
          <div class="box-body">
            <div class="form-group">
			  <label for="isbn" class="col-sm-2 control-label my-label">图书编号</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="isbn" id="isbn" value="<%=book.getIsbn() %>" readonly>
              </div>
			  <label for="title" class="col-sm-2 control-label my-label">书名</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="title" id="title" value="<%=book.getTitle() %>">
              </div>
			  <label for="author" class="col-sm-2 control-label my-label">作者</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="author" id="author" value="<%=book.getAuthor() %>">
              </div>
            </div>
            <div class="form-group">
			  <label for="price" class="col-sm-2 control-label my-label">价格</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="price" id="price" value="<%=book.getPrice() %>">
              </div>
			  <label for="pages" class="col-sm-2 control-label my-label">页数</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="pages" id="pages" value="<%=book.getPages() %>">
              </div>
			  <label for="words" class="col-sm-2 control-label my-label">字数</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="words" id="words" value="<%=book.getWords() %>">
              </div>
            </div>
            <div class="form-group">
			  <label for="press" class="col-sm-2 control-label my-label">出版社</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="press" id="press" value="<%=book.getPress() %>">
              </div>
			  <label for="edition" class="col-sm-2 control-label my-label">版次</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="edition" id="edition" value="<%=book.getEdition() %>">
              </div>
			  <label for="published" class="col-sm-2 control-label my-label">出版日期</label>
              <div class="col-sm-10 my-input">
                <input type="datetime" class="form-control" name="published" id="published" value="<%=book.getPublished() %>">
              </div>
            </div>
            <div class="form-group">
			  <label for="format" class="col-sm-2 control-label my-label">开本</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="format" id="format" value="<%=book.getFormat() %>">
              </div>
			  <label for="packaging" class="col-sm-2 control-label my-label">包装</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="packaging" id="packaging" value="<%=book.getPackaging() %>">
              </div>
			  <label for="form" class="col-sm-2 control-label my-label">用纸</label>
              <div class="col-sm-10 my-input">
                <input type="text" class="form-control" name="form" id="form" value="<%=book.getForm() %>">
              </div>
            </div>
            <div class="form-group">
			  <div class="col-sm-4 my-img">
                <img class="img-responsive" src="../../user/img/goods/<%=book.getIsbn() %>/detail1big.jpg" alt="Detail 1 Photo is missing">
              </div>
			  <div class="col-sm-4 my-img">
                <img class="img-responsive" src="../../user/img/goods/<%=book.getIsbn() %>/detail2big.jpg" alt="Detail 2 Photo is missing">
              </div>
			  <div class="col-sm-4 my-img">
                <img class="img-responsive" src="../../user/img/goods/<%=book.getIsbn() %>/detail3big.jpg" alt="Detail 3 Photo is missing">
              </div>
            </div>
          </div>
          <!-- /.box-body -->
          <div class="box-footer">
            <button type="submit" class="btn btn-primary pull-right">提交</button>
          </div>
          <!-- /.box-footer -->
        </form>
      </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="pull-right hidden-xs">
     
    </div>
    <!-- Default to the left -->
    <strong><a href=""></a></strong>
  </footer>

  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
  immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->
<script src="../js/jquery/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="../js/bootstrap/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="../js/AdminLTE/adminlte.min.js"></script>
<!-- page script -->
<script>
$("#bt-submit").click(function(){
	var inputData = $('#fm').serialize();
	$.ajax({
	  type:'post',
	  data:inputData,
	  url:'../servlet/product-update',
	  success:function(data){
		  console.log('开始处理响应数据');
		  // alert("*"+data+"*");
		  if(data=='yes'){
			  window.location.href="../servlet/product-detail?isbn="+isbn;
		  }
	  }
	});
});
</script>
</body>
</html>
