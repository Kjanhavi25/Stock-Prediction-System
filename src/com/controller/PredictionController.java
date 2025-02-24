package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algorithm.Classifier;
import com.bean.DataBean;
import com.dao.UserDao;


@WebServlet("/PredictionController")
public class PredictionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PredictionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao ud=new UserDao();
		String company=request.getParameter("company");
		String data="";
		
		if(company.equals("Bajaj Electricals Ltd")){
			data="dataset1";
		}else if(company.equals("Idea Cellular Ltd")){
			data="dataset2";
		}else if(company.equals("Infosys Ltd")){
			data="dataset3";
		}else if(company.equals("State bank of India")){
			data="dataset4";
		}else{
			data="dataset5";
		}
		
		
		//Data
		ArrayList<DataBean> openprice = ud.selectOpenPrice(data);
		/*ArrayList<DataBean> openprice2 = ud.selectOpenPrice2();
		ArrayList<DataBean> openprice3 = ud.selectOpenPrice3();
		ArrayList<DataBean> openprice4 = ud.selectOpenPrice4();
		ArrayList<DataBean> openprice5 = ud.selectOpenPrice5();*/
		
		ArrayList<Double> openList =new ArrayList<Double>();
		ArrayList<Double> highList =new ArrayList<Double>();
		ArrayList<Double> lowList =new ArrayList<Double>();
		ArrayList<Double> closeList =new ArrayList<Double>();
		DataBean databean;
		
	
		for(int i=1;i<241;i++){
			databean= openprice.get(i);
			String val = databean.getOpenprice();
			openList.add(Double.parseDouble(val));
			String val1 = databean.getHighprice();
			highList.add(Double.parseDouble(val1));
			String val2 = databean.getLowprice();
			lowList.add(Double.parseDouble(val2));
			String val3 = databean.getCloseprice();
			closeList.add(Double.parseDouble(val3));
		}
		
		Classifier mr = new Classifier();
		ArrayList<Double> yList =new ArrayList<Double>();
		ArrayList<Double> x1List =new ArrayList<Double>();
		ArrayList<Double> x2List =new ArrayList<Double>();
		ArrayList<Double> x3List =new ArrayList<Double>();
		
		double sumx21=0,sumx32=0,sumyx3=0,sumyx2=0, sumx33=0,sumx31=0, sumx22=0, sumyx1=0, sumx11=0, Ybar=0, X1bar=0, X2bar=0, X3bar=0;
		double y=0;
		
		for(int i=1;i<240;i++){
			
			y= mr.calculateSmallOpen(openList.get(i), openList);
			Ybar= openList.get(i)-y;
			System.out.println("value of Ybar= "+Ybar);
			yList.add(y);
			System.out.println("value of small y= "+y);	
			double x1 = mr.calculateSmallHigh(highList.get(i), highList);
			X1bar=highList.get(i)-x1;
			System.out.println("value of X1bar= "+X1bar);
			x1List.add(x1);
			
			double x2 = mr.calculateSmallLow(lowList.get(i), lowList);
			X2bar=lowList.get(i)-x2;
			System.out.println("value of X2bar= "+X2bar);
			x2List.add(x2);
			
			double x3 = mr.calculateSmallClose(closeList.get(i), closeList);
			X3bar=closeList.get(i)-x3;
			System.out.println("value of X3bar= "+X3bar);
			x3List.add(x3);
			
			sumx21 +=x2*x1;
			sumx32 +=x3*x2;
			sumyx3 +=y*x3;
			
			sumyx2 +=y*x2;
			sumx33 +=x3*x3;
			
			sumx31 +=x3*x1;
			sumx22 +=x2*x2;
			
			sumyx1 +=y*x1;
			
			//formula for |A|
			
			sumx11 +=x1*x1;
			
			//sqrsumx32 += (x3*x2)
			
		}
		
		
		// formula for b1
		
		double b1= ((sumx21*sumx32*sumyx3)- (sumx21*sumyx2*sumx33)-(sumx31*sumx22*sumyx3)-(sumx31*sumyx2*sumx32)+(sumyx1*sumx22*sumx33)-(sumyx1*(sumx32*sumx32)))/((sumx11*sumx22*sumx33)-(sumx11*(sumx32*sumx32))-((sumx21*sumx21)*sumx33)+(sumx21*sumx31*sumx32)+(sumx31*sumx21*sumx32)-((sumx31*sumx31)*sumx22));
		System.out.println("value of b1= "+b1);
		// formula for b2
		
		double b2= -(((sumyx1*sumx31*sumx33)-(sumyx3*sumx11*sumx33)+(sumyx3*sumx32*sumx11)-(sumx31*((sumyx1*sumx32)-(sumyx2*sumx31)+(sumyx3*sumx21))))/((sumx11*sumx22*sumx33)-(sumx11*(sumx32*sumx32))-((sumx21*sumx21)*sumx33)+(sumx21*sumx31*sumx32)+(sumx31*sumx21*sumx32)-((sumx31*sumx31)*sumx22)));
		System.out.println("value of b2= "+b2);
		// formula for b3
		
		double b3= (-(sumyx1*sumx31*sumx22)-(sumyx2*sumx32*sumx11)+(sumyx3*sumx11*sumx22)+(sumx21*((sumyx1*sumx32)+(sumyx2*sumx31)-(sumyx3*sumx21))))/((sumx11*sumx22*sumx33)-(sumx11*(sumx32*sumx32))-((sumx21*sumx21)*sumx33)+(sumx21*sumx31*sumx32)+(sumx31*sumx21*sumx32)-((sumx31*sumx31)*sumx22));
		System.out.println("value of b3= "+b3);
		
		// formula for b0
		
		//double b0=Ybar-b1*X1bar-b2*X2bar-b3*X3bar;
		//System.out.println("value of b0= "+b0);		
		
		double b0=Ybar-b1*highList.get(0)-b2*lowList.get(0)-b3*closeList.get(0);
		
		
	
		
		System.out.println("value 1= "+highList.get(0));
		System.out.println("value 2= "+lowList.get(0));
		System.out.println("value 3= "+closeList.get(0));
		
		//Error term is the difference between the actual value of Y and its predicted value....
		//or error term or residuals=Y-Ybar...
		double e=y;
		
		double Y= b0+b1*highList.get(0)+b2*lowList.get(0)+b3*closeList.get(0)-e;
		
		
		System.out.println("value of Y= "+Y);	
		
		HttpSession session=request.getSession();
		
		 session.setAttribute("openprice", Y);
		 session.setAttribute("companyname", company);
		 response.sendRedirect("prediction.jsp");
		 


	}

}
