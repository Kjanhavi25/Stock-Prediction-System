<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<meta name="description" content="">
	
	<meta name="author" content="">
	
	<link rel="icon" href="images/favicon.ico">
	
	<title>Stock Market Prediction Using Machine Learning</title>

    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.min.css" rel="stylesheet">

    <!--Fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
    
    <!-- Icons -->
    <link href="css/font-awesome.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid" id="wrapper">
		<div class="row">
			<nav class="sidebar col-xs-12 col-sm-4 col-lg-3 col-xl-2 bg-faded sidebar-style-1">
				<h1 class="site-title"><a href="index.jsp"><em class="fa fa-rocket"></em>STOCK</a></h1>
				
				<a href="#menu-toggle" class="btn btn-default" id="menu-toggle"><em class="fa fa-bars"></em></a>
				
				<ul class="nav nav-pills flex-column sidebar-nav">
					
				
					<li class="nav-item"><a class="nav-link" href="UserHome.jsp"><em class="fa fa-calendar-o"></em>Home</a></li>
					<li class="nav-item"><a class="nav-link" href="UserProfile.jsp"><em class="fa fa-bar-chart"></em>My Profile</a></li>
					<li class="nav-item"><a class="nav-link" href="stockdetails.jsp"><em class="fa fa-bar-chart"></em>Stock Details</a></li>
					<li class="nav-item"><a class="nav-link" href="checkprediction.jsp"><em class="fa fa-bar-chart"></em>Check Prediction</a></li>
					<li class="nav-item"><a class="nav-link" href="LogoutController"><em class="fa fa-hand-o-up"></em>Logout</a></li>
					
				</ul>
				
				<a href="#" class="logout-button"></a></nav>
			
			<main class="col-xs-12 col-sm-8 offset-sm-4 col-lg-9 offset-lg-3 col-xl-10 offset-xl-2 pt-3 pl-4">
				<header class="page-header row justify-center">
					<div class="col-md-6 col-lg-8" >
						<h1 class="float-left text-center text-md-left" style="color:#6365d2"></h1>
					</div>
					
					<div class="dropdown user-dropdown col-md-6 col-lg-4 text-center text-md-right"><a id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						
						
						
					</div>
					
					<div class="clear"></div>
				</header>
				<%
                Double oprice=(Double)session.getAttribute("openprice");
                String company=(String)session.getAttribute("companyname");
               
                 %>
				<section class="row">
					<div class="col-sm-12">
						<section class="row">
							<div class="col-lg-offset-3 col-md-12 col-lg-9">
								<div class="jumbotron">
									<h1 class="mb-4"><center>Prediction Result</center></h1>
									<div class="card mb-4">
									<div class="card-block">
										
										
										<div class="dropdown card-title-btn-container">
											<button class="btn btn-sm btn-subtle dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><em class="fa fa-cog"></em></button>
											
											<div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton"><a class="dropdown-item" href="#"><em class="fa fa-search mr-1"></em> More info</a>
												<a class="dropdown-item" href="#"><em class="fa fa-thumb-tack mr-1"></em> Pin Window</a>
												<a class="dropdown-item" href="#"><em class="fa fa-remove mr-1"></em> Close Window</a></div>
										</div>
										
										
										
										<form class="form-horizontal" action="PredictionController" method="post">
											<fieldset>
												<!-- Name input-->
												<div class="form-group">
													 <table border="10"  align="center" class="col-md-8">
       <thead>
      <center>
	   <tr>
		<th  align="center"> Open Stock Price of <%=company %></th><th align="center"><%=oprice %></th>
	    </tr>
	  </center>
	    </thead>
	    </table>
												</div>
											
												
												
											
												<!-- Form actions -->
												<div class="form-group">
													<div class="col-12 widget-right no-padding">
													
														<a href="Graph1.jsp" class="btn btn-primary btn-md float-right">Accuracy Graph</a>
													</div>
												</div>
											</fieldset>
										</form>
									</div>
								</div>
									
									
									
									
								</div>
								</div>
							
					
						</section>
						
					</div>
				</section>
			</main>
		</div>
	</div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="dist/js/bootstrap.min.js"></script>
    
    <script src="js/chart.min.js"></script>
    <script src="js/chart-data.js"></script>
    <script src="js/easypiechart.js"></script>
    <script src="js/easypiechart-data.js"></script>
    <script src="js/bootstrap-datepicker.js"></script>
    <script src="js/custom.js"></script>
    <script>
	    window.onload = function () {
	var chart1 = document.getElementById("line-chart").getContext("2d");
	window.myLine = new Chart(chart1).Line(lineChartData, {
	responsive: true,
	scaleLineColor: "rgba(0,0,0,.2)",
	scaleGridLineColor: "rgba(0,0,0,.05)",
	scaleFontColor: "#c5c7cc"
	});
};
	</script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    
	  </body>
</html>
