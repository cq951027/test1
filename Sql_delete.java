import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Sql_delete {
	void sqldrop(String a) throws Exception{
		Connection conn=null;
		String url ="jdbc:mysql://localhost:3306/library?"+
				"user=root&useUnicode=true&characterEncoding=UTF8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("�ɹ�����mysql����");
			conn = DriverManager.getConnection(url);
			Statement stmt= conn.createStatement();
			stmt.executeUpdate(a);
			stmt.close();
		}catch(SQLException e){
			System.out.println("ɾ�����ݴ���");
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

}
