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
						  "${ctx}/orderItemAction_delete.action", //url
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
		
		$(function(){
			{id:'${param.id}'}
			$("#tableId").datagrid({
			 	url:'${ctx}/productAction_findWareHouse.action?id=${param.id}',
				fit:true,
				singleSelect:true,
				toolbar:'#toolbar',
				rownumbers:true,
				fitColumns :false,
				pagination:true,
				columns:[[    
				     {field:'ck',checkbox:true},   
				     {field:'id',title:'编号',width:50,align:'center'},    
				     {field:'name',title:'仓库名称',width:150,align:'center'},    
				     {field:'address',title:'地址',width:100,align:'center'}, 
				     {field:'detail',title:'详细地址',width:250,align:'center'},
				     {field:'startTime',title:'开始时间',width:150,align:'center'},
				     {field:'endTime',title:'结束时间',width:150,align:'center'},
				     
				]]
			});
	});
		</script>
	</head>
	
	<body>
		<table id="tableId" class="easyui-datagrid" fitColumns="true" toolbar="#toolbar" pagination="true"
			data-options="fit:true,singleSelect:false,url:'${ctx}/orderAction_list.action',method:'get'">
			</table>
			
			<!-- toolbar -->
			<div id="toolbar">
				<div>
					<a href="javascript:godelete();" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
				</div>
			</div>
	</body>
</html>