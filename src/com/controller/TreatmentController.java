package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TreatmentController")
public class TreatmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public TreatmentController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		String c1=request.getParameter("bp1");
		System.out.println("C1:"+c1);
		String c2=request.getParameter("bp2");
		System.out.println("C2:"+c2);
		String c3=request.getParameter("bp3");
		System.out.println("C3:"+c3);
		String c4=request.getParameter("bp4");
		System.out.println("C4:"+c4);
		String c5=request.getParameter("bp5");
		System.out.println("C5:"+c5);
		String c6=request.getParameter("bp6");
		System.out.println("C6:"+c6);
		String c7=request.getParameter("bp7");
		System.out.println("C7:"+c7);
		String c8=request.getParameter("bp8");
		System.out.println("C8:"+c8);
		String c9=request.getParameter("bp9");
		System.out.println("C9:"+c9);
		String c10=request.getParameter("bp10");
		System.out.println("C10:"+c10);
		String c11=request.getParameter("bp11");
		System.out.println("C11:"+c11);
		
		if("Chest Pain and Chest Pressure".equalsIgnoreCase(c1))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Need to do the Blood Tests and ECG')");
			out.println("location='HeartDisease.jsp';");
			out.println("</script>");
		}
		else if("Shortness of Breath".equalsIgnoreCase(c2)&& "Weakness".equalsIgnoreCase(c3))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Need to do Holter Monitor or Table Test')");
			out.println("location='HeartDisease.jsp';");
			out.println("</script>");
		}
		else if("Weakness".equalsIgnoreCase(c3)&& "Pain in Neck,Jaw,Throat".equalsIgnoreCase(c4))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Need to do Antibiotics and Initial Treatment and blood tests')");
			out.println("location='HeartDisease.jsp';");
			out.println("</script>");
		}
		else if("Shortness of Breath".equalsIgnoreCase(c2)|| "Weakness".equalsIgnoreCase(c3) && "Weakness or Coldness in Legs".equalsIgnoreCase(c6))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Need to do Holter Monitor and ECG')");
			out.println("location='HeartDisease.jsp';");
			out.println("</script>");
		}
		else if("Pain in Neck,Jaw,Throat".equalsIgnoreCase(c4)|| "Weakness".equalsIgnoreCase(c3) && "Weakness or Coldness in Legs".equalsIgnoreCase(c6))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Need to do Antibiotics and ECG')");
			out.println("location='HeartDisease.jsp';");
			out.println("</script>");
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Choose another option')");
			out.println("location='UserHome.jsp';");
			out.println("</script>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
