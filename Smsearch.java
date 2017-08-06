import java.awt.BorderLayout;
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

public class Smsearch extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField id;
	JLabel imageLabel;
	private JButton search;
	private JComboBox<String> choice;
	private JLabel result;
	private JTextField show;
	private JButton delete;
	private JButton exit;
	String s;
	public JTextField getid(){
		if(id==null){
			id=new JTextField();
			id.setBounds(100, 50, 100, 30);
		}
		return id;
	}
	public JButton getsearch(){
		if(search==null){
			search=new JButton("查找");
			search.setBounds(250, 50, 100, 30);
		}
		return search;
	}
	public JComboBox<String> getchoice(){
		if(choice==null){
			choice=new JComboBox<>();
			choice.addItem("图书管理员");
			choice.addItem("读者");
			choice.setBounds(350, 50, 100, 30);
		}
		return choice;
	}
	public JLabel getresult(){
		if(result==null){
			result=new JLabel("搜索结果:");
			result.setBounds(100, 150, 150, 30);
		}
		return result;
	}
	public JTextField getshow(){
		if(show==null){
			show=new JTextField(15);
			show.setBounds(300,150,150,30);;
		}
		return show;
	}
	public JButton getdelete(){
		if(delete==null){
			delete=new JButton("删除");
			delete.setBounds(200, 250, 100, 30);
		}
		return delete;
	}
	public JButton getexit(){
		if(exit==null){
			exit=new JButton("退出");
			exit.setBounds(400, 250, 100, 30);
		}
		return exit;
	}
	public Smsearch(String title) {
		// TODO 自动生成的构造函数存根
		super(title);
		Container container=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("C:/Users/CQ/Pictures/图书管理.jpg");
		imageLabel=new JLabel(img);
		this.getLayeredPane().add(imageLabel,new Integer(Integer.MIN_VALUE));
		imageLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		container.setLayout(new BorderLayout());
		imageLabel.add(getid());
		imageLabel.add(getsearch());
		imageLabel.add(getchoice());
		imageLabel.add(getresult());
		imageLabel.add(getshow());
		imageLabel.add(getdelete());
		imageLabel.add(getexit());
		search.addActionListener(this);
		delete.addActionListener(this);
		exit.addActionListener(this);
		container.add(imageLabel,BorderLayout.NORTH);
		((JPanel)container).setOpaque(false);
		this.setBounds(300,200,img.getIconWidth(), img.getIconHeight());
		this.setVisible(true);
		this.setResizable(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String idString=id.getText();
		if(e.getSource()==search){
			if(idString.isEmpty()){
				JOptionPane.showMessageDialog(null, "请输入要查找的id");
			}else{
				String sql;
				Connection conn=null;
				String url ="jdbc:mysql://localhost:3306/library?"+
						"user=root&useUnicode=true&characterEncoding=UTF8";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("成功加载mysql驱动");
					conn = DriverManager.getConnection(url);
					Statement stmt= conn.createStatement();
					if(choice.getSelectedItem().equals("图书管理员")){
						sql="select * from bookmanager where mid='"+idString+"'";
						ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);
						if(rs.next()){
							s=rs.getString("name");
						}else{
							s="没有此人";
						}
						show.setText(s);
					}
					if(choice.getSelectedItem().equals("读者")){
						sql="select * from reader where rid='"+idString+"'";
						ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);
						if(rs.next()){
							s=rs.getString("rname");
						}
						else {
							s="没有此人";
						}
						show.setText(s);
					}
				}catch (SQLException | ClassNotFoundException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				} finally{
					try {
						conn.close();
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
				}
			}
		
		if(e.getSource()==delete){
			if(s.equals("没有此人")){
				JOptionPane.showMessageDialog(null, "没有此人");
			}else{
				Sql_delete sd=new Sql_delete();
				String sql="delete from bookmanager where mid='"+idString+"'";
				try {
					sd.sqldrop(sql);
					JOptionPane.showMessageDialog(null, "删除成功！");
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		}
		
		if(e.getSource()==exit){
			this.setVisible(false);
		}
		
	}

}
