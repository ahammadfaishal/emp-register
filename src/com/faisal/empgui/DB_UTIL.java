package com.faisal.empgui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class DB_UTIL {
	private Connection dbConnection;

	public DB_UTIL() {
		dbConnection = DbConnector.getDBConnection();
	}

	public void closeDB() {
		try {
			dbConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int checkUser(String uname, String pass) {
		Connection dbConnection = null;
		Statement statement = null;
		int count = 0;
		try {

			dbConnection = DbConnector.getDBConnection();
			if (dbConnection == null)
				System.exit(1);
			String sql = "SELECT username from user_info " + "where username = '" + uname + "' and password = '" + pass
					+ "'";
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				count++;
			}
			if (statement != null)
				statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "DB Connection Failed!", "DB Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return count;
	}

	public void insertDistrict(int divId, String distName) {
		Connection dbConnection = null;
		Statement statement = null;
		try {

			dbConnection = DbConnector.getDBConnection();
			if (dbConnection == null)
				System.exit(1);
			String sql = "insert into district (division_id, district_name) values " + "('" + divId + "' , '" + distName
					+ "')";
			statement = dbConnection.createStatement();
			statement.executeUpdate(sql);

			if (statement != null)
				statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "DB Connection Failed!", "DB Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void insertUpazilla(int distId, String thanaName) {
		Connection dbConnection = null;
		Statement statement = null;
		try {

			dbConnection = DbConnector.getDBConnection();
			if (dbConnection == null)
				System.exit(1);
			String sql = "insert into upazilla (district_id, upazilla_name) values " + "('" + distId + "' , '"
					+ thanaName + "')";
			statement = dbConnection.createStatement();
			statement.executeUpdate(sql);

			if (statement != null)
				statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "DB Connection Failed!", "DB Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public List<District> getDistrict() {
		Connection dbConnection = null;
		Statement statement = null;

		var output = new ArrayList<District>();
		try {

			dbConnection = DbConnector.getDBConnection();
			if (dbConnection == null)
				System.exit(1);
			String sql = "SELECT id, division_id, district_name from district ";
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				output.add(new District(rs.getInt("id"), rs.getInt("division_id"), rs.getString("district_name")));
			}
			if (statement != null)
				statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "DB Connection Failed!", "DB Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return output;
	}

	public List<NameValueDto<Integer>> getDistrictsByDivisionId(int divId) {
		Connection dbConnection = null;
		Statement statement = null;

		var output = new ArrayList<NameValueDto<Integer>>();
		try {

			dbConnection = DbConnector.getDBConnection();
			if (dbConnection == null)
				System.exit(1);
			String sql = "SELECT id, district_name from district where division_id = " + divId;
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				output.add(new NameValueDto<Integer>(rs.getString("district_name"), rs.getInt("id")));
			}
			if (statement != null)
				statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "DB Connection Failed!", "DB Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return output;
	}

	public List<NameValueDto<Integer>> getUpazillaByDistrictId(int distId) {
		Connection dbConnection = null;
		Statement statement = null;

		var output = new ArrayList<NameValueDto<Integer>>();
		try {

			dbConnection = DbConnector.getDBConnection();
			if (dbConnection == null)
				System.exit(1);
			String sql = "SELECT id, upazilla_name from upazilla where district_id = " + distId;
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				output.add(new NameValueDto<Integer>(rs.getString("upazilla_name"), rs.getInt("id")));
			}
			if (statement != null)
				statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "DB Connection Failed!", "DB Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		return output;
	}

	public List<Upazilla> getUpazilla() {
		Connection dbConnection = null;
		Statement statement = null;

		var output = new ArrayList<Upazilla>();
		try {

			dbConnection = DbConnector.getDBConnection();
			if (dbConnection == null)
				System.exit(1);
			String sql = "select up.id, up.upazilla_name, dist.district_name, dist.division_id from upazilla as up\r\n"
					+ "join district as dist\r\n" + "on up.district_id = dist.id";
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				output.add(new Upazilla(rs.getInt("division_id"), rs.getString("district_name"),
						rs.getString("upazilla_name")));
			}
			if (statement != null)
				statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "DB Connection Failed!", "DB Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return output;
	}

	public List<Employee> getEmployees() {
		Connection dbConnection = null;
		Statement statement = null;

		var output = new ArrayList<Employee>();
		try {

			dbConnection = DbConnector.getDBConnection();
			if (dbConnection == null)
				System.exit(1);
			String sql = "select first_name, middle_name, last_name, nid, phone, email, address, photo_url from employee";
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				output.add(new Employee(rs.getString("first_name"), rs.getString("middle_name"),
						rs.getString("last_name"), rs.getString("nid"), rs.getString("phone"), rs.getString("email"),
						rs.getString("address"), rs.getString("photo_url")));
			}
			if (statement != null)
				statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "DB Connection Failed!", "DB Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return output;
	}

	public void insertEmployee(String fName, String mName, String lName, int gender, String nid, Date dob,
			String address, String phone, String email, String photo_url, int distId, int upazillaId) {
		Connection dbConnection = null;
		Statement statement = null;
		try {

			dbConnection = DbConnector.getDBConnection();
			if (dbConnection == null)
				System.exit(1);

			java.sql.Date sqlDate = new java.sql.Date(dob.getTime());

			String sql = "insert into employee (first_name, middle_name, last_name, gender, dob, address, phone, email, photo_url, district_id, upazilla_id, nid)"
					+ " values " + "('" + fName + "' , '" + mName + "' , '" + lName + "' , '" + gender + "' , '"
					+ sqlDate + "' , '" + address + "' , '" + phone + "' , '" + email + "' , '" + photo_url + "' , '"
					+ distId + "', '" + upazillaId + "', '" + nid + "')";
			statement = dbConnection.createStatement();
			statement.executeUpdate(sql);

			if (statement != null)
				statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "DB Connection Failed!", "DB Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public Employee searchEmployee(int distId, int upzId, String name, String phone, String email, String nid) {
		Connection dbConnection = null;
		Statement statement = null;
		try {

			dbConnection = DbConnector.getDBConnection();
			if (dbConnection == null)
				System.exit(1);
			String sql = "select first_name, middle_name, last_name, nid, phone, email, address, photo_url from employee where (first_name LIKE '%"
					+ name + "%' OR middle_name LIKE '%" + name + "%' OR last_name LIKE '%" + name + "%')";

			if (distId != 0) {
				sql.concat(" and district_id = " + distId);
			}
			if (upzId != 0) {
				sql.concat(" and upazilla_id = " + upzId);
			}
			if (phone.equals("")) {
				sql.concat(" and phone LIKE '%" + phone + "%'");
			}
			if (email.equals("")) {
				sql.concat(" and email LIKE '%" + email + "%'");
			}
			if (nid.equals("")) {
				sql.concat(" and nid LIKE '%" + nid + "%'");
			}
			sql.concat(" Limit 1");
			statement = dbConnection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				return new Employee(rs.getString("first_name"), rs.getString("middle_name"), rs.getString("last_name"),
						rs.getString("nid"), rs.getString("phone"), rs.getString("email"), rs.getString("address"),
						rs.getString("photo_url"));
			}
			if (statement != null)
				statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "DB Connection Failed!", "DB Error!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return null;
	}

}
