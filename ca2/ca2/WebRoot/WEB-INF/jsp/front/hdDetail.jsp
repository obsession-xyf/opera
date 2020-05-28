<%@ page language="java" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en-US">
<%@ include file="inc/head.jsp"%>
<!-- Start of Page Container -->
<div class="page-container">
	<div class="container">
		<div class="row">
			<div class="span8 main-listing">
				<article class=" type-post format-image hentry clearfix">
					<header class="clearfix">
						<h3 class="post-title">
							<a href="#">${map.title }</a>
						</h3>
						<div class="post-meta clearfix">
							<span class="date">${map.showDate }</span> <span class="category">
							</span> <span class="comments">
							</span> <span class="like-count"></span>
						</div>
						<!-- end of post meta -->
					</header>
					<a href="#" title="Using Images">
					<c:if test="${map.pic!=null&&map.pic!=''}">
					<img height="100" src="${ctx }/${map.pic}"
						class="attachment-std-thumbnail wp-post-image" alt="Living room">
					</c:if>
					</a>
					<p>${map.content }</p>
				</article>
			</div>
		</div>
		
		<ul class="list-group">
</ul>

		
		
	</div>
</div>
<!-- End of Page Container -->
<%@ include file="inc/foot.jsp"%>
<%@ include file="inc/js.jsp"%>
</body>
 <script type="text/javascript">
  	function save(src) {
  		if(!checkIsLogin()){
			alert('请先登录');
			window.location.href='${ctx}/front/login.html';
			return false;
		}
		$.post("zslistSave.html", $("#form1").serializeArray(), function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('成功');
				window.location.reload();
			} else {
				alert('保存失败，请重试');
			}
		});
	}
	
	function sc(src) {
  		if(!checkIsLogin()){
			alert('请先登录');
			window.location.href='${ctx}/front/login.html';
			return false;
		}
		$.post("scSave.html", {id:'${map.id}',bkId:'${param.bkId}'}, function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('成功');
				window.location.reload();
			} else {
				alert('保存失败，请重试');
			}
		});
	}
	
	function bd11(src) {
  		window.location.href="http://map.baidu.com/";
	}
	
	function zan(id) {
		if(!checkIsLogin()){
			alert('请先登录');
			window.location.href='${ctx}/front/login.html';
			return false;
		}
		$.post("zanSave.html", {id:id}, function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('点赞成功');
				window.location.reload();
			} else {
				alert('保存失败，请重试');
			}
		});
	}
  </script>
</html>