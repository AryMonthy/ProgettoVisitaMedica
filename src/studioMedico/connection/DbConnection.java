package studioMedico.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static DbConnection instance;
	private static String driver = "thin";
	private static String user = "C##progetto";
	private static String pass = "progetto";
	private static String host = "localhost";
	private static String port = "1521";
	private static String db = "xe";
	private Connection conn; 

	
	private DbConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		String connString = String.format("jdbc:oracle:%s:%s/%s@//%s:%s/%s", driver, user, pass, host, port, db);
		try 
		{
			conn = DriverManager.getConnection(connString);
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static DbConnection getDbConnection()
	{
		if(instance == null) 
		{
			instance = new DbConnection();
		}
		return instance;
	}
	
	public Connection getConnection()
	{
		return conn;
	}

}
