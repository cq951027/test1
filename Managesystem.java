import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Managesystem extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel rId;
	private JLabel rusername;
	private JLabel rpassword;
	private JLabel rname;
	private JLabel bmId;
	private JLabel bmusername;
	private JLabel bmpassword;
	private JLabel bmname;
	private JTextField reId;
	private JTextField reusername;
	private JTextField repassword;
	private JTextField rename;
	private JTextField bmgId;
	private JTextField bmgusername;
	private JTextField bmgpassword;
	private JTextField bmgname;
	private JButton recordreader;
	private JButton recordbookmanage;
	private JButton smSearch;
	private JButton exit;
	public JLabel getrID(){
		if(rId==null){
			rId=new JLabel("读者编号：");
			rId.setBounds(50, 10, 100, 30);
		}
		return rId;
	}
	public JTextField getreId(){
		if(reId==null){
			reId=new JTextField(20);
			reId.setBounds(150, 10, 150, 30);
		}
		return reId;
	}
	public JLabel getrusername(){
		if(rusername==null){
			rusername=new JLabel("读者用户名：");
			rusername.setBounds(50, 50, 100, 30);
		}
		return rusername;
	}
	public JTextField getreusername(){
		if(reusername==null){
			reusername=new JTextField(20);
			reusername.setBounds(150, 50, 150, 30);
		}
		return reusername;
	}
	public JLabel getrpassword(){
		if(rpassword==null){
			rpassword=new JLabel("读者密码：");
			rpassword.setBounds(50, 90, 100, 30);
		}
		return rpassword;
	}
	public JTextField getrepassword(){
		if(repassword==null){
			repassword=new JTextField(20);
			repassword.setBounds(150, 90, 150, 30);
		}
		return repassword;
	}
	public JLabel getrname(){
		if(rname==null){
			rname=new JLabel("读者姓名：");
			rname.setBounds(50, 130, 150, 30);
		}
		return rname;
	}
	public JTextField getrename(){
		if(rename==null){
			rename=new JTextField(20);
			rename.setBounds(150, 130, 150, 30);
		}
		return rename;
	}
	public JButton getrecord1(){
		if(recordreader==null){
			recordreader=new JButton("记录读者");
			recordreader.setBounds(250, 170, 150, 30);
		}
		return recordreader;
	}
	public JLabel getbmID(){
		if(bmId==null){
			bmId=new JLabel("图书管理员编号：");
			bmId.setBounds(50, 210, 150, 30);
		}
		return bmId;
	}
	public JTextField getbmgId(){
		if(bmgId==null){
			bmgId=new JTextField(20);
			bmgId.setBounds(150, 210, 150, 30);
		}
		return bmgId;
	}
	public JLabel getbmusername(){
		if(bmusername==null){
			bmusername=new JLabel("图书管理员用户名：");
			bmusername.setBounds(50, 250, 100, 30);
		}
		return bmusername;
	}
	public JTextField getbmgusername(){
		if(bmgusername==null){
			bmgusername=new JTextField(20);
			bmgusername.setBounds(150, 250, 150, 30);
		}
		return bmgusername;
	}
	public JLabel getbmpassword(){
		if(bmpassword==null){
			bmpassword=new JLabel("图书管理员密码：");
			bmpassword.setBounds(50, 290, 100, 30);
		}
		return bmpassword;
	}
	public JTextField getbmgpassword(){
		if(bmgpassword==null){
			bmgpassword=new JTextField(20);
			bmgpassword.setBounds(150, 290, 150, 30);
		}
		return bmgpassword;
	}
	public JLabel getbmname(){
		if(bmname==null){
			bmname=new JLabel("图书管理员姓名：");
			bmname.setBounds(50, 330, 100, 30);
		}
		return bmname;
	}
	public JTextField getbmgname(){
		if(bmgname==null){
			bmgname=new JTextField(20);
			bmgname.setBounds(150, 330, 150, 30);
		}
		return bmgname;
	}
	public JButton getrecord2(){
		if(recordbookmanage==null){
			recordbookmanage=new JButton("记录图书管理员");
			recordbookmanage.setBounds(250, 370, 150, 30);
		}
		return recordbookmanage;
	}
	public JButton getsmSearch(){
		if(smSearch==null){
			smSearch=new JButton("查找");
			smSearch.setBounds(100, 420, 100, 30);
		}
		return smSearch;
	}
	public JButton getexit(){
		if(exit==null){
			exit=new JButton("退出");
			exit.setBounds(250, 420, 100, 30);
		}
		return exit;
	}
	public Managesystem(String title) {
		// TODO 自动生成的构造函数存根
		super(title);
		Container container=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("C:/Users/CQ/Pictures/越狱.jpg");
		JLabel imageLabel=new JLabel(img);
		this.getLayeredPane().add(imageLabel,new Integer(Integer.MIN_VALUE));
		imageLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		container.setLayout(new BorderLayout());
		imageLabel.setLayout(null);
		imageLabel.add(getrID());
		imageLabel.add(getreId());
		imageLabel.add(getrusername());
		imageLabel.add(getreusername());
		imageLabel.add(getrpassword());
		imageLabel.add(getrepassword());
		imageLabel.add(getrname());
		imageLabel.add(getrename());
		imageLabel.add(getbmID());
		imageLabel.add(getbmgId());
		imageLabel.add(getbmusername());
		imageLabel.add(getbmgusername());
		imageLabel.add(getbmpassword());
		imageLabel.add(getbmgpassword());
		imageLabel.add(getbmname());
		imageLabel.add(getbmgname());
		imageLabel.add(getrecord1());
		imageLabel.add(getrecord2());
		imageLabel.add(getsmSearch());
		imageLabel.add(getexit());
		recordreader.addActionListener(this);
		recordbookmanage.addActionListener(this);
		smSearch.addActionListener(this);
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
		if(e.getSource()==recordreader){
			Connection conn=null;
			Statement pst = null;
			String id=reId.getText();
			String username=reusername.getText();
			String password=repassword.getText();
			String name=rename.getText();
			if(id.isEmpty()||username.isEmpty()||password.isEmpty()||name.isEmpty()){
				JOptionPane.showMessageDialog(null, "信息录入不完整！");
			}else{
				String url ="jdbc:mysql://localhost:3306/library?"+
						"user=root&useUnicode=true&characterEncoding=UTF8";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("成功加载mysql驱动");
					conn = DriverManager.getConnection(url);
					String sql = "insert into reader values ('"+id+"','"+username+"','"+password+"','"+name+"')"; 
					pst=conn.createStatement();
					pst.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "读者信息录入成功");
					getreId().setText("");
					getreusername().setText("");
					getrepassword().setText("");
					getrename().setText("");
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO: handle exception
					System.out.println("增加数据错误");
					e1.printStackTrace();
				} finally {
					try {
						conn.close();
					} catch (SQLException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource()==recordbookmanage){
			Connection conn=null;
			Statement pst = null;
			String id=bmgId.getText();
			String username=bmgusername.getText();
			String password=bmgpassword.getText();
			String name=bmgname.getText();
			String url ="jdbc:mysql://localhost:3306/library?"+
					"user=root&useUnicode=true&characterEncoding=UTF8";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("成功加载mysql驱动");
				conn = DriverManager.getConnection(url);
				String sql = "insert into bookmanager values ('"+id+"','"+username+"','"+password+"','"+name+"')"; 
				pst=conn.createStatement();
				pst.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "图书管理员信息录入成功");
				getbmgId().setText("");
				getbmgusername().setText("");
				getbmgpassword().setText("");
				getbmgname().setText("");
			} catch (SQLException | ClassNotFoundException e1) {
				// TODO: handle exception
				System.out.println("增加数据错误");
				e1.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		}
		if(e.getSource()==smSearch){
			new Smsearch("查删");
		}
		if(e.getSource()==exit){
			this.dispose();
		}

	}
}

