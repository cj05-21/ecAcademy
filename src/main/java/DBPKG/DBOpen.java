package DBPKG;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBOpen {
	public static Connection getConnection() throws Exception {
		Class.forName("org.gjt.mm.mysql.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ecacademy","ecacademy","Ecec0514!");
	return con;
	}
}
