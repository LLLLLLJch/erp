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
		function godelete(){
			array = Util.getSelected("#tableId");
			if(array.length == 0){
				$.messager.alert('系统提示',"请选择您要删除的数据");
				return;
			}
			$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
			    if (r){ $.post(
						  "${ctx}/customerLinkManAction_delete.action", //url
						   {ids:array}, //data
						    function(data) { //callback
						      $.messager.alert('系统提示',data.msg);
						        if(data.status == 0){
						           $('#tableId').datagrid('reload');
						           }
						     },
						   "json" //type
					 );
			    }    
			}); 
			
		}
		
		function doSearch(){
			$('#tableId').datagrid('load',{
				'name':$('#nameId').val(),
			});
		}
			
			var url;
			function openaddDialog(){
				$("#dialog").dialog("open").dialog("setTitle","添加信息");
				url = "${ctx}/customerLinkManAction_add.action";
				$('#form').form("clear");
			}
			
			function openUpdateDialog(){
				var row = $('#tableId').datagrid('getSelected');
				console.log(row);
				if(row == null){
					$.messager.alert("系统提示","请选择你要修改的对象");
					return;
				}
				$("#dialog").dialog("open").dialog("setTitle","修改信息");
				url = "${ctx}/customerLinkManAction_update.action";
				$('#form').form('load',row);
			}
			
			 function dosave(){
				$('#form').form('submit', {    
				    url:url,    
				    onSubmit: function(){    
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
			
			 function doclose(){
				 $('#dialog').dialog('close');
			 }
		</script>
	</head>
	
	<body>
		<table id="tableId" class="easyui-datagrid" fitColumns="true" toolbar="#toolbar" pagination="true"
			data-options="fit:true,singleSelect:false,url:'${ctx}/customerLinkManAction_list.action',method:'get'">
				<thead>
					<tr id="target">
						<th data-options="field:'ck',checkbox:true"></th>
						<th data-options="field:'id',width:50,align:'center'">编号</th>
						<th data-options="field:'customerId',width:100,align:'center'">客户编号</th>
						<th data-options="field:'linkName',width:100,align:'center'">姓名</th>
						<th data-options="field:'phone',width:100,align:'center'">电话</th>
						<th data-options="field:'gender',width:100,align:'center'">性别</th>
						<th data-options="field:'position',width:100,align:'center'">职位</th>
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
   			<input type="hidden" name="id" id="id"/>
		    <table cellpadding="5">
		    	<tr>
	    			<td>客户编号:</td>
	    			<td><input id="customerId" class="easyui-textbox" type="text" name="customerId" data-options="required:true"></input></td>
	    			<td>姓名:</td>
	    			<td><input id="linkName" class="easyui-textbox" type="text" name="linkName" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>联系电话:</td>
	    			<td><input id="phone" class="easyui-textbox" type="text" name="phone" data-options="required:true"></input></td>
	    			<td>性别:</td>
	    			<td><input id="gender" class="easyui-textbox" type="text" name="gender" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>职位:</td>
	    			<td>
	    				<select id="position" class="easyui-combobox" panelHeight='auto' name="position" style="width:180px;">
	    					<option value="经理">经理</option>
	    					<option value="秘书">秘书</option>
	    					<option value="主管">主管</option>
						</select>
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