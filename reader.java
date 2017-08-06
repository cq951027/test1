import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class reader extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel introduce;
	private JLabel borrowed;
	private JButton borrow;
	private JButton exit;
	private JButton bJButton[]=new JButton[50];
	static String uname;
	static String rid[] = new String[2];
	static String book[];
	static int n;
	
	public JLabel getintroduce() throws Exception{
		if(introduce==null){
			introduce=new JLabel("读者"+rid[1]+"的借阅情况");
			introduce.setBounds(200,50,150,30);
		}
		return introduce;
	}
	public JLabel getborrowed(){
		if(borrowed==null){
			borrowed=new JLabel("已借阅:");
			borrowed.setBounds(50,150,150,30);
		}
		return borrowed;
	}
	public JButton getborrow(){
		if(borrow==null){
			borrow=new JButton("借阅");
			borrow.setBounds(50, 450, 100, 30);
		}
		return borrow;
	}
	public JButton getexit(){
		if(exit==null){
			exit=new JButton("续借");
			exit.setBounds(270, 450, 100, 30);
		}
		return exit;
	}
	
	public reader(String title) throws Exception {
		// TODO 自动生成的构造函数存根
		super(title);
		Container container=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("C:/Users/CQ/Pictures/图书馆2.png");
		JLabel imageLabel=new JLabel(img);
		this.getLayeredPane().add(imageLabel,new Integer(Integer.MIN_VALUE));
		imageLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		container.setLayout(new BorderLayout());
		imageLabel.add(getintroduce());
		imageLabel.add(getborrowed());
		for(int i=0;i<n;i++){
			if(bJButton[i]==null){
				bJButton[i]=new JButton(book[i]);
				bJButton[i].setBounds(100+(i%2)*150, 200+(i/2)*50, 100, 30);
			}
			imageLabel.add(bJButton[i]);
			bJButton[i].addActionListener(this);
		}
		imageLabel.add(getborrow());
		imageLabel.add(getexit());
		borrow.addActionListener(this);
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
		if(e.getSource()==borrow){
			Search.readerid=rid[0];
			Search.readername=rid[1];
			new Search("查找");
			reader.this.dispose();
		}
		for(int i=0;i<n;i++){
			if(e.getSource()==bJButton[i]){
				String bname=bJButton[i].getText();
				Borrowed b=new Borrowed();
				b.bn=bname;
				b.readerid=rid[0];
				b.borrow();
				reader.this.dispose();
			}
		}
		
		if(e.getSource()==exit){
			this.dispose();
		}
		
	}

}
