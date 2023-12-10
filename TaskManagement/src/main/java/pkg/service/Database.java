package pkg.service;

import java.sql.Connection;

public interface Database {
	public Connection OpenConnection() ;
	public void closeConnection(Connection conn);
}
