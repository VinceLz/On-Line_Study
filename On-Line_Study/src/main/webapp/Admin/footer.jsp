<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'footer.jsp' starting page</title> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <!--footer start-->
      <footer class="site-footer">
          <div class="text-center">
              2014 - Alvarez.is  <a href="http://www.mycodes.net/" target="_blank">智源之家</a> <a href="http://www.mycodes.net/" target="_blank">智源之家</a>
              <a href="index.html#" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
      
      <!--footer end-->
      <script src="/On-Line_Study/Admin/assets/js/jquery.js"></script>
    <script src="/On-Line_Study/Admin/assets/js/jquery-1.8.3.min.js"></script>
    <script src="/On-Line_Study/Admin/assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="/On-Line_Study/Admin/assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="/On-Line_Study/Admin/assets/js/jquery.scrollTo.min.js"></script>
    <script src="/On-Line_Study/Admin/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="/On-Line_Study/Admin/assets/js/jquery.sparkline.js"></script>
    <script src="/On-Line_Study/Admin/assets/js/common-scripts.js"></script>
    <script type="text/javascript" src="/On-Line_Study/Admin/assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="/On-Line_Study/Admin/assets/js/gritter-conf.js"></script>
    <script src="/On-Line_Study/Admin/assets/js/sparkline-chart.js"></script>    
	<script src="/On-Line_Study/Admin/assets/js/zabuto_calendar.js"></script>	

	<script type="application/javascript">
        $(document).ready(function () {
            $("#date-popover").popover({html: true, trigger: "manual"});
            $("#date-popover").hide();
            $("#date-popover").click(function (e) {
                $(this).hide();
            });
        
            $("#my-calendar").zabuto_calendar({
                action: function () {
                    return myDateFunction(this.id, false);
                },
                action_nav: function () {
                    return myNavFunction(this.id);
                },
                ajax: {
                    url: "show_data.php?action=1",
                    modal: true
                },
                legend: [
                    {type: "text", label: "Special event", badge: "00"},
                    {type: "block", label: "Regular event", }
                ]
            });
        });
        
        
        function myNavFunction(id) {
            $("#date-popover").hide();
            var nav = $("#" + id).data("navigation");
            var to = $("#" + id).data("to");
            console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
        }
    </script>
  </body>
</html>
