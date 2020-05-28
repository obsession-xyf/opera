<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/taglibs.jsp"%>
<%@taglib uri="http://displaytag.sf.net/el" prefix="display"%>
<style type="text/css">
@import url("${ctx}/resource/admin/displaytag/zdisplaytag.css");
@import url("${ctx}/resource/admin/displaytag/alternative.css");
</style>
<link rel="StyleSheet" href="${ctx }/resource/mine/one/mine.css" type="text/css" />
<html>
	<body>
		<display:table name="list"
			requestURI="list.html" class="list"
			id="row" cellspacing="0" cellpadding="0" pagesize="5">
			<display:column style="width:60px;" media="html" title="编号">
				<c:out value="${row_rowNum}"/>
			</display:column>
			<display:column title="标题" property="title"/>
			<display:column title="图片">
				<img style="width:100px;" src="${ctx}/${row.pic}"/>
			</display:column>
			<c:if test="${row.fileUrl!=null&&row.fileUrl!='' }">
			<display:column title="文件">
				<a href="${ctx}/${row.fileUrl}">文件下载</a>
			</display:column>
			</c:if>
			<display:column title="内容" property="content"/>
			<display:column title="日期" property="showDate"/>
						<c:choose>
							<c:when test="${param.flag==1 }"></c:when>
							<c:when test="${param.flag==2 }"></c:when>
							<c:when test="${param.flag==3 }"></c:when>
							<c:otherwise>
							
							</c:otherwise>
						</c:choose>
			<display:column title="查看" style="width:40px;">
				<img src="${ctx}/resource/admin/images/edit.gif"
					onclick="return modifyOne('${row.id}','show');" style="cursor:hand;"/>
			</display:column>
			<display:column title="修改" style="width:40px;">
				<img src="${ctx}/resource/admin/images/edit.gif"
					onclick="return modifyOne('${row.id}','modify');" style="cursor:hand;"/>
			</display:column>
			<display:column title="删除" style="width:40px;">
				<img src="${ctx}/resource/admin/images/delete.gif"
					onclick="return deleteOne('${row.id}');" style="cursor:hand;"/>
			</display:column>
		<c:if test="${1==1 }"></c:if>
		</display:table>
	</body>
	<script type="text/javascript">
	function deleteOne(id){
		if(!confirm("确定要删除吗?")){
			return false;
		}
  //var aaa = prompt("请输入操作意见或说明：","");
		var params={id:id};
		$.post("editDelete.html",params,function(
				result){
			result=eval("("+result+")");
			if(result.status=="true"||result.status==true){
				alert('成功');
			window.parent.form1.submit();
			}
		});
	}
	function modifyOne(id,method){
			MyWindow.OpenCenterWindow('edit.html?id='+id+'&flag=${param.flag}&method='+method,'modify',500,600);
	}
</script>
</html>
