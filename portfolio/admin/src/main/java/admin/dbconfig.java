package admin;

import java.sql.Connection;
import java.sql.DriverManager;

//db 연결 부분(Module)

public class dbconfig {
	
	public static Connection info() throws Exception {
		String db_driver = "com.mysql.cj.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost:3306/java";
		String db_user = "hani";
		String db_pass = "a1234";
		
		/*String db_url = "jdbc:mysql://umj7-020.cafe24.com/hytuby22";
		String db_user = "hytuby22";
		String db_pass = "skawk22^^";*/
		
		Class.forName(db_driver);
		Connection con = DriverManager.getConnection(db_url,db_user,db_pass);
		
		return con;
	}
	
}
