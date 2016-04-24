+(function($){
	$("input#nickname").keyup(function(){
		var nickname = $(this).val();
		$.ajax({
			type: "GET",
			url: "${pageContext.request.contextPath}/user/checkNickname",
			data: "nickname="+nickname,
			success: function(data){
				var response = $.trim(data);
				if(data === 'yes' && nickname.length !== 0){
					$('div#checkNickname > span').removeClass("glyphicon-warning-sign").addClass("glyphicon-ok");
					$('div#checkNicknameDiv').removeClass('has-warning').addClass("has-success");
				}else{
					$('div#checkNickname > span').removeClass("glyphicon-ok").addClass("glyphicon-warning-sign");
					$('div#checkNicknameDiv').removeClass("has-success").addClass('has-warning');
				}
			},
			error: function(){
				console.log("ERROR");
			}
		})
	});
	
	$("input#login").keyup(function(){
		var login = $(this).val();
		$.ajax({
			type: "GET",
			url: "${pageContext.request.contextPath}/user/checkLogin",
			data: "login="+login,
			success: function(data){
				var response = $.trim(data);
				if(data === 'yes' && login.length !== 0){
					$('div#checkLogin > span').removeClass("glyphicon-warning-sign").addClass("glyphicon-ok");
					$('div#checkLoginDiv').removeClass('has-warning').addClass("has-success");
				}else{
					$('div#checkLogin > span').removeClass("glyphicon-ok").addClass("glyphicon-warning-sign");
					$('div#checkLoginDiv').removeClass("has-success").addClass('has-warning');
				}
			},
			error: function(){
				console.log("ERROR");
			}
		})
	});
	
	$("input[name='submit']").on('click',function(e){
		if($('div#checkLoginDiv').hasClass('has-warning') || $('div#checkNicknameDiv').hasClass('has-warning')){
		e.preventDefault();
		
		}
	});
	
}(JQuery);