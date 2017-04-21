// JavaScript Document
jQuery(document).ready(function($) {
    	
	//TODO  ע����shengshi
	$(".register").click(function(){
		
		$.get("/On-Line_Study/IndexDoorServlet?method=getAllClass",function(result){
			var arr=JSON.parse(result); 
			for(var l=0;l<arr.length;l++){
				var opx= document.createElement("option");
				opx.value = arr[l].classId;//����opʵ��ֵΪ��ǰʡ������
				var textNodex = document.createTextNode(arr[l].className);//������ʾ��ֵ
				opx.appendChild(textNodex);
				document.getElementById("classname").appendChild(opx);//��ӵ�������
			}

		})

		$.get("/On-Line_Study/UserServlet?method=GetProvince",function(result){
			var arr = result.split(",");
			for (var i = 0; i < arr.length; i = i + 2) {
				var op = document.createElement("option");
				op.value = arr[i];//����opʵ��ֵΪ��ǰʡ������
				var textNode = document.createTextNode(arr[i + 1]);//������ʾ��ֵ
				op.appendChild(textNode);
				document.getElementById("province").appendChild(op);//��ӵ�������
			}
		});
			var citySelect = document.getElementById("province");
			citySelect.onchange = function() {
				$.post("/On-Line_Study/UserServlet",{method:'GetCity','provinceID':citySelect.value},function(text){
					//�Ƴ���һ�ε���
					var citySelect = document.getElementById("city");
					var optionElelist = citySelect
							.getElementsByTagName("option");
					while (optionElelist.length > 1) {//����1�Ƴ�������1���ǡ���ѡ��
						citySelect.removeChild(optionElelist[1]);
					}
					var arr = text.split(",");
					for (var i = 0; i < arr.length; i = i + 2) {
						var op = document.createElement("option");
						op.value = arr[i];//����opʵ��ֵΪ��ǰʡ������
						var textNode = document.createTextNode(arr[i + 1]);//������ʾ��ֵ
						op.appendChild(textNode);
						document.getElementById("city").appendChild(op);//��ӵ�������
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