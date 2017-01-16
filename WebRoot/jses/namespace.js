(function($){
	$.namespace=function(namespaceStr){
		var arr=namespaceStr.split(".");
		var temp=[];
		for(var i=0;i<arr.length;i++){
			temp.push(arr[i]);
			eval("("+"window."+temp.join(".")+"={}"+")");
		}
	};
})($);
