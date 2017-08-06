import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Managebook extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton Add;
	private JButton Search;
	private JButton exit;
	public JButton getsearch(){
		if(Search==null){
			Search=new JButton("查询");
			Search.setBounds(80, 40, 150, 30);
		}
		return Search;
	}
	public JButton getadd(){
		if(Add==null){
			Add=new JButton("添加");
			Add.setBounds(80, 80, 150, 30);
		}
		return Add;
	}
	public JButton getexit(){
		if(exit==null){
			exit=new JButton("更新");
			exit.setBounds(80, 120, 150, 30);
		}
		return exit;
	}
	public Managebook(String title) {
		// TODO 自动生成的构造函数存根
		super(title);
		Container container=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("C:/Users/CQ/Pictures/图书馆.jpg");
		JLabel imageLabel=new JLabel(img);
		this.getLayeredPane().add(imageLabel,new Integer(Integer.MIN_VALUE));
		imageLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		container.setLayout(new BorderLayout());
		imageLabel.add(getadd());
		imageLabel.add(getsearch());
		imageLabel.add(getexit());
		Add.addActionListener(this);
		Search.addActionListener(this);
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
		if(e.getSource()==Search){
			new Check("查找");
		}
		if(e.getSource()==Add){
			new Addbook("添加");
		}
		if(e.getSource()==exit){
			this.setVisible(false);
		}
	}

}
