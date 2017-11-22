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
						  "${ctx}/orderAction_delete.action", //url
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
			
			
			 function doclose(){
				 $('#dialog').dialog('close');
			 }
			 
			 $(function(){
					{orderNo:'${param.orderNo}'}
					$("#tableId").datagrid({
					 	url:'${ctx}/orderItemAction_list.action?orderNo=${param.orderNo}',
						fit:true,
						singleSelect:false,
						toolbar:'#toolbar',
						rownumbers:true,
						fitColumns :false,
						pagination:true,
						columns:[[    
						     {field:'ck',checkbox:true},   
						     {field:'id',title:'编号',width:50,align:'center'},    
						     {field:'orderNo',title:'订单号',width:150,align:'center'},    
						     {field:'customerId',title:'客户编号',width:100,align:'center'}, 
						     {field:'payment',title:'金额',width:150,align:'center'},
						     {field:'quantity',title:'数量',width:150,align:'center'},
						     {field:'createTime',title:'创建时间',width:150,align:'center'}, 
						     {field:'updateTime',title:'修改时间',width:150,align:'center'}, 
						     {field:'a',title:'操作',width:150,align:'center',
						    	 formatter: function(value,row,index){
						    		 return "<a href='javascript:Suspendloss("+row.orderNo+");'>查看订单详情</a>";
						    	 }
						     }, 
						     
						]]
					});
			});
			 
			 function Suspendloss(orderNo){
					window.parent.openTab('订单详情'+orderNo+'','${ctx}/page_orderItem_list.action?orderNo='+orderNo+'','icon-add');
				}
		</script>
	</head>
	
	<body>
		<table id="tableId">
		</table>
			
			<!-- toolbar -->
			<div id="toolbar">
				<div>
					<a href="javascript:godelete();" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
				</div>
			</div>
	</body>
</html>