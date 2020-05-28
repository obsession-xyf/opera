<%@ page language="java" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en-US">
<%@ include file="inc/head.jsp"%>
  <link href="${ctx }/resource/sp/video-js.css" rel="stylesheet" type="text/css">
  <!-- video.js must be in the <head> for older IEs to work. -->
  <script src="${ctx }/resource/sp/video.js"></script>
<!-- Start of Page Container -->
<div class="page-container">
	<div class="container">
	<c:if test="${param.dpc==999 }">
    <a class="btn btn-primary" href="wdxxEdit.html?bkId=${param.bkId }"  role="button">
    
     <c:if test="${param.bkId==1 }">发布戏曲</c:if>
     <c:if test="${param.bkId==2 }">发布教程</c:if>
    
    </a></c:if>
		<div class="row">
			<div class="span8 main-listing">
				<article class=" type-post format-image hentry clearfix">
					<header class="clearfix">
						<h3 class="post-title">
							<a href="#">${map.title }</a>
						</h3>
						<div class="post-meta clearfix">
							<span class="date">${map.insertDate }</span> <span class="category">
							</span> <span class="comments">
							</span> <span class="like-count" onclick="zan('${map.id}');">赞(${map.zan })</span>
						</div>
						<!-- end of post meta -->
					</header>
					<a href="#" title="Using Images">
					<c:if test="${map.pic!=null&&map.pic!=''}">
						<c:if test="${map.hx=='视频' }">
							<video id="example_video_1" class="video-js vjs-default-skin" controls preload="none" width="800px" height="264"
      
							      data-setup="{}">
							    <!--  <source src="http://vjs.zencdn.net/v/oceans.mp4" type='video/mp4' />-->
							    <source src="${ctx }/${map.pic }" type='video/mp4' />
							  </video>
						</c:if>
						<c:if test="${map.hx=='音频' }">
						<audio src="${ctx }/${map.pic}"  controls="controls"></audio>
						</c:if>
						<a href="${ctx }/${map.pic}">下载保存</a>
					</c:if>
					</a>
					<p>${map.content }</p>
				</article>
				 <input type="button" class="btn btn-default" value="收藏"
				onclick="sc(this);" />
			</div>
		</div>
		
		<ul class="list-group">
	<c:forEach items="${list }" var="lists">
		<li class="list-group-item">${lists.customerName }:${lists.content }(${lists.insertDate })</li>
	</c:forEach>
</ul>
<c:if test="${customerBean!=null&&customerBean.ispl!='否' }">
<form id="form1">
	<input type="hidden" name="wdxxId" value="${map.id }"/>
    <table class="mobile" style="width: 95%;">
				<tr height="25">
					<td class="outDetail" style="width: 30%">评论内容： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><textarea  class="form-control" rows="5" id="content"
							cols="50" name="content"></textarea></td>
				</tr>
			</table>
    <input type="button" class="btn btn-default" value="发表评论"
				onclick="save(this);" />
    
    </form>
</c:if>

		<div class="row separator">
		<h3><a href="#">其他戏曲推荐</a></h3>
		<c:forEach items="${lista }" var="listss">
                            		<section class="span3 articles-list">
                                            
                                            <ul class="articles">
                                            		<li class="article-entry standard">
                                                            <h4><a href="wdxxShow.html?id=${listss.id }&bkId=1">${listss.title }</a></h4>
                                                            <span class="article-meta">(${listss.insertDate })<a href="wdxxShow.html?id=${listss.id }" >${listss.customerName }</a></span>
                                                            <%--<img src="${ctx }/${listss.pic}" style="width: 100%;"> --%>
                                                            <span class="like-count" onclick="zan('${listss.id}');">${listss.zan }</span>
                                                    </li>
                                            	
                                            </ul>
                                    </section>
                                    </c:forEach>
                            </div>
		
		
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
		$.post("pinglunSave.html", $("#form1").serializeArray(), function(result) {
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