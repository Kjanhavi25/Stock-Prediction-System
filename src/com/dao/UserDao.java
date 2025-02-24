package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.Part;

import com.bean.DataBean;
import com.bean.KeyBean;
import com.bean.QuestionBean;
import com.bean.UserBean;
import com.connection.DBConnection;


import java.io.FileReader;
import java.security.SecureRandom;

import au.com.bytecode.opencsv.CSVReader;

public class UserDao {
	String sql;
	PreparedStatement ps;
	ResultSet rs;

	Connection con;
	boolean flag = false;

	public boolean InsertUserData(UserBean userbean) {
		sql = "insert into tbl_user(name,address,email,mobileno,dob,password,status,image,imagename) values(?,?,?,?,?,?,?,?,?)";

		con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, userbean.getName());
			ps.setString(2, userbean.getAddress());
			ps.setString(3, userbean.getEmail());
			ps.setString(4, userbean.getMobileno());
			ps.setString(5, userbean.getDob());
			ps.setString(6, userbean.getPassword());
			ps.setString(7, userbean.getStatus());
			ps.setBlob(8, userbean.getImage());
			ps.setString(9, userbean.getImage_name());

			int index = ps.executeUpdate();

			if (index > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}
	
	public ArrayList<DataBean> selectOpenPrice(String data) {
		// TODO Auto-generated method stub
		
		ArrayList<DataBean> openprice = new ArrayList<DataBean>();
		con = DBConnection.getConnection();
		String sql = "Select * from "+data;
		System.out.println("Query=====" +sql);
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				DataBean bean = new DataBean();
				bean.setId(rs.getInt(1));
				bean.setDate(rs.getString(2));
				bean.setOpenprice(rs.getString(3));
				bean.setHighprice(rs.getString(4));
				bean.setLowprice(rs.getString(5));
				bean.setCloseprice(rs.getString(6));
				
				openprice.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return openprice;
	}
	public boolean InsertKey(KeyBean bean) {
		
		sql = "insert into tbl_key(email,filename,filekey) values(?,?,?)";

		con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, bean.getEmail());
			ps.setString(2, bean.getFilename());
			ps.setString(3, bean.getFilekey());

			int index = ps.executeUpdate();

			if (index > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}

	public String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		System.out.println("contentDisp:" + contentDisp);
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

	public boolean alreadyUser(String email) throws SQLException {
		String sql = "select * from tbl_user where email=?";
		con = DBConnection.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, email);
		rs = ps.executeQuery();
		if (rs.next()) {
			flag = true;
		}
		return flag;
	}

	public UserBean CheckUser(String email, String password) {

		UserBean bean = new UserBean();
		sql = "select * from tbl_user where email='" + email + "' and password='" + password + "' ";
		try {
			Statement stmt = DBConnection.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {

				bean.setName(rs.getString(2));
				bean.setAddress(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setMobileno(rs.getString(5));
				bean.setDob(rs.getString(6));
				bean.setPassword(rs.getString(7));
				bean.setStatus(rs.getString(8));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return bean;
	}

	public boolean UpdateUserStatus(int userId, String status) {
		if (status.equalsIgnoreCase("Inactive"))
			status = "Active";
		else
			status = "Inactive";

		String sql = "update tbl_user set status=? where id=?";

		try {
			ps = DBConnection.getConnection().prepareStatement(sql);
			ps.setString(1, status);
			ps.setInt(2, userId);

			int index = ps.executeUpdate();
			if (index > 0) {
				flag = true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}

	public ResultSet SelectUser() {

		ResultSet rs = null;
		String sql = "Select * from tbl_user";
		try {
			PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return rs;
	}

	public boolean DeleteUser(int id) {

		String sql = "delete from tbl_user where id='" + id + "'";
		Connection con = DBConnection.getConnection();
		try {
			ps = con.prepareStatement(sql);
			int index = ps.executeUpdate();
			if (index > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	public boolean UpdateUserPassword(String oldpass, String newpass) {

		sql = "update tbl_user set password=? where password='" + oldpass + "'";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, newpass);

			int index = ps.executeUpdate();

			if (index > 0) {
				flag = true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return flag;
	}

	public UserBean SelectUserPassword(String email) {

		UserBean bean = new UserBean();

		sql = "select * from tbl_user where email='" + email + "'";

		Connection con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				bean.setName(rs.getString(2));
				bean.setAddress(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setMobileno(rs.getString(5));
				bean.setDob(rs.getString(6));
				bean.setPassword(rs.getString(7));
				bean.setStatus(rs.getString(8));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return bean;

	}

	public boolean InsertQuestion(QuestionBean bean) {
		
		sql = "insert into tbl_question(name,email,question) values(?,?,?)";

		con = DBConnection.getConnection();

		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, bean.getName());
			ps.setString(2, bean.getEmail());
			ps.setString(3, bean.getQuestion());

			int index = ps.executeUpdate();

			if (index > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return flag;
	}
	
	public String key()
	{
		
		char[] characterSet = "134".toCharArray();
		int length=3;
		int data=16;
		String filekey=null;
						
			 Random random1 = new SecureRandom();
			    char[] result = new char[length];
			    for (int i = 0; i < result.length; i++) {
			       
			        int randomCharIndex = random1.nextInt(characterSet.length);
			        result[i] = characterSet[randomCharIndex];
			    }
			    filekey=new String(result);
				return filekey;

	}
	
	public String key1()
	{
		
		char[] characterSet = "345".toCharArray();
		int length=2;
		int data=16;
		String filekey=null;
						
			 Random random1 = new SecureRandom();
			    char[] result = new char[length];
			    for (int i = 0; i < result.length; i++) {
			       
			        int randomCharIndex = random1.nextInt(characterSet.length);
			        result[i] = characterSet[randomCharIndex];
			    }
			    filekey=new String(result);
				return filekey;

	}
}
