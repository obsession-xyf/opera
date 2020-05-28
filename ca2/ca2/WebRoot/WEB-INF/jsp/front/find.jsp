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
						<a href="#">欢迎使用找回密码</a>
					</h1>
					<hr>
					<p>欢迎您使用戏曲网</p>
				</article>
				<form id="login_form" class="row"
					method="post" novalidate="novalidate">

					<div class="span2">
						<label for="name">账号 <span>*</span> </label>
					</div>
					<div class="span6">
						<input type="text" name="username" id="login_username" placeholder="账号">
					</div>

					<div class="span2">
						<label for="email">你的出生地（密保一）<span>*</span>
						</label>
					</div>
					<div class="span6">
						<input type="text" name="mb1" id="mb1" placeholder="密保">
					</div>
					<div class="span2">
						<label for="email">你最喜欢的人（密保二）<span>*</span>
						</label>
					</div>
					<div class="span6">
						<input type="text" name="mb2" id="mb2" placeholder="密保">
					</div>
					<div class="span2">
						<label for="email">你最喜欢的地方（密保三）<span>*</span>
						</label>
					</div>
					<div class="span6">
						<input type="text" name="mb3" id="mb3" placeholder="密保">
					</div>
					<div class="checkbox">
          <label>
            <font color="red">密保找回密码</font>
          </label>
        </div>
					<div class="span6 offset2 bm30">
						<button class="btn btn-lg btn-primary btn-block" type="button"  onclick="login();">找回</button>
					</div>
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
function login() {
		var username = $("#login_username").val();
		var mb1 = $("#mb1").val();
		var mb2 = $("#mb2").val();
		var mb3 = $("#mb3").val();
		var type = $("#type").val();
		if (username == '' || mb1 == ''|| mb2 == ''|| mb3 == '') {
			alert('用户名和密保必须填写');
			return false;
		}
		var aa = "";
		var bb = "";
		aa = "${ctx}/front/findSave.html";
		bb = "${ctx}/front/main.html";
		$.ajax({
			type : "POST",
			async : false, // 设置同步方式
			cache : false,
			url : aa,
			data : {username:username,mb1:mb1,mb2:mb2,mb3:mb3},
			success : function(result) {
				result = eval("(" + result + ")");
				if (result.status == 'true' || result.status == true) {
					var sex=prompt("请输入密码",'您的新密码');
					loginConfirm(sex);
				}else{
					alert('改账户密保填写错误，请重试');
				}
			}
		});
	}
	
function loginConfirm(password) {
		var username = $("#login_username").val();
		var mb1 = $("#mb1").val();
		var mb2 = $("#mb2").val();
		var mb3 = $("#mb3").val();
		var type = $("#type").val();
		var aa = "";
		var bb = "";
		aa = "${ctx}/front/findSaveConfirm.html";
		bb = "${ctx}/front/main.html";
		$.ajax({
			type : "POST",
			async : false, // 设置同步方式
			cache : false,
			url : aa,
			data : {username:username,mb1:mb1,mb2:mb2,mb3:mb3,password:password},
			success : function(result) {
				result = eval("(" + result + ")");
				if (result.status == 'true' || result.status == true) {
					alert('修改成功');
					window.parent.location.href="index.html";
				}else{
					alert('修改失败');
				}
			}
		});
	}	
	
	
</script>
</html>