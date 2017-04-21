// JavaScript Document
jQuery(document).ready(function($) {
    	
	//TODO  注册是shengshi
	$(".register").click(function(){
		
		$.get("/On-Line_Study/IndexDoorServlet?method=getAllClass",function(result){
			var arr=JSON.parse(result); 
			for(var l=0;l<arr.length;l++){
				var opx= document.createElement("option");
				opx.value = arr[l].classId;//设置op实际值为当前省份名称
				var textNodex = document.createTextNode(arr[l].className);//设置显示的值
				opx.appendChild(textNodex);
				document.getElementById("classname").appendChild(opx);//添加到下拉框
			}

		})

		$.get("/On-Line_Study/UserServlet?method=GetProvince",function(result){
			var arr = result.split(",");
			for (var i = 0; i < arr.length; i = i + 2) {
				var op = document.createElement("option");
				op.value = arr[i];//设置op实际值为当前省份名称
				var textNode = document.createTextNode(arr[i + 1]);//设置显示的值
				op.appendChild(textNode);
				document.getElementById("province").appendChild(op);//添加到下拉框
			}
		});
			var citySelect = document.getElementById("province");
			citySelect.onchange = function() {
				$.post("/On-Line_Study/UserServlet",{method:'GetCity','provinceID':citySelect.value},function(text){
					//移除上一次的市
					var citySelect = document.getElementById("city");
					var optionElelist = citySelect
							.getElementsByTagName("option");
					while (optionElelist.length > 1) {//大于1移除，等于1就是“请选择”
						citySelect.removeChild(optionElelist[1]);
					}
					var arr = text.split(",");
					for (var i = 0; i < arr.length; i = i + 2) {
						var op = document.createElement("option");
						op.value = arr[i];//设置op实际值为当前省份名称
						var textNode = document.createTextNode(arr[i + 1]);//设置显示的值
						op.appendChild(textNode);
						document.getElementById("city").appendChild(op);//添加到下拉框
					}
				})
			
			};
		
	})
	
	
    /* ======= jQuery Placeholder ======= */
    $('input, textarea').placeholder();    
    
    /* ======= Scrollspy ======= */
    $('body').scrollspy({ target: '#header', offset: 300});
   
    /* ======= ScrollTo ======= */
    $('a.scrollto').on('click', function(e){
    
        //store hash
        var target = this.hash;
                
        e.preventDefault();

		
		var nOffsetVal = 0;
		if( $('html').width() < 768 ){
    		nOffsetVal = -216;
		}else if( $('html').width() > 991 ){
    		nOffsetVal = -69;
		}
		
		$('body').scrollTo(target, 900, {offset: nOffsetVal, 'axis':'y', easing:'easeOutQuad'});
        //Collapse mobile menu after clicking
		if ($('.navbar-collapse').hasClass('in')){
			$('.navbar-collapse').removeClass('in').addClass('collapse');
		}

		
	});
	
	
	$('a.btn-scrollto').on('click', function(e){
    
        //store hash
        var target = this.hash;
                
        e.preventDefault();

		
		var nOffsetVal = 0;
		if( $('html').width() > 991 ){
    		nOffsetVal = -69;
		}
		
		$('body').scrollTo(target, 900, {offset: nOffsetVal, 'axis':'y', easing:'easeOutQuad'});

		
	});
	
	
	
    
    /* ======= Fixed header when scrolled ======= */
    

	    
	    
            $(window).on('scroll', function(){
                
                if ( $(window).width() > 991 ){
            
                    if($(document).scrollTop() > 0)
                        {
                            if(!$('#header').hasClass('navbar-fixed-top'))
                            {
                                $('#header').addClass('navbar-fixed-top');
                                $('#header').stop().animate({
                                    paddingTop:'15px'
                                    
                                },600);
                            }
                        }
                        else
                        {
                            if($('#header').hasClass('navbar-fixed-top'))
                            {
                                $('#header').removeClass('navbar-fixed-top');
                                $('#header').stop().animate({
                                    paddingTop:'30px'
                                    
                                },600);
                            }
                        }
                    
                  }
            });	              
	        

    
    /* ======= Page preloader ======= */
    
    $(window).load(function(){
        $('#page-preloader').fadeOut(800); 
    });
    
});