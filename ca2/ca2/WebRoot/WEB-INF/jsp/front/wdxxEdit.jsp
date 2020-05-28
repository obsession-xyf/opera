<%@ page language="java" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en-US">
<%@ include file="inc/head.jsp"%>
<!-- Start of Page Container -->
<div class="page-container">
	<div class="container">
		<div class="row">

			<!-- start of page content -->
			<div class="span8 page-content">

				<article class="type-page hentry clearfix">
					<h1 class="post-title">
						<a href="#">发布我的戏曲</a>
					</h1>
					<hr>
					<p>欢迎您使用戏曲网</p>
				</article>
				<form id="form1">
    
    <input type="hidden" value="${param.flag }" name="flag" /> <input
			type="hidden" value="${map.id }" name="id" id="id" />
			<input
			type="hidden" value="${param.bkId }" name="bkId" id="bkId" />
    
    <table class="mobile" style="width: 95%;">
				<tr class="pageheader">
					<td colspan="2"><strong>信息处理</strong></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">标题： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><input  class="form-control" type="text" id="title"
						value="${map.title }" name="title" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">内容类型： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2">
						<select name="hx" class="form-control" >
							<option ${map.hx=='视频'?'selected':'' } value="视频">视频</option>
							<option ${map.hx=='音频'?'selected':'' } value="音频">音频</option>
						</select>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">文件路径： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><input  class="form-control" id="f_fileImg0" name="cmfile"
						onchange="triggerUploadImg0(this);" title="选择文件" type="file">
						<input class="text"  type="hidden" name="pic" id="bbbbbImg0"
						value="${map.pic }"> <c:if test="${map.pic!=null }">
							<a  src="${ctx }/${map.pic}" >文件下载</a>
						</c:if><font color="red">（可以为空，界面做了处理，空的时候不显示）</font></td>
						
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">内容： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><textarea  class="form-control" rows="5" id="content"
							cols="50" name="content">${map.content }</textarea></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">是否游客可见： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2">
						<select name="nologin" class="form-control" >
							<option ${map.nologin=='是'?'selected':'' } value="是">是</option>
							<option ${map.nologin=='否'?'selected':'' } value="否">否</option>
						</select>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">状态： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2">
						<select name="status" class="form-control" >
							<option ${map.nologin=='发布'?'selected':'' } value="发布">发布</option>
							<option ${map.nologin=='待定'?'selected':'' } value="待定">待定</option>
						</select>
					</td>
				</tr>
			</table>
    <input type="button" class="btn btn-default" value="保  存"
				onclick="save(this);" /> <input type="button" 
				value="返回" class="btn btn-default" onclick="window.history.go(-1)" />
    
    </form>
			</div>
			<!-- end of page content -->
		</div>
	</div>
</div>
<!-- End of Page Container -->
<%@ include file="inc/foot.jsp"%>
<%@ include file="inc/js.jsp"%>
</body>
<script type="text/javascript">
  	function save(src) {
		$.post("wdxxEditSave.html", $("#form1").serializeArray(), function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('成功');
				window.location.reload();
			} else {
				alert('保存失败，请重试');
			}
		});
	}
	function triggerUploadImg0(src) {
		$
				.ajaxFileUpload({
					url : '${ctx}/file/upload.html',
					secureuri : false,
					fileElementId : 'f_fileImg0',
					dataType : 'json',
					data : {
						fileloc : 'upload/',
						dir : 'temp'
					},
					success : function(data, status) {
						$("#bbbbbImg0").val(data.data.filepath);
						$("#aaaaaImg0").remove();
						$("#bbbbbImg0")
								.after("<a  src='${ctx}/"+data.data.filepath+"' >文件下载</a>");
					},
					error : function(data, status, e) {
						alert('文件上传失败');
					}
				});
	}
  </script>
</html>