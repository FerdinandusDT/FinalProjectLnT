package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import db.DBConnect;

public class MenuDAO {

	Connection connection;
	
	public MenuDAO() {
		try {
			initDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initDB() throws SQLException {
		connection = DBConnect.connect();
		if(connection == null) {
			throw new SQLException("connection");
		}
	}
	
	public Vector<Vector<String>> getData() {
		Vector<Vector<String>> data = new Vector<>();
		try {
			Statement stmt = connection.createStatement();
			String sql = "select * from menu";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Vector<String> row = new Vector<>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(rs.getString(4));
				data.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public void insertData(String kode, String nama, String harga, String stock) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "insert into menu values ('"+ kode +"','"+ nama +"', '"+ harga +"', '" + stock +"')";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateData(String kode, String nama, String harga, String stock) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "update menu set name='" + nama + "',price='" + harga + "', stock='" + stock + "'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteData(String kode) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "delete from menu where code='" + kode + "'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
