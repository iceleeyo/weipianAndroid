function jiesuan(fdShopCartId){
	var params={};
	params["fdShopNo"]=fdShopNo;
	params["fdAddressId"]=fdAddressId;
	params["fdShopCartId"]=fdShopCartId.join();
	params["fdRemark"]=$(".fdReplyContent").val();
	$.ajax({
	  type: "POST",
	  url: hxltUrl+"wxajax/jiesuan",
	   contentType:'application/x-www-form-urlencoded;charset=UTF-8',
	  data:params,
	  dataType: "json",
	  success: function(result){
	 	if(result.status == 0){
	 		window.location.href=hxltUrl+"wx/pay?fdShopNo="+fdShopNo+"&fdOrderId="+result.fdOrderId;
		}
	  }
	});
}

$(function(){
	var fdShopCartId=[];
	$(".odmg-item").each(function(){
		var fdId=$(this).attr("fdId");
		fdShopCartId.push(fdId);
	});
	var url=hxltUrl+"wx/jiesuan?fdShopNo="+fdShopNo+"&fdShopCartId="+fdShopCartId.join();
	$(".userNoAddressTip").on("click",function(){
		window.location.href=hxltUrl+"wx/addAddress?fdShopNo="+fdShopNo+"&backUrl="+encodeURIComponent(url);
	});
	$(".odmi_right_head").on("click",function(){
		if(hasAddress=="0"){
			window.location.href=hxltUrl+"wx/addAddress?fdShopNo="+fdShopNo+"&backUrl="+encodeURIComponent(url);
		}else{
			window.location.href=hxltUrl+"wx/selectAddress?fdShopNo="+fdShopNo+"&backUrl="+encodeURIComponent(url);
		}
	});
	
	$(".confirmBtn").on("click",function(){
		if(!fdAddressId){
			alert("请选择收货地址!");
			return ;
		}
		jiesuan(fdShopCartId);
	});
	
});