<%@ page language="java" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en-US">
<%@ include file="inc/head2.jsp"%>
<!-- Start of Page Container -->

<div class="page-container">
                        <div class="container">
                                <div class="row">

                    <!-- start of page content -->
                    <div class="span8 page-content">

                            <!-- Basic Home Page Template -->
                            <div class="row separator">
                            <h3><a href="#">信息列表</a></h3>
                            <c:forEach items="${list1 }" var="listss">
                            		<section class="span3 articles-list">
                                            <ul class="articles">
                                            		<li class="article-entry standard">
                                                            <h4><a href="wdxxShow.html?id=${listss.id }&bkId=1">${listss.title }(${listss.hx })</a></h4>
                                                            <span class="article-meta">(${listss.insertDate })<a href="wdxxShow.html?id=${listss.id }" >${listss.customerName }</a></span>
                                                            <%--<img src="${ctx }/${listss.pic}" style="width: 100%;"> --%>
                                                            <span class="like-count" onclick="zan('${listss.id}');">${listss.zan }</span>
                                                    </li>
                                            	
                                            </ul>
                                    </section>
                                    </c:forEach>
                            </div>
                    </div>
                    <!-- end of page content -->


                                        <%@include file="inc/right.jsp" %>
                                        <!-- end of sidebar -->
                                </div>
                        </div>
                </div>
<!-- End of Page Container -->
<%@ include file="inc/foot.jsp"%>
<%@ include file="inc/js.jsp"%>
</body>
<script type="text/javascript">
	
	function registerSaveuser() {
		var username = $("#user_username").val();
		var password = $("#user_password").val();
		var password2 = $("#user_password2").val();
		var phone = $("#user_phone").val();
		if (username == '' || password == '') {
			alert('用户名和密码必须填写');
			return false;
		}
		if (password2 !=password) {
			alert('两次密码输入不一致');
			return false;
		}
		$.ajax({
			type : "POST",
			async : false, // 设置同步方式
			cache : false,
			url : "${ctx}/front/registerSave.html",
			data : $("#registerFormuser").serializeArray(),
			success : function(result) {
				result = eval("(" + result + ")");
				if (result.status == 'true' || result.status == true) {
					alert('注册成功');
					window.parent.location.href = "${ctx}/front/index.html";
				}
			}
		});
	}
	
	
	function triggerUploadImg0(src) {
		$
				.ajaxFileUpload({
					url : '${ctx}/file/upload.json',
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
								.after(
										"<img  id='aaaaaImg0' style='width:100px;' src='${ctx}/"+data.data.filepath+"' />");
					},
					error : function(data, status, e) {
						alert('文件上传失败');
					}
				});
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