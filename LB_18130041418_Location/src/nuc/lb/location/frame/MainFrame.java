package nuc.lb.location.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import nuc.lb.location.entity.User;

public class MainFrame extends JFrame{
	//�˵���
	JMenuBar menubar;
	//�˵�
	JMenu shopping_menu, order_menu, info_menu, user_menu,product_menu;
	//�˵���
	JMenuItem userMyself,users;
	JMenuItem queryAll, queryByName, queryByType, addProduct, deleteProduct, queryOrder, delectOrder, queryInfo, addSelfInfo, modifySelfInfo,queryLocation;
	public MainFrame(User u) {
		//�����ڴ˴����Ϸ�����close����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(632, 768);
		bg();
		this.setTitle("��������ƽ̨ϵͳ����ӭID"+": "+ u.getStuid() + "��¼ϵͳ����");
		menubar = new JMenuBar();
		
		shopping_menu = new JMenu("ʧ�����");		
		order_menu = new JMenu("���˹�ʧ");
		user_menu = new JMenu("�û���Ϣ");
		
		info_menu = new JMenu("����滮");	
		queryLocation = new JMenuItem("�����ѯ");
		info_menu.add(queryLocation);
		queryLocation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new queryroute();
			}
		});
		product_menu = new JMenu("��ѯ��Ʒ��Ϣ");

		
		queryAll = new JMenuItem("����ʧ��"); 
		queryAll.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				 new QueryAllObjectFrame();				
			}
		});
		queryByName = new JMenuItem("����Ʒ���Ʋ�ѯ");
		queryByName.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			//	new QueryBookByName();
			}
			
		});
		queryByType = new JMenuItem("����Ʒ����ѯ");
		queryByType.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {		
			//	new QueryBookByType();
			}
			
		});
		addProduct = new JMenuItem("���ʧ��");
		addProduct.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new AddObject();
			}
			
		});
		deleteProduct = new JMenuItem("ɾ��ʧ��");
		deleteProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	//		new deleteBooks();			
			}		
		});
		queryOrder = new JMenuItem("�鿴������Ʒ");
		queryOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
 				new myselfs();
			}		
		});
		
		
        userMyself = new JMenuItem("�鿴���˵���Ϣ");
        userMyself.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new lookforInformation(u);
			}       	
        });
        users = new JMenuItem("�鿴���е��û�");
        users.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new queryAllUSers();
			}
        	
        });
		
		shopping_menu.add(product_menu);
		
		product_menu.add(queryAll);
		
		
		shopping_menu.addSeparator();
		shopping_menu.add(addProduct);
		
		order_menu.add(queryOrder);
	
		user_menu.add(userMyself);
		user_menu.add(users);
		
		

		menubar.add(shopping_menu);
		menubar.add(order_menu);
		menubar.add(info_menu);
		menubar.add(user_menu);
		
		this.setJMenuBar(menubar);
		
		this.setVisible(true);
	}
    //���ñ���ͼƬ
	void bg() {
		((JPanel)this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("C:/Users/14119/Desktop/pr/psb2.jpg");
		JLabel bg = new JLabel(img);
		this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
		bg.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
	}
}
