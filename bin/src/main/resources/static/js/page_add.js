$(document).ready(function() {
	//打开登录 
	$("#login").click(function() {
		$("#login_close").show();
		$("#_start").animate({
			top: '200px',
			left: '550px',
			height: '400px',
			width: '400px'
		}, 500, function() {
			$("#login_container").show(500);
			$("#login_close").animate({
				height: '30px',
				width: '30px'
			}, 500);
		});
	});
	//关闭
	$("#login_close").click(function() {
		
		$("#login_close").animate({
			height: '0px',
			width: '0px'
		}, 1, function() {
			$("#_close").hide(500);
			$("#login_container").hide(500);
			$("#regist_container").hide(500);
			$("#_start").animate({
				left: '0px',
				height: '0px',
				width: '0px'
			}, 500);
		});
	});
});