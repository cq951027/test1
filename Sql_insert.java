import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Sql_insert {
	
	void sqlinsert(String a,String b,String c,String d) throws Exception{
		Connection conn=null;
		PreparedStatement pst = null;
		String url ="jdbc:mysql://localhost:3306/library?"+
				"user=root&useUnicode=true&characterEncoding=UTF8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载mysql驱动");
			conn = DriverManager.getConnection(url);
			String sql = "insert into borrow(rid,bid,bname,rname) values(?,?,?,?) ";  
			pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, a);
			pst.setString(2, b);
			pst.setString(3, c);
			pst.setString(4, d);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "借阅成功");
			pst.close();
		} catch (SQLException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "你已经借过这本书！");
		} finally {
			conn.close();
		}
	}
	
	void sqli(String a,String b,String c,int d,int e,String f) throws Exception{
		Connection conn=null;
		PreparedStatement pst = null;
		String url ="jdbc:mysql://localhost:3306/library?"+
				"user=root&useUnicode=true&characterEncoding=UTF8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载mysql驱动");
			conn = DriverManager.getConnection(url);
			String sql = "insert into book(bid,bname,wname,num1,num2,press) values(?,?,?,?,?,?) ";  
			pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, a);
			pst.setString(2, b);
			pst.setString(3, c);
			pst.setInt(4, d);
			pst.setInt(5, e);
			pst.setString(6, f);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "添加成功");
			pst.close();
		} catch (SQLException e1) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "添加错误");
		} finally {
			conn.close();
		}
	}

}
