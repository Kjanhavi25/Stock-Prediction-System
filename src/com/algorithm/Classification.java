package com.algorithm;

public class Classification {

	public static double covariance(double[] x, double[] y) {
		
		  // Get the means of the x and y data first
		
		  double xmean = mean(x);
		
		  double ymean = mean(y);
		
		 
		
		  double result = 0;
		
		  // loop through from i = 0 to the length of the data set (N in the formula)
		
		  for (int i = 0; i < x.length; i++) {
		
		      // Perform the calculation in the formula, adding each time to the result variable to get the final sum
		
		      result += (x[i] - xmean) * (y[i] - ymean);
		
		  }
		
		 
		
		  // Finally divide by the data set - 1 to get our final result
		
		  result /= x.length - 1;
		
		 
		
		  return result;
		
		}
		
		 
		
		// Calculate the mean of an array of data
		
		public static double mean(double[] data)
		{
	
		  double sum = 0;
	
		 
		
		  for (int i = 0; i < data.length; i++) 
		  {
	
		    sum += data[i];
		
		  }
		
		 
		
		  return sum / data.length;
		
		}

}
