package com.algorithm;

import java.util.ArrayList;

public class Classifier {

	
	public double calculateSmallOpen(Double double1, ArrayList<Double> openList) {
		// TODO Auto-generated method stub
		double y = 0,sum=0,Ybar=0;
	
		for(int i=0;i<openList.size();i++){
			sum += openList.get(i);
		}
		
		Ybar = sum/openList.size();
		//System.out.println("value of Ybar In MulRegression= "+Ybar);
		y=double1-Ybar;
		return y;
	}
	public double calculateSmallHigh(Double double1, ArrayList<Double> highList) {
		// TODO Auto-generated method stub
		double x1 = 0,sum=0,X1bar=0;
		
		for(int i=0;i<highList.size();i++){
			sum += highList.get(i);
		}
		
		X1bar = sum/highList.size();
		x1=double1-X1bar;
		return x1;
	}
	public double calculateSmallLow(Double double1, ArrayList<Double> lowList) {
		// TODO Auto-generated method stub
		double x2 = 0,sum=0,X2bar=0;
		
		for(int i=0;i<lowList.size();i++){
			sum += lowList.get(i);
		}
		
		X2bar = sum/lowList.size();
		x2=double1-X2bar;
		return x2;
	}
	public double calculateSmallClose(Double double1, ArrayList<Double> closeList) {
		// TODO Auto-generated method stub
		double x3 = 0,sum=0,X3bar=0;
		
		for(int i=0;i<closeList.size();i++){
			sum += closeList.get(i);
		}
		
		X3bar = sum/closeList.size();
		x3=double1-X3bar;
		return x3;
	}
	
	
}
