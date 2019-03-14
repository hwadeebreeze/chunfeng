$(document).ready(function() {
	//打开登录 
	$("#report").click(function() {
		$("#report_close").show();
		$("#_report").animate({
			left: '500px',
			height: '600px',
			width: '600px'
		}, 500, function() {
			$("#report_container").show(500);
			$("#report_close").animate({
				height: '30px',
				width: '30px'
			}, 500);
		});
	});
	//关闭
	$("#report_close").click(function() {
		
		$("#report_close").animate({
			height: '0px',
			width: '0px'
		}, 1, function() {
			$("#report_close").hide(500);
			$("#report_container").hide(500);
			$("#_report").animate({
				left: '0px',
				height: '0px',
				width: '0px'
			}, 500);
		});
	});
});