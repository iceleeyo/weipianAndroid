var loadSelect=function($select){
	var value=$select.attr("dictValue");
	var fdId=$select.attr("dictKey");
	var text=$select.attr("dictText");
	var params={};
	params["fdId"]=fdId;
	$.ajax({
        type:'POST',
        url:hxltUrl+"SysDictAction/getListByParentId",
        data:params,
        contentType:'application/x-www-form-urlencoded;charset=UTF-8',
        dataType: "json",
        success: function(data){
        	if(data.success){
        		if(data.list.length>0){
        			var str='<option value="">请选择----</option>';
					$select.append(str);
        			for(var i=0;i<data.list.length;i++){
        				var item=data.list[i];
        				var str='<option value="'+item.value+'">'+item.text+'</option>';
						$select.append(str);
        			}
        			if(value){
        				var selectItem=$select.find("option[value='"+value+"']");
        				selectItem.attr("selected","selected");
        				$(text).val(selectItem.html());
        			}else{
        				var selectItem=$select.find("option:eq(0)");
        				if(selectItem.length>0){
        					selectItem.attr("selected","selected");
        					$(text).val(selectItem.html());
        				}
        			}
        				$select.on("change",function(){
        					$(text).val($select.find("option:selected").html());
	        			});
	        		}
	        	}
	        }
	});
}
var inputChange=function($item){
	var datatype=$item.attr("datatype");
	$item.removeClass("redInput");
	if(!$item.val()){
		if(datatype){
			$item.addClass("redInput");
			return false;
		}
	}
	return true;
}

var saveUserMessage=function(p){
	var params={};
	params["fdUserId"]=fdUserId;
	params["fdUserMessage"]=p;
	$.ajax({
        type:'POST',
        url:hxltUrl+"wxajax/saveUserMessage",
        data:params,
        contentType:'application/x-www-form-urlencoded;charset=UTF-8',
        dataType: "json",
        success: function(data){
        	if(data.status==0) {
				window.location.href=hxltUrl+"wx/mycard?fdShopNo="+fdShopNo;
			} else {
				alert(data.msg);
			}
        }
	});
}
var message;
$(function(){
	if(fdUserMessage){
		message=$.parseJSON(fdUserMessage);
		for(var key in message){
			var a=message[key];
			var $input=$("input[name='"+key+"']");
			if($input.length==0){
				$input=$("select[name='"+key+"']");
				$("select[name='"+key+"']").attr("dictValue",a[0]);
				loadSelect($input);
			}
			if($input.length==0){
				$input=$("textarea[name='"+key+"']");
			}
			if(a){
				$input.val(a[0]);
				if(a.length>1){
					var datatype="";
					if($input.find("datatype")){
						datatype='datatype="*"';
					}
					var pp=$input.parent().parent();
					for(var k=1;k<a.length;k++){
						var data={
							"name":$input.attr("name"),
							"datatype":datatype,
							"value":a[k],
							"placeholder":$input.attr("placeholder")
						};
						var str=TemplateUtils.getTemplate("#inputTemplate",data);
						pp.append(str);
					}
				}
			}
		}
	}else{
		$("select[dictkey]").each(function(){
			loadSelect($(this));
		});
	}
	$(".addMessage").on("click",function(){
		var p=$(this).parent();
		var pp=p.parent();
		if(pp.find(".wrcard-inputItem").length<3){
			var $input=p.find("input");
			var datatype="";
			if($input.find("datatype")){
				datatype='datatype="*"';
			}
			var data={
				"name":$input.attr("name"),
				"datatype":datatype,
				"value":"",
				"placeholder":$input.attr("placeholder")
			};
			var str=TemplateUtils.getTemplate("#inputTemplate",data);
			pp.append(str);
		}
	});
	$(".jianMessage").live("click",function(){
		var p=$(this).parent();
		p.remove();
	});
	
	$(".wrcard-inputItem input,.wrcard-inputItem select").on("change",function(){
		inputChange($(this));
	});
	
	$(".wrcard-inputItem input,.wrcard-inputItem select").live("change",function(){
		inputChange($(this));
	});
	
	$(".wrcard-saveBtn").on("click",function(){
		var flag=true;
		var params={};
		$(".wrcard-inputItem input,.wrcard-inputItem select,.wrcard-inputItem textarea").each(function(){
			if(!inputChange($(this))){
				flag=false;
			}
			var name=$(this).attr("name");
			var a=[];
			if(params[name]){
				a=params[name];
			}
			a.push($(this).val());
			params[name]=a;
		});
		if(flag){
			var p=JSON.stringify(params); 
			saveUserMessage(p);
		}else{
			alert("请填写完整信息");
		}
	});
});