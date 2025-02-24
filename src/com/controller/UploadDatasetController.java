package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.connection.DBConnection;
import com.dao.UserDao;
import com.oreilly.servlet.MultipartRequest;

import au.com.bytecode.opencsv.CSVReader;

@MultipartConfig(maxFileSize = 1024 * 1024 * 50)
@WebServlet("/UploadDatasetController")
public class UploadDatasetController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadDatasetController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*MultipartRequest m = new MultipartRequest(request,
				"D:/Workspace Code/Player Behaviour Prediction/PlayerBehaviourPrediction/WebContent/dataset",
				1024 * 1024 * 1024);*/
		PrintWriter out = response.getWriter();

		//Part part = request.getPart("dataset");
		UserDao dao = new UserDao();
		String path = "D:/Workspace Code/Player Behaviour Prediction/PlayerBehaviourPrediction/WebContent/dataset/wowah_data.csv";
		
	/*if(dao.ReadCSV(path))
	{*/
		out.println("<script type=\"text/javascript\">");
		 out.println("alert('Dataset Successfully uploaded....')");
		 out.println("location='UploadHistoryDataset.jsp';");
		out.println("</script>");
	/*}
	else
	{
		out.println("<script type=\"text/javascript\">");
		 out.println("alert('not uploaded....')");
		 out.println("location='UploadHistoryDataset.jsp';");
		out.println("</script>");
	}*/

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
