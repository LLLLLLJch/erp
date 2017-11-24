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
						  "${ctx}/productAction_delete.action", //url
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
				url = "${ctx}/productAction_add.action";
				$('#form').form("clear");
			}
			
			function openUpdateDialog(){
				var row = $('#tableId').datagrid('getSelected');
				if(row == null){
					$.messager.alert("系统提示","请选择你要修改的对象");
					return;
				}
				$("#dialog").dialog("open").dialog("setTitle","修改信息");
				url = "${ctx}/productAction_update.action";
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
				        	$.messager.alert("系统提示","修改成功");
				        	$("#dialog").dialog('close');
				        	$('#tableId').datagrid('reload');
				        }else{
				        	$.messager.alert("系统提示","修改失败");
				        }    
				    }    
				});  

			} 
			
			 function doclose(){
				 $('#dialog').dialog('close');
			 }
		
		$(function(){
			{id:'${param.id}'}
			$("#tableId").datagrid({
			 	url:'${ctx}/productAction_list.action',
				fit:true,
				singleSelect:false,
				toolbar:'#toolbar',
				rownumbers:true,
				fitColumns :false,
				pagination:true,
				columns:[[    
				     {field:'ck',checkbox:true},   
				     {field:'id',title:'编号',width:100,align:'center'},    
				     {field:'name',title:'商品名称',width:150,align:'center'},    
				     {field:'price',title:'价格',width:100,align:'center'}, 
				     {field:'stock',title:'库存',width:150,align:'center'},
				     {field:'status',title:'状态',width:150,align:'center',
				    	 formatter: function(value,row,index){
				    		 if(value == 1){
				    			 return "在售";
				    		 }else{
				    			 return "下架";
				    		 }
				    	 }}, 
				]]
			});
	});
		
		</script>
	</head>
	
	<body>
		<table id="tableId">
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
	    			<td>商品名称:</td>
	    			<td><input id="name" class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
	    			<td>状态:</td>
	    			<td>
	    				<select id="status" class="easyui-combobox" panelHeight='auto' name="status" editable="false" style="width:170px">
		    				<option value=""></option>
		    				<option value="1">在售</option>
		    				<option value="0">下架</option>
	    				</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>价格:</td>
	    			<td><input id="price" class="easyui-textbox" type="text" name="price" data-options="required:true"></input></td>
	    			<td>库存:</td>
	    			<td><input id="stock" class="easyui-textbox" type="text" name="stock" data-options="required:true"></input></td>
	    		</tr>
	    		<%-- <tr>
	    			<td>仓库</td>
	    			<td><input id="wareHouse"  class="easyui-combobox" name="wareHouse" 
		    			data-options="
		    			valueField:'name',
		    			textField:'name',
		    			panelHeight:'auto',
		    			url:'${ctx}/wareHouseAction_findWareHouse.action'"/><font color="red">*</font></td>
		    			<td><input id="wareHouse" class="easyui-textbox" type="text" name="wareHouse" data-options="required:true"></input></td>
	    		</tr> --%>
	    	</table>
		    <div id="dialog-button">   
		    	<a href="javascript:dosave();" class="easyui-linkbutton" iconCls = "icon-add">提交</a>
		    	<a href="javascript:doclose();" class="easyui-linkbutton" iconCls = "icon-cancel">关闭</a>
		    </div>    
		</form>  
   	</div>
   	<!-- 添加用户隐藏的div结束 -->
</html>