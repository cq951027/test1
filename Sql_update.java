import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Sql_update {
	
	void sqlupdate(String a,String b,int c,String d,String e) throws Exception{
		Connection conn=null;
		PreparedStatement pst = null;
		String url ="jdbc:mysql://localhost:3306/library?"+
				"user=root&useUnicode=true&characterEncoding=UTF8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载mysql驱动");
			conn = DriverManager.getConnection(url);
			String sql = "update book set bid=?,wname=?,num1=?,press=? where bname=? ";  
			pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, a);
			pst.setString(2, b);
			pst.setInt(3, c);
			pst.setString(4, d);
			pst.setString(5, e);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "更新成功");
			pst.close();
		} catch (SQLException e1) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "更新失败");
		} finally {
			conn.close();
		}
	}
	
	void update(int a,String b) throws Exception{
		Connection conn=null;
		PreparedStatement pst = null;
		String url ="jdbc:mysql://localhost:3306/library?"+
				"user=root&useUnicode=true&characterEncoding=UTF8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("成功加载mysql驱动");
			conn = DriverManager.getConnection(url);
			String sql = "update borrow set days=? where bname=? ";  
			pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, a);
			pst.setString(2, b);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "更新成功");
			pst.close();
		} catch (SQLException e1) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "更新失败");
		} finally {
			conn.close();
		}
	}


}
