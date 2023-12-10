package pkg.ServiceImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



import pkg.service.Database;

public class DataConnection implements Database {
	private String jdbcURL = "jdbc:mysql://192.168.64.2:3306/SHLDB?useSSL=false";
    private String jdbcUsername = "innovation";
    private String jdbcPassword = "bhbfc_0001";

	@Override
	public Connection OpenConnection() {

        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    
	}

	@Override
	public void closeConnection(Connection conn) {
		try {
			conn.close();
		}catch(Exception e) {
			e.getLocalizedMessage();
		}
		
	}

}
