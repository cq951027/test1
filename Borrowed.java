import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Borrowed extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String bn;
	String readerid;
	JFrame bf;
	JLabel show;
	JButton lend;
	JButton borrowagain;
	JTextField number;
	JButton re;
	int n1;
	int days(){
		Connection conn = null;
		String sql;
		String url ="jdbc:mysql://localhost:3306/library?"+
					"user=root&useUnicode=true&characterEncoding=UTF8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("�ɹ�����mysql����");
			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			sql = "select * from borrow where (bname='"+bn+"')";
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);
			while (rs.next()) {
				n1=rs.getInt("days");
			}	
		} catch (SQLException e1) {
			// TODO: handle exception
			System.out.println("�������ݿ����");
			e1.printStackTrace();
		}catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
		}
		return n1;
	}
	void borrow(){
		bf=new JFrame("�黹");
		bf.setLayout(new FlowLayout());
		show=new JLabel("��ʣ"+days()+"��");
		lend=new JButton("�黹");
		borrowagain=new JButton("����");
		number=new JTextField(10);
		re=new JButton("����");
		lend.addActionListener(this);
		borrowagain.addActionListener(this);
		re.addActionListener(this);
		bf.add(show);
		bf.add(borrowagain);
		bf.add(number);
		bf.add(new JLabel("��"));
		bf.add(lend);
		bf.add(re);
		bf.setBounds(300, 400, 300, 150);
		bf.setVisible(true);
		bf.validate();
		bf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getSource()==lend){
			Sql_delete sd=new Sql_delete();
			String sql="delete from borrow where (bname='"+bn+"')";
			try {
				sd.sqldrop(sql);
				JOptionPane.showMessageDialog(null, "�黹�ɹ���");
				Sql_select ss=new Sql_select();
				String sql4="select * from borrow where (rid = '"+readerid+"')";
				try {
					ss.sqlselect(sql4, "bname");
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				reader.book=ss.c;
				reader.n=ss.n;
				try {
					new reader("����");
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
				bf.dispose();
			} catch (Exception e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
		}
		
		if(e.getSource()==re){
			Sql_select ss=new Sql_select();
			String sql4="select * from borrow where (rid = '"+readerid+"')";
			try {
				ss.sqlselect(sql4, "bname");
			} catch (Exception e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
			reader.book=ss.c;
			reader.n=ss.n;
			try {
				new reader("����");
			} catch (Exception e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
			bf.dispose();
		}
		
		if(e.getSource()==borrowagain){
			String n=number.getText();
			Sql_update su=new Sql_update();
			try {
				su.update(n1+Integer.valueOf(n), bn);
			} catch (NumberFormatException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
			bf.setVisible(false);
		}
		
	}

}
