<!DOCTYPE html>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.connection.DBConnection"%>
<%@page import="java.sql.Connection"%>
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
					<li class="nav-item"><a class="nav-link" href="StockDetails.jsp"><em class="fa fa-bar-chart"></em>Stock Details</a></li>
					<li class="nav-item"><a class="nav-link" href="checkprediction.jsp"><em class="fa fa-bar-chart"></em>Check Prediction</a></li>
					<li class="nav-item"><a class="nav-link" href="LogoutController"><em class="fa fa-hand-o-up"></em>Logout</a></li>
				</ul>
				
				<a href="#" class="logout-button"></a></nav>
			
			<main class="col-xs-12 col-sm-8 offset-sm-4 col-lg-9 offset-lg-3 col-xl-10 offset-xl-2 pt-3 pl-4">
				<header class="page-header row justify-center">
					<div class="col-md-6 col-lg-8" >
						
					</div>
					
					<div class="dropdown user-dropdown col-md-6 col-lg-4 text-center text-md-right"><a id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<img src="images/Admin.png" alt="profile photo" class="circle float-left profile-photo" width="50" height="auto">
						
						<div>
							<h4>
							<% response.setContentType("text/html");
							  HttpSession sess=request.getSession(false);
							  
							  if(sess!=null)
							  {
								  String email=(String)session.getAttribute("email");
								  out.print(""+email+"");
							  }  
							%>
							</h4>
							
							
						</div>
						</a>
						
						<div class="dropdown-menu dropdown-menu-right" style="margin-right: 1.5rem;" aria-labelledby="dropdownMenuLink">
						     
						     <a class="dropdown-item" href="LogoutController"><em class="fa fa-power-off mr-1"></em> Logout</a></div>
					</div>
					
					<div class="clear"></div>
				</header>
				
				<section class="row">
					<div class="col-sm-12">
						<section class="row">
							<div class="col-md-12 col-lg-12">
								  <h4 class="text-upper col-md-offset-6" style="Color:#7376df"><center><b>Stock Details Table</b></center></h4><br>
                   <form class="subscription-form">
                    <div style="margin-left:20px;margin-right:20px">
                  <table border="1"  class="col-md-10">
<thead>
      
	<tr>
		<th style="color:red"> ID</th>
		
		<th style="color:red"> Open Price</th>
		<th style="color:red"> High Price</th>
		<th style="color:red"> Low Price</th>
		<th style="color:red"> Close Price</th>
		
		<th style="color:red"> Turn Over(Rs.Cr)</th>
		
	</tr>
</thead>
<tbody>
               <%
               try
                { 
            	   String company=request.getParameter("company");
                  DBConnection db=new DBConnection();
                  Connection connection=db.getConnection();
                  PreparedStatement pst=connection.prepareStatement("Select * from dataset5");
                  ResultSet rs=pst.executeQuery();
               %> 
           
                <% while(rs.next())
                {
                %>
              <tr>
		         <td><%=rs.getInt(1) %></td>
		         <td><%=rs.getString(3) %></td>
		         <td><%=rs.getString(4) %></td>
		         <td><%=rs.getString(5) %></td>
		         <td><%=rs.getString(6) %></td>
		         <td><%=rs.getString(7) %></td>
		        
		      </tr>   
               <%
                
                }
                
               %>

             <%
               }
               catch(Exception e)
               { 
              %>
  
               <%
                 out.println("Unable to connect to database.");
                }
              %>  
</tbody> 
</table>  
                    
                            
                  </form>
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
