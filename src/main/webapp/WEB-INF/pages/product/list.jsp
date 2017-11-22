<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			* {
				margin: 0;
				padding: 0;
			}
		</style>
		<script type="text/javascript">
		var url;
		function openaddDialog(){
			$("#dialog").dialog("open").dialog("setTitle","添加信息");
			url = "${ctx}/staffAction_add.action";
			$('#form').form("clear");
		}
		
		function dosave(){
			$('#form').form('submit', {    
			    url:url,    
			    onSubmit: function(){    
			        if($("#roleName").combobox("getValue") == "") {
			        	$.messager.alert("系统提示", "请选择用户角色");
			        	return false;
			        }
			        return $(this).form("validate");
			    },       
			    success:function(data){    
			    	var data = eval('(' + data + ')');
			        if(data.status == Util.SUCCESS){
			        	$.messager.alert("系统提示",data.msg);
			        	$("#dialog").dialog('close');
			        	$('#tableId').datagrid('reload');
			        }    
			    }    
			});  

		}
		function dosave(){
			$('#form').form('submit', {    
			    url:url,    
			    onSubmit: function(){    
			        if($("#role").combobox("getValue") == "") {
			        	$.messager.alert("系统提示", "请选择用户角色");
			        	return false;
			        }
			        return $(this).form("validate");
			    },       
			    success:function(data){    
			    	var data = eval('(' + data + ')');
			        if(data.status == 0){
			        	$.messager.alert("系统提示",data.msg);
			        	$("#dialog").dialog('close');
			        	$('#tableId').datagrid('reload');
			        }    
			    }    
			});  

		}
		</script>
	</head>
	
	<body>
		<table id="tableId" class="easyui-datagrid" fitColumns="true" toolbar="#toolbar" pagination="true"
			data-options="fit:true,singleSelect:false,url:'${ctx}/productAction_list.action',method:'get'">
				<thead>
					<tr id="target">
						<th data-options="field:'ck',checkbox:true"></th>
						<th data-options="field:'id',width:50,align:'center'">编号</th>
						<th data-options="field:'name',width:50,align:'center'">名称</th>
						<th data-options="field:'price',width:50,align:'center'">价格</th>
						<th data-options="field:'stock',width:50,align:'center'">库存</th>
						<th data-options="field:'status',width:100,align:'center'">状态</th>
						<th data-options="field:'wareHouse',width:100,align:'center'">所在仓库</th>
					</tr>
				</thead>
			</table>
			
			<!-- toolbar -->
			<div id="toolbar">
				<div>
					<a href="javascript:openaddDialog();" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加</a>
					<a href="javascript:godelete();" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
					<a href="javascript:openUpdateDialog();" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">修改</a>
				</div>
			</div>
	</body>
	<!-- 添加用户隐藏的div开始 -->
	<div id="dialog" class="easyui-dialog" style="width:600px;height:200px;" closed="true" buttons="#dialog-button">
   		<form id="form" action="" method="post">   
		    <table cellpadding="5">
		    	<tr>
	    			<td>工号:</td>
	    			<td><input id="num" class="easyui-textbox" type="text" name="num" data-options="required:true"></input></td>
	    			<td>联系电话:</td>
	    			<td><input id="phone" class="easyui-textbox" type="text" name="phone" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>用户名:</td>
	    			<td><input id="staffName" class="easyui-textbox" type="text" name="staffName" data-options="required:true"></input></td>
	    			<td>密码:</td>
	    			<td><input id="password" class="easyui-textbox" type="text" name="password" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>真实姓名:</td>
	    			<td><input id="name" class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
	    			<td>职位:</td>
	    			<td>
	    				<select id="role" class="easyui-combobox" panelHeight='auto' name="role" editable="false" style="width:170px">
		    				<option value=""></option>
		    				<option value="销售主管">销售</option>
		    				<option value="客户经理">客户经理</option>
		    				<option value="高管">高管</option>
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>创建时间:</td>
	    			<td>
	    				<input id="createTime" name="createTime" class="easyui-datebox">
	    			</td>
	    		</tr>
	    	</table>
		    <div id="dialog-button">   
		    	<a href="javascript:dosave();" class="easyui-linkbutton" iconCls = "icon-add">提交</a>
		    	<a href="javascript:doclose();" class="easyui-linkbutton" iconCls = "icon-cancel">关闭</a>
		    </div>    
		</form>  
   	</div>
   	<!-- 添加用户隐藏的div结束 -->
</html>