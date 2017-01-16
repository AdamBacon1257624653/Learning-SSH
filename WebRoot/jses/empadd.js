$(function(){
	/**
	 * 邮箱AJAX验证
	 * @param {Object} this
	 */
	
    $("body").delegate("input[name=email]","change",function(){
		var $input=$(this);
		var value=$(this).val();
		$input.nextAll("font").remove();
		$.post("empValidateEmail",{
			email:value,
		},function(data){
			if(data=="0"){
				$input.after("<font color='red'>邮箱格式不正确</font>");
			}else if(data=="1"){
				$input.after("<font color='red'>邮箱已绑定</font>");
			}else{
				$input.after("<font color='green'>正确</font>");
			}
		});
	});
	
	$("body").delegate("input[name=lastName]","change",function(){
		var value=$(this).val();
		value=$.trim(value);
		$(this).nextAll("font").remove();
		if(value==""){
			$(this).after("<font color='red'>LastName不能为空</font>");
		}else{
			$(this).after("<font color='green'>正确</font>");
		}
	});
});
