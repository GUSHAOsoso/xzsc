<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="po.OrderStatus" %>   
<%@ page import="po.Address" %>   
<%@ page import="po.OrderItem" %> 
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>订单打印</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- page style-->
  <style>
  .my_itemtitle{
    font-size: 20px;
  }
  .my_info{
    width: 50% !important;
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
  <!-- Google Font -->
  <!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic"> -->
</head>
<body onload="window.print();">
  <div class="wrapper">
    <!-- Main content -->
    <section class="invoice">
      <!-- title row -->
      <div class="row">
        <div class="col-xs-12">
          <h2 class="page-header">
            <i class="fa"></i>订单详情
            <small class="pull-right">日期: 2017-10-10</small>
          </h2>
        </div>
        <!-- /.col -->
      </div>
      <!-- info row -->
      <div class="row invoice-info">
        <div class="col-sm-4 invoice-col my_info">
            <b class="my_itemtitle">收件人</b><br>
            <br>
            <%
    			ArrayList<Address> books = (ArrayList<Address>)request.getAttribute("list");
            	for(int i=0;i<books.size();i++){
            		Address book = books.get(i);
    		%>
            <b>姓名：</b><%=book.getReceiver() %><br>
            <b>地址：</b><%=book.getAddress() %><br>
            <b>电话：</b><%=book.getRphone() %><br>
            <%} %>
        </div>
        <!-- /.col -->
        <div class="col-sm-4 invoice-col my_info">
          <b class="my_itemtitle">#183</b><br>
          <br>
         <%
    			ArrayList<OrderStatus> books1 = (ArrayList<OrderStatus>)request.getAttribute("list1");
            	for(int i=0;i<books1.size();i++){
            		OrderStatus book = books1.get(i);
    		%>
          <b>创建时间：</b><%=book.getPlaced() %><br>
          <b>订单总额：</b>￥<%=book.getPayment() %><br>
          <b>订单状态：</b><%=book.getSta()%>
          <%} %>
        </div>
        <!-- /.col -->
      </div>
      <hr>
      <!-- /.row -->
      <!-- Table row -->
      <div class="row">
        <div class="col-xs-12 table-responsive">
          <table class="table table-striped">
            <thead>
            <tr>
              <th>数量</th>
              <th>名称</th>
              <th>商品编号</th>
              <th>订单编号</th>
              <th>单价</th>
            </tr>
            </thead>
            <tbody>
            <%
    			ArrayList<OrderItem> books2 = (ArrayList<OrderItem>)request.getAttribute("list2");
            	for(int i=0;i<books2.size();i++){
            		OrderItem book = books2.get(i);
    		%>
            <tr>
              <td><%=book.getCount() %></td>
              <td>sss</td>
        
              <td><%=book.getProduct() %></td>
              <td><%=book.getOid() %></td>
              <td>￥<%=book.getPrice() %></td>
            </tr>
            <%} %>
            </tbody>
          </table>
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- ./wrapper -->
</body>
</html>
