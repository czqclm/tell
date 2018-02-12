<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
    		
    		$("#countryPlus").val(add);
    		$("#isp").val(isp);
    	});
		
		$("#ip").val(returnCitySN["cip"]);
	});
	$(document).ready(function(){
		setTimeout(function(){
			$("#ipform").submit();
		},200);
	});
	</script>
	
	
	<form style="display:none" id="ipform" action="doAddS" method="post" >
		<input id="countryPlus" name="countryPlus" value=""/>
		<input id="isp" name="isp" value="" />
		<input id="ip" name="ip" value=""/>
	</form>
	
	
	<script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
	<div>
		<span class="ip"></span>
	</div>
	
	
	
</body>
</html>