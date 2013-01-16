/**
 * 
 */
$(function() {
	$("#diadiv").live("click", function() {
		alert(3);
	});
	$(".aui_yes button").live("focus",function(){
		$(this).blur();
	});
	$("#but1").click(function() {
		var d = $.dialog({
			id : "dialog2",
			title:1,
			yesText : "确认",
			// follow : "but1",
			initFn : function() {
				
			},
			yesFn : function() {

			},
			content : $("#dialog").html()
		});
		console.info(d);
	});
	function aa(){console.info("aa");}
	$("#block2 div").click(aa);
	$("#block2 div").click(function(){
		console.info("#block2 div");
	})
	$(".block2").unbind("click").click(function(){
		console.info("#block2 .block2");
	})
});
(function() {
	// 改变默认配置
	var d = $.dialog.defaults;
	// 预缓存皮肤，数组第一个为默认皮肤
	d.skin = 'chrome';
	// 是否开启特效
	d.effect = true;
	// 指定超过此面积的对话框拖动的时候用替身
	d.showTemp = 100000;

	$.extend($.dialog.defaults, {
		skin : "aero",
		initFn : function() {
		}
	});

})();