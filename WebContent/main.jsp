<%@page import="com.uip.vo.Uhf"%>
<%@page import="com.uip.vo.Ucont"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta name="format-detection" content="telephone=no" />  
<meta name="apple-mobile-web-app-capable" content="yes" />    
<title>留言板</title>
<link rel="stylesheet" href="css/sy.css" />
<script type="text/javascript" src="js/jquery-2.1.1.min.js" ></script>

</head>
<body>
	
	<script type="text/javascript" src="js/jquery-2.1.1.min.js" ></script>
    <script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		$.getScript('http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js',function(){
    		var country = remote_ip_info.country;
    		var province = remote_ip_info.province;
    		var city = remote_ip_info.city;
    		var isp = remote_ip_info.isp;
    		var add = remote_ip_info.country + "," + remote_ip_info.province + "," + remote_ip_info.city;
    		
    		$(".countryPlus").val(add);
    		$(".isp").val(isp);
    	});
		
		$(".ip").val(returnCitySN["cip"]);
		
		
		
	});
	
	</script>
	
	
	
	<div class="title">
		<span>留言板</span>
	</div>
	
	<div>
		<div class="board">
			<ul>
				<li><div class="i1"/></li>
				<li><div class="i2"/></li>
				<li><div class="i3"/></li>
			</ul>
			<form action="doAddUcont" method="post" id="form1">
				<textarea name="userText" class="text" rows="5" cols="5"></textarea>
				<div class="inB" >
					<input class="userName" type="text" name="userName" value="您的昵称" />
					<input class="userBtn" type="button" value="留个言吧"></input>
					<div class="heart" /></div>
				</div>
				<div style="display:none">
					<input class="countryPlus" name="countryPlus" value=""/>
					<input class="ip" name="ip" value=""/>
				</div>
			</form>
		</div>
	</div>
	<div class="main">
		<ul>
			<li><div class="i4"/></li>
			<li><div class="i5"/></li>
			<li><div class="i6"/></li>
		</ul>
		<%
			List<Ucont> userList1 = (List<Ucont>)request.getAttribute("userList");
			List<Uhf> userList2 = (List<Uhf>)request.getAttribute("userListHf");
			for(Ucont ut : userList1){
		%>
		
		<div class="cont" id="cont<%=ut.getId() %>">
			<span class="uname"><%=ut.getUname() %></span>
			<span class="uid">#<%=ut.getId() %></span>
			<br />
			<span class="formTime" ><%=ut.getUadd() %></span>
			<span class="formTime" ><%=ut.getUtime() %></span>
			<br />
			<span class="ucont"><%=ut.getUcont()%></span>
			<br />
				
				<div class="zanDiv" id="zanDiv<%=ut.getId() %>">
					<input type="button" name="zan" class="zanBtn" id="zanBtn<%=ut.getId() %>" />
					<span class="zanNum" id="zan<%=ut.getId() %>" ><%=ut.getUzan() %></span>
					<a class="addHf<%=ut.getId() %>" href="#cont<%=ut.getId() %>" style="float: right;" >回复</a>		
				</div>
				
				<form action="doHf" method="post" id="formHf<%=ut.getId() %>">
					<div id="hfDiv<%=ut.getId() %>" class="hfDivd" >
						<textarea id="text<%=ut.getId() %>" name="textHf" class="text" rows="5" cols="5" ></textarea>
						<div class="inB" >
							<input id="userNameHf<%=ut.getId() %>" class="userName" type="text" name="userNameHf" value="您的昵称" />
							<input id="but<%=ut.getId() %>" class="userBtnHf" type="button" value="发送" />
							<div style="display:none">
								<input class="countryPlus" name="countryPlus" value=""/>
								<input class="ip" name="ip" value=""/>
								<input name="hfId" value="<%=ut.getId() %>"/>
							</div>
						</div>
					</div>
				</form>
			
			<form style="display:none" action="doAddZan" method="post" id="formZan<%=ut.getId() %>">
				<input type="text" name="idZan" value="<%=ut.getId() %>" />
				<input type="text" name="ZanNum" value="<%=ut.getUzan()+1 %>"/>
			</form>
			<div class="hfCont" >
				<%
					for(Uhf uhf : userList2){
						if(uhf.getUofid() == ut.getId()){
							
				%>
				<div class="hfContt">
					<span class="uname"><%=uhf.getUname() %></span>
					
					
					<br />
					<span class="formTime" ><%=uhf.getUadd() %></span>
					<span class="formTime" ><%=uhf.getUtime() %></span>
					<br />
					<span class="ucont"><%=uhf.getUcont()%></span>
					<br />
					<hr size="1px" width="100%" />
					
					
				</div>
				
				
				
					<%}%>
				<%} %>
			</div>
		</div>
		
		
		<script>
			var num<%=ut.getId() %> = 0;
			
			$("#zanBtn<%=ut.getId() %>").click(function(){
				var num = parseInt($("#zan<%=ut.getId() %>").html());
				$("#zan<%=ut.getId() %>").html(num+1);
			});
			$("#zanBtn<%=ut.getId() %>").click(function(){
				$("#formZan<%=ut.getId() %>").submit();
			});
			$(".addHf<%=ut.getId() %>").click(function(){
				if(num<%=ut.getId() %>==0){
					$("#hfDiv<%=ut.getId() %>").show(500);
					num<%=ut.getId() %> = 1;
				}else{
					$("#hfDiv<%=ut.getId() %>").hide(500);
					num<%=ut.getId() %> = 0;
				}
			});
			$("#userNameHf<%=ut.getId() %>").focus(function(){
				$("#userNameHf<%=ut.getId() %>").val("");
			});
			$("#but<%=ut.getId() %>").click(function(){
				var ct = $("#userNameHf<%=ut.getId() %>").val();
				if (ct == "您的昵称" || ct =="请先输入昵称" || ct =="" || ct == null){
					$("#userNameHf<%=ut.getId() %>").css("border","red solid 1px");
					$("#userNameHf<%=ut.getId() %>").val("请先输入昵称");
					$("#userNameHf<%=ut.getId() %>").css("color","red")
				} else {
					$("#formHf<%=ut.getId() %>").submit();
				}
			});
			
		</script>
		
		<%
			}
		%>
	</div>
	
	<script>
		
	
		$(".i1").click(function(){
			$(".board").fadeTo("500",0.3);
			
		});
		$(".i4").click(function(){
			$(".main").fadeTo("500",0.3);
		});
		$(".userName").focus(function(){
			$(".userName").val("");
		});
		$(".userBtn").click(function(){
			var ct = $(".userName").val();
			if (ct == "您的昵称" || ct =="请先输入昵称" || ct =="" || ct == null){
				$(".userName").css("border","red solid 1px");
				$(".userName").val("请先输入昵称");
				$(".userName").css("color","red")
			} else {
				$("#form1").submit();
			}
		});
		
		
	</script>
	
	
	
</body>
</html>