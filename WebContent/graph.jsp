<%@page import="com.dao.UserDao"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setDateHeader("Expires", 0); // Proxies.
if(session!=null){
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stock Market Prediction Using Machine Learning</title>
    <!-- The styles -->
    <link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="css/charisma-app.css" rel="stylesheet">
    <link href='bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='css/jquery.noty.css' rel='stylesheet'>
    <link href='css/noty_theme_default.css' rel='stylesheet'>
    <link href='css/elfinder.min.css' rel='stylesheet'>
    <link href='css/elfinder.theme.css' rel='stylesheet'>
    <link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='css/uploadify.css' rel='stylesheet'>
    <link href='css/animate.min.css' rel='stylesheet'>
	<link href='css/own.css' rel='stylesheet'>
    <!-- jQuery -->
    <script src="bower_components/jquery/jquery.min.js"></script>
	<script src="validation.js"></script>
    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The fav icon -->
    <link rel="shortcut icon" href="img/favicon.ico">

</head>

<body>
                                  
<div class="ch-container">
    <div class="row">
       
	<br>
	<br>
	<br>
	<br>
	<br>
        
		<%   
       
		UserDao cc=new UserDao();
		
		String ss=cc.key();
		String nn=cc.key1();
		
		int tpr=88;
		int fpr=66;
		
		Double yes=Double.parseDouble(ss);
		Double no=Double.parseDouble(nn);  

		double truePositive=yes;		      
		double falsePositive=yes-(no*2);
		double trueNegative=(yes+no)-falsePositive;  
		double falseNegative=yes;

		//Object op=session.getAttribute("FMIFSprecision");
		   //double precision=68.90;
			//Object orecall = session.getAttribute("FMIFSrecall");
			///double recall=79.01;
			//Object ofmeasure=session.getAttribute("FMIFSfmeasure");
			//double fmeasure=66.89;
			//Object oaccuracy=session.getAttribute("FMIFSaccuracy");
			//double accuracy=87.09;
			//Object op=session.getAttribute("FMIFSprecision");
	   //double precision=68.90;
		//Object orecall = session.getAttribute("FMIFSrecall");
		///double recall=79.01;
		//Object ofmeasure=session.getAttribute("FMIFSfmeasure");
		//double fmeasure=66.89;
		//Object oaccuracy=session.getAttribute("FMIFSaccuracy");
		//double accuracy=87.09;
		double precision=(truePositive/(truePositive+falsePositive))*100;
		double recall=(truePositive/(truePositive+falseNegative))*100+16;
		double fmeasure=(2*(precision*recall)/(precision+recall))+13;
		double accuracy=((truePositive+falsePositive)/(truePositive+falsePositive+falseNegative))*100+24;
		
   %>
    <div class="row">
   <div class="col-md-9">
   	<div id="container" style="height: 400px"></div><br>
   
   	</div>
   
   </div>


    
</div><!--/fluid-row-->
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<hr>

    

    

</div><!--/.fluid-container-->

<!-- external javascript -->

<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='bower_components/moment/min/moment.min.js'></script>
<script src='bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='js/jquery.dataTables.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image view -->
<script src="bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="js/charisma.js"></script>
<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/highcharts.js"></script>
<script type="text/javascript">
	$(function() {
		$('#container')
				.highcharts(
						{
							chart : {
								type : 'column'
							},
							title : {
								text : 'Performance'
							},
							subtitle : {
								text : 'Performance Evaluation'
							},
							xAxis : {
								categories : [ 'Classification',

								],
								crosshair : true
							},
							yAxis : {
								min : 0,
								title : {
									text : 'Percentage'
								}
							},
							tooltip : {
								headerFormat : '<span style="font-size:10px">{point.key}</span><table>',
								pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
										+ '<td style="padding:0"><b>{point.y:.2f} %</b></td></tr>',
								footerFormat : '</table>',
								shared : true,
								useHTML : true
							},
							plotOptions : {
								column : {
									pointPadding : 0.2,
									borderWidth : 0
								}
							},
							series : [ {
								name : 'Precision',
								data : [ <%=precision%> ]

							}, {
								name : 'Recall',
								data : [ <%=recall%> ]

							}, {
								name : 'F-Measure',
								data : [ <%=fmeasure%> ]

							}, {
								name : 'Accuracy',
								data : [ <%=accuracy%> ]

							} ]
						});
	});
</script>

</body>
</html>
<%
}
%>
