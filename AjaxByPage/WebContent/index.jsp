<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/xhr.js"></script>
<script type="text/javascript">
//全局变量，用于存储当前页
var pageNo1=1;
//全局变量，用于存储总页数
var totalPage1=1;
//全局变量，用于存储每页的数据
var pageSize1=10;
  window.onload=function(){
	 showDataByPage(1, pageSize1);
  }

/*进行分页数据请求
 * 参数1：pageNo  当前页
     参数2：pageSize  每页的数据大小
 */
function showDataByPage(pageNo,pageSize){
	//1.获取XMLHttpRequest对象
	var xhr = getXMLHttpRequest();
	//2.打开一个地址
	xhr.open("GET", "ShowDataByPage?pageNo="+pageNo+"&pageSize="+pageSize);
	//3.发送请求
	xhr.send();
	//4.监听
	xhr.onreadystatechange=function(){
		var readyState = xhr.readyState;
		if(readyState==4){
			if(xhr.status==200){
				//具有json格式的字符串   238074674284
				var result = xhr.responseText;
				//JSON.parse():把具有json结构格式的字符串进行转化成对应的json对象。 得到的是PageBean对象
				var json=  JSON.parse(result);
				
				//让全局变量存储当前页和总页数u
				pageNo1=json.pageNo;
				totalPage1=json.totalPage;
				
                 //获得分页数据的容器标签
				var content = document.getElementById("content");
                 //获取显示页数的标签
				var showPageInfo =document.getElementById("showPageInfo");
                 
                 
				showPageInfo.innerHTML="第"+pageNo+"页/共"+json.totalPage+"页";
				
				//table内容拼接
				var contentStr="<table border='1' width='80%'>";
				//从pageBean得到List<Page>
				var pagelist =json.list;
				for (var i = 0; i < pagelist.length; i++) {
					var item = pagelist[i];
					contentStr=contentStr+"<tr><td>"+item.id+"</td><td>"+item.name+"</td><td>"+item.price+"</td><td>"+item.category+"</td></tr>";
				}
				contentStr+="</table>";
				
				content.innerHTML=contentStr;
			}
		}
	}
	
}
/*展示首页  */
function showFirst(){
	 showDataByPage(1, pageSize1);
}
/*  上一页*/
function showPre(){
	if (pageNo1==1) {
		alert("这已经是第一页了");
		pageNo1=1;
	}else{
		pageNo1 = pageNo1-1;
	}
	showDataByPage(pageNo1,pageSize1);
}
/* 下一页 */
function showNext(){
	if(pageNo1==totalPage1){
		alert("这已经是最后一页了");
		pageNo1=totalPage1;
	}else{
		pageNo1=pageNo1+1;
	}
	showDataByPage(pageNo1,pageSize1);
}
/*  最后一页*/
function showLast(){
	 showDataByPage(totalPage1, pageSize1);
}
/* 跳转到指定页 */
function  jump(){
	//获取输入的指定页面
	var pageInput = document.getElementsByName("page")[0];
	var InputValue =pageInput.value;
	showDataByPage(InputValue,pageSize1);
	
}
</script>
</head>
<body>
<h1>ajax分页效果示例</h1>
<div id="content"></div>
<input type="button" value="首页" onclick="showFirst()"/>
<input type="button" value="上一页" onclick="showPre()"/>
<!-- 展示效果：当前页/总页数 -->
<span id="showPageInfo"></span>
<input type="button" value="下一页" onclick="showNext()"/>
<input type="button" value="尾页" onclick="showLast()"/>
跳转到<input type="text" name="page" value="1"/>页<input type="button" value="确定" onclick="jump()"/>
</body>
</html>