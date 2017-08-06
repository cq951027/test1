import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Check extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String readerid;
	static String readername;
	private JLabel bname;
	private JTextField bookname;
	private JButton search;
	private JLabel bId;
	private JLabel bwriter;
	private JLabel bnum;
	private JLabel bpress;
	private JTextField bookId;
	private JTextField bookwriter;
	private JTextField booknum;
	private JTextField bookpress;
	private JButton update;
	private JButton exit;
	public JLabel getbname(){
		if(bname==null){
			bname=new JLabel("������");
			bname.setBounds(40, 50, 60, 30);
		}
		return bname;
	}
	public JTextField getbookname(){
		if(bookname==null){
			bookname=new JTextField(20);
			bookname.setBounds(100, 50, 150, 30);
		}
		return bookname;
	}
	public JButton getsearch(){
		if(search==null){
			search=new JButton("����");
			search.setBounds(300, 50, 150, 30);
		}
		return search;
	}
	public JLabel getbID(){
		if(bId==null){
			bId=new JLabel("ͼ���ţ�");
			bId.setBounds(50, 200, 100, 30);
		}
		return bId;
	}
	public JTextField getbookId(){
		if(bookId==null){
			bookId=new JTextField(20);
			bookId.setBounds(150, 200, 150, 30);
		}
		return bookId;
	}
	public JLabel getbwriter(){
		if(bwriter==null){
			bwriter=new JLabel("ͼ�����ߣ�");
			bwriter.setBounds(50, 250, 150, 30);
		}
		return bwriter;
	}
	public JTextField getbookwriter(){
		if(bookwriter==null){
			bookwriter=new JTextField(20);
			bookwriter.setBounds(150, 250, 150, 30);
		}
		return bookwriter;
	}
	public JLabel getbnum(){
		if(bnum==null){
			bnum=new JLabel("ͼ��������");
			bnum.setBounds(50, 300, 100, 30);
		}
		return bnum;
	}
	public JTextField getbooknum(){
		if(booknum==null){
			booknum=new JTextField(20);
			booknum.setBounds(150, 300, 150, 30);
		}
		return booknum;
	}
	public JLabel getbpress(){
		if(bpress==null){
			bpress=new JLabel("�����磺");
			bpress.setBounds(50, 350, 100, 30);
		}
		return bpress;
	}
	public JTextField getbookpress(){
		if(bookpress==null){
			bookpress=new JTextField(20);
			bookpress.setBounds(150, 350, 150, 30);
		}
		return bookpress;
	}
	public JButton getupdate(){
		if(update==null){
			update=new JButton("����");
			update.setBounds(100, 500, 150, 30);
		}
		return update;
	}
	
	public JButton getexit(){
		if(exit==null){
			exit=new JButton("�˳�");
			exit.setBounds(300, 500, 150, 30);
		}
		return exit;
	}
	public Check(String title) {
		// TODO �Զ����ɵĹ��캯�����
		super(title);
		Container container=this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon("C:/Users/CQ/Pictures/ͼ���2.png");
		JLabel imageLabel=new JLabel(img);
		this.getLayeredPane().add(imageLabel,new Integer(Integer.MIN_VALUE));
		imageLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
		container.setLayout(new BorderLayout());
		imageLabel.setLayout(null);
		imageLabel.add(getbname());
		imageLabel.add(getbookname());
		imageLabel.add(getsearch());
		imageLabel.add(getbID());
		imageLabel.add(getbookId());
		imageLabel.add(getbwriter());
		imageLabel.add(getbookwriter());
		imageLabel.add(getbnum());
		imageLabel.add(getbooknum());
		imageLabel.add(getbpress());
		imageLabel.add(getbookpress());
		imageLabel.add(getupdate());
		imageLabel.add(getexit());
		search.addActionListener(this);
		update.addActionListener(this);
		exit.addActionListener(this);
		container.add(imageLabel,BorderLayout.NORTH);
		((JPanel)container).setOpaque(false);
		this.setBounds(300,200,img.getIconWidth(), img.getIconHeight());
		this.setVisible(true);
		this.setResizable(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		String binformation[]=new String[3];
		int number;
		if(e.getSource()==search){
			if(bookname.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "������������");
			}else{
				Sql_select ss=new Sql_select();
				String sql="select * from book where( bname='"+bookname.getText()+"')";
				try {
					ss.sqlsearch(sql,"bid","wname","press","num1");
					binformation=ss.book;
					number=ss.num;
					bookId.setText(binformation[0]);
					bookwriter.setText(binformation[1]);
					bookpress.setText(binformation[2]);
					booknum.setText(String.valueOf(number));
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					JOptionPane.showMessageDialog(null, "û���Ȿ�飡");
				}
			}
		}
		if(e.getSource()==update){
			if(bookId.getText().isEmpty()||bookwriter.getText().isEmpty()||bookpress.getText().isEmpty()
					||booknum.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "����дҪ�����鼮����Ϣ��");
			}else{
				Sql_update su=new Sql_update();
				try {
					su.sqlupdate(bookId.getText(), bookwriter.getText(), Integer.valueOf(booknum.getText()),
							     bookpress.getText(), bookname.getText());
					
				} catch (NumberFormatException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		}
		if(e.getSource()==exit){
			this.setVisible(false);
		}
		
	}

}
