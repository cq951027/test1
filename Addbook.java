import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Addbook extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel bname;
	private JLabel bid;
	private JLabel wname;
	private JLabel number;
	private JLabel press;
	private JTextField bookname;
	private JTextField bookid;
	private JTextField writername;
	private JTextField booknumber;
	private JTextField bookpress;
	private JButton add;
	private JButton cancel;
	public JLabel getbname(){
		if(bname==null){
			bname=new JLabel("ͼ������");
			bname.setBounds(50, 50, 100, 30);
		}
		return bname;
	}
	public JTextField getbookname(){
		if(bookname==null){
			bookname=new JTextField(20);
			bookname.setBounds(200, 50, 100, 30);
		}
		return bookname;
	}
	public JLabel getbid(){
		if(bid==null){
			bid=new JLabel("ͼ����");
			bid.setBounds(50, 100, 100, 30);
		}
		return bid;
	}
	public JTextField getbookid(){
		if(bookid==null){
			bookid=new JTextField(20);
			bookid.setBounds(200, 100, 100, 30);
		}
		return bookid;
	}
	public JLabel getwname(){
		if(wname==null){
			wname=new JLabel("ͼ������");
			wname.setBounds(50, 150, 100, 30);
		}
		return wname;
	}
	public JTextField getwritername(){
		if(writername==null){
			writername=new JTextField(20);
			writername.setBounds(200, 150, 100, 30);
		}
		return writername;
	}
	public JLabel getnumber(){
		if(number==null){
			number=new JLabel("ͼ������");
			number.setBounds(50, 200, 100, 30);
		}
		return number;
	}
	public JTextField getbooknumber(){
		if(booknumber==null){
			booknumber=new JTextField(20);
			booknumber.setBounds(200, 200, 100, 30);
		}
		return booknumber;
	}
	public JLabel getpress(){
		if(press==null){
			press=new JLabel("������");
			press.setBounds(50, 250, 100, 30);
		}
		return press;
	}
	public JTextField getbookpress(){
		if(bookpress==null){
			bookpress=new JTextField(20);
			bookpress.setBounds(200, 250, 100, 30);
		}
		return bookpress;
	}
	public JButton getcancel(){
		if(cancel==null){
			cancel=new JButton("ȡ��");
			cancel.setBounds(150, 300, 80, 30);
		}
		return cancel;
	}
	public JButton getadd(){
		if(add==null){
			add=new JButton("���");
			add.setBounds(250, 300, 80, 30);
		}
		return add;
	}
	public Addbook(String title) {
		// TODO �Զ����ɵĹ��캯�����
		super(title);
		Container container=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("C:/Users/CQ/Pictures/Խ��.jpg");
		JLabel imageLabel=new JLabel(img);
		this.getLayeredPane().add(imageLabel,new Integer(Integer.MIN_VALUE));
		imageLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		container.setLayout(new BorderLayout());
		imageLabel.setLayout(null);
		imageLabel.add(getbid());
		imageLabel.add(getbookid());
		imageLabel.add(getbname());
		imageLabel.add(getbookname());
		imageLabel.add(getwname());
		imageLabel.add(getwritername());
		imageLabel.add(getnumber());
		imageLabel.add(getbooknumber());
		imageLabel.add(getpress());
		imageLabel.add(getbookpress());
		imageLabel.add(getcancel());
		imageLabel.add(getadd());
		add.addActionListener(this);
		cancel.addActionListener(this);
		container.add(imageLabel,BorderLayout.NORTH);
		((JPanel)container).setOpaque(false);
		this.setBounds(300,200,img.getIconWidth(), img.getIconHeight());
		this.setVisible(true);
		this.setResizable(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getSource()==add){
			Sql_insert si=new Sql_insert();
			try {
				si.sqli(bookid.getText(), bookname.getText(), writername.getText(), 
						Integer.valueOf(booknumber.getText()), Integer.valueOf(booknumber.getText()), bookpress.getText());
			} catch (NumberFormatException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
		}
		if(e.getSource()==cancel){
			this.setVisible(false);
		}
	}

}
