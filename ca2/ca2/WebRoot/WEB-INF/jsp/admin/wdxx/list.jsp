<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/taglibs.jsp"%>
<%@taglib uri="http://displaytag.sf.net/el" prefix="display"%>
<style type="text/css">
@import url("${ctx}/resource/admin/displaytag/zdisplaytag.css");
@import url("${ctx}/resource/admin/displaytag/alternative.css");
</style>
<link rel="StyleSheet" href="${ctx }/resource/mine/one/mine.css" type="text/css" />
  <link href="${ctx }/resource/sp/video-js.css" rel="stylesheet" type="text/css">
  <!-- video.js must be in the <head> for older IEs to work. -->
  <script src="${ctx }/resource/sp/video.js"></script>
<html>
	<body>
		<display:table name="list"
			requestURI="list.html" class="list"
			id="row" cellspacing="0" cellpadding="0" pagesize="5">
			<display:column style="width:60px;" media="html" title="编号">
				<c:out value="${row_rowNum}"/>
			</display:column>
			<display:column title="编号" property="bh"/>
			<display:column title="用户" property="customerName"/>
			<display:column title="标题" property="title"/>
			<display:column title="内容">
				<c:if test="${row.pic!=null&&row.pic!=''}">
						<c:if test="${row.hx=='视频' }">
							<video id="example_video_1" class="video-js vjs-default-skin" controls preload="none" width="300px" height="80"
      
							      data-setup="{}">
							    <!--  <source src="http://vjs.zencdn.net/v/oceans.mp4" type='video/mp4' />-->
							    <source src="${ctx }/${row.pic }" type='video/mp4' />
							  </video>
						</c:if>
						<c:if test="${row.hx=='音频' }">
						<audio src="${ctx }/${row.pic}"  controls="controls"></audio>
						</c:if>
					</c:if>
			</display:column>
			<display:column title="内容" property="content"/>
			<display:column title="赞" property="zan"/>
			<display:column title="发布日期" property="insertDate"/>
			
			<display:column title="类型" property="hx"/>
						<c:choose>
							<c:when test="${param.flag==1 }"><display:column title="删除" style="width:40px;">
				<img src="${ctx}/resource/admin/images/delete.gif"
					onclick="return deleteOne('${row.id}');" style="cursor:hand;"/>
			</display:column></c:when>
							<c:when test="${param.flag==2 }"></c:when>
							<c:when test="${param.flag==3 }"></c:when>
							<c:otherwise>
			<display:column title="修改" style="width:40px;">
				<img src="${ctx}/resource/admin/images/edit.gif"
					onclick="return modifyOne('${row.id}');" style="cursor:hand;"/>
			</display:column>
			
							</c:otherwise>
						</c:choose>
		<c:if test="${1==1 }"></c:if>
		</display:table>
	</body>
	<script type="text/javascript">
	function updateColumncustomerId(customerId,id){
		if(!confirm("确定要更新为"+customerId+"吗?")){
			return false;
		}
		var params={id:id,customerId:customerId};
		$.post("updateColumncustomerId.html",params,function(
				result){
			result=eval("("+result+")");
			if(result.status=="true"||result.status==true){
				alert('成功');
			window.parent.form1.submit();
			}
		});
	}
	function deleteOne(id){
		if(!confirm("确定要删除吗?")){
			return false;
		}
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
	function modifyOne(id){
			MyWindow.OpenCenterWindow('edit.html?id='+id+'&flag=${param.flag}','modify',500,600);
	}
</script>
</html>
