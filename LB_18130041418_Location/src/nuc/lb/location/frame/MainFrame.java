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
	//菜单条
	JMenuBar menubar;
	//菜单
	JMenu shopping_menu, order_menu, info_menu, user_menu,product_menu;
	//菜单项
	JMenuItem userMyself,users;
	JMenuItem queryAll, queryByName, queryByType, addProduct, deleteProduct, queryOrder, delectOrder, queryInfo, addSelfInfo, modifySelfInfo,queryLocation;
	public MainFrame(User u) {
		//设置在此窗体上发出的close请求
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(632, 768);
		bg();
		this.setTitle("易码招领平台系统【欢迎ID"+": "+ u.getStuid() + "登录系统！】");
		menubar = new JMenuBar();
		
		shopping_menu = new JMenu("失物管理");		
		order_menu = new JMenu("个人挂失");
		user_menu = new JMenu("用户信息");
		
		info_menu = new JMenu("距离规划");	
		queryLocation = new JMenuItem("距离查询");
		info_menu.add(queryLocation);
		queryLocation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new queryroute();
			}
		});
		product_menu = new JMenu("查询商品信息");

		
		queryAll = new JMenuItem("所有失物"); 
		queryAll.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				 new QueryAllObjectFrame();				
			}
		});
		queryByName = new JMenuItem("按商品名称查询");
		queryByName.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			//	new QueryBookByName();
			}
			
		});
		queryByType = new JMenuItem("按商品类别查询");
		queryByType.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {		
			//	new QueryBookByType();
			}
			
		});
		addProduct = new JMenuItem("添加失物");
		addProduct.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				new AddObject();
			}
			
		});
		deleteProduct = new JMenuItem("删除失物");
		deleteProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	//		new deleteBooks();			
			}		
		});
		queryOrder = new JMenuItem("查看个人物品");
		queryOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
 				new myselfs();
			}		
		});
		
		
        userMyself = new JMenuItem("查看个人的信息");
        userMyself.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new lookforInformation(u);
			}       	
        });
        users = new JMenuItem("查看所有的用户");
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
    //设置背景图片
	void bg() {
		((JPanel)this.getContentPane()).setOpaque(false);
		ImageIcon img = new ImageIcon("C:/Users/14119/Desktop/pr/psb2.jpg");
		JLabel bg = new JLabel(img);
		this.getLayeredPane().add(bg,new Integer(Integer.MIN_VALUE));
		bg.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
	}
}
