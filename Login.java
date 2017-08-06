import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{ 
	private static final long serialVersionUID= 1L;
	private JLabel jlUsername;
	private JLabel jlPwd;
	private JTextField txtUsername;
	//�û���
	private JTextField txtPassword;
	//����
	private JComboBox<String> choice;
	private JButton jbOk;
	private JButton jbCancel;
	public JLabel getJlUsename(){
		if(jlUsername==null){
			jlUsername=new JLabel("�˺�");
			jlUsername.setForeground(Color.BLACK);
			jlUsername.setBounds(118, 40, 85, 30);
		}
		return jlUsername;
	}
	
	public JLabel getjlPwd(){
		if(jlPwd==null){
			jlPwd=new JLabel("����");
			jlPwd.setForeground(Color.BLACK);
			jlPwd.setBounds(118, 100, 85, 30);
			
		}
		return jlPwd;
	}
	public JTextField getTxtUsername(){
		if(txtUsername==null){
			txtUsername=new JTextField(20);
			txtUsername.setBounds(180, 40, 200, 30);
			
		}
		return txtUsername;
	}
	public JTextField getTxtpassword(){
		if(txtPassword==null){
			txtPassword=new JTextField(20);
			txtPassword.setBounds(180, 100, 200, 30);
		}
		return txtPassword;
	}
	public JComboBox<String> getchoice(){
		if(choice==null){
			choice=new JComboBox<String>();
			choice.addItem("ϵͳ����Ա");
			choice.addItem("ͼ�����Ա");
			choice.addItem("����");
			choice.setBounds(50, 180, 90, 30);
		}
		return choice;
	}
	public JButton getJbOK(){
		if(jbOk==null){
			jbOk=new JButton("��¼");
			jbOk.setBounds(150, 180, 90, 30);
		}
		return jbOk;
	}
	public JButton getJbCancel(){
		if(jbCancel==null){
			jbCancel=new JButton("ȡ��");
			jbCancel.setBounds(300, 180, 90, 30);
		}
		return jbCancel;
	}
	public Login(String title){
		super(title);
		Container container=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("C:/Users/CQ/Desktop/book.jpg");
		JLabel imageLabel=new JLabel(img);
		this.getLayeredPane().add(imageLabel,new Integer(Integer.MIN_VALUE));
		imageLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		container.setLayout(new BorderLayout());
		imageLabel.setLayout(null);
		imageLabel.add(getJlUsename());
		imageLabel.add(getTxtUsername());
		imageLabel.add(getjlPwd());
		imageLabel.add(getTxtpassword());
		imageLabel.add(getchoice());
		imageLabel.add(getJbOK());
		imageLabel.add(getJbCancel());
		jbOk.addActionListener(this);
		jbCancel.addActionListener(this);
		container.add(imageLabel,BorderLayout.NORTH);
		((JPanel)container).setOpaque(false);
		this.setBounds(300,200,img.getIconWidth(), img.getIconHeight());
		this.setVisible(true);
		this.setResizable(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getSource()==jbOk){
			Connection conn = null;
			String sql;
			String url ="jdbc:mysql://localhost:3306/library?"+
						"user=root&useUnicode=true&characterEncoding=UTF8";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("�ɹ�����mysql����");
				conn = DriverManager.getConnection(url);
				Statement stmt = conn.createStatement();
				if(choice.getSelectedItem().equals("ϵͳ����Ա")){
					sql = "select * from systemmanage";
					ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);
					if (rs.next()) {
						if(txtUsername.getText().equals(rs.getString("username"))
								&&txtPassword.getText().equals(rs.getString("password"))){
							new Managesystem("����Աϵͳ");
							Login.this.setVisible(false);
						}
						else{
							JOptionPane.showMessageDialog(null, "�˺Ż��������");
						}
					}
				}
				if(choice.getSelectedItem().equals("ͼ�����Ա")){
					sql = "select * from bookmanager";
					ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);
					if (rs.next()) {
						if(txtUsername.getText().equals(rs.getString("username"))
								&&txtPassword.getText().equals(rs.getString("password"))){
							new Managebook("ͼ�����ϵͳ");
							Login.this.setVisible(false);
						}else{
							JOptionPane.showMessageDialog(null, "�˺Ż��������");
						}
					}
				}
				if(choice.getSelectedItem().equals("����")){
					sql = "select * from reader";
					ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);
					if (rs.next()) {
						if(txtUsername.getText().equals(rs.getString("username"))
								&&txtPassword.getText().equals(rs.getString("password"))){
							reader.uname=txtUsername.getText();
							Sql_select ss=new Sql_select();
							String sql3="select * from reader where (username = '"+txtUsername.getText()+"')";
							ss.sqlconnect(sql3, "rname","rid");
							reader.rid[0]=ss.b;
							reader.rid[1]=ss.a;
							String sql4="select * from borrow where (rid = '"+ss.b+"')";
							ss.sqlselect(sql4, "bname");
							reader.book=ss.c;
							reader.n=ss.n;
							new reader("����");
							Login.this.setVisible(false);
						}else{
							JOptionPane.showMessageDialog(null, "�˺Ż��������");
						}
					}
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
		}
		if(e.getSource()==jbCancel){
			this.dispose();
		}
	}
	public static void main(String args[]){
		new Login("ͼ�����ϵͳ");
	}
}