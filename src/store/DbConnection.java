package store;

import java.sql.*;

public class DbConnection {
	
	private String account = MyDBInfo.MYSQL_USERNAME;
	private String password = MyDBInfo.MYSQL_PASSWORD;
	private String server = MyDBInfo.MYSQL_DATABASE_SERVER;
	private String database = MyDBInfo.MYSQL_DATABASE_NAME;
	private Connection con;
	private Statement stmt;
	
	public DbConnection(){
		openDB();
		closeDB();
	}
	
	public ResultSet search(String str){
		try{
			ResultSet st = stmt.executeQuery(str);
			return st; 
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public void openDB(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection
				("jdbc:mysql://" + server,account,password);
			stmt = con.createStatement();
			stmt.executeQuery("USE "+database);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}	
	}
	
	public void closeDB(){
		try{
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
}
