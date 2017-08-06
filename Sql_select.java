import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sql_select {
	String a,b;
	String book[]=new String[3];
	int num;
	int n;
	String []c=new String[50];
	String sqlconnect(String sql,String s,String t)throws Exception{
		Connection conn=null;
		String url ="jdbc:mysql://localhost:3306/library?"+
				"user=root&useUnicode=true&characterEncoding=UTF8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载mysql驱动");
			conn = DriverManager.getConnection(url);
			Statement stmt= conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			if(rs.next()){
				a=rs.getString(s);
				b=rs.getString(t);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("操作数据库错误");
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return a;
	}
	
	String []sqlselect(String sql,String s)throws Exception{
		Connection conn=null;
		String url ="jdbc:mysql://localhost:3306/library?"+
				"user=root&useUnicode=true&characterEncoding=UTF8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载mysql驱动");
			conn = DriverManager.getConnection(url);
			Statement stmt= conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			int i=0;
			while(rs.next()){
				c[i]=rs.getString(s);
				i++;
			}
			n=i;
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("操作数据库错误");
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			conn.close();
		}
		return c;
	}
	
	void sqlsearch(String sql,String a,String b,String c,String d)throws Exception{
		Connection conn=null;
		String url ="jdbc:mysql://localhost:3306/library?"+
				"user=root&useUnicode=true&characterEncoding=UTF8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载mysql驱动");
			conn = DriverManager.getConnection(url);
			Statement stmt= conn.createStatement();
			ResultSet rs =stmt.executeQuery(sql);
			if(rs.next()){
				book[0]=rs.getString(a);
				book[1]=rs.getString(b);
				book[2]=rs.getString(c);
				num=rs.getInt(d);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("操作数据库错误");
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally{
			conn.close();
		}
	}


}
