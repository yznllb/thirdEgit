package nuc.lb.location.frame;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import nuc.lb.location.dao.IUserDao;
import nuc.lb.location.dao.UserDaoImpl;
import nuc.lb.location.entity.User;
import nuc.lb.location.service.IUserService;
import nuc.lb.location.service.UserServiceImpl;

public class Login extends JFrame {
	static Boolean flag;
	JLabel l_name, l_type, l_password;
	static JTextField t_name;
	JPasswordField t_password;
	JButton b_login, b_reset, b_register;
	IUserService uService = new UserServiceImpl();

	public Login() {
		// TODO Auto-generated constructor stub
		this.setTitle("快来领我！");
		this.setSize(530, 420);
		this.setLocation(200, 100);
		this.setFont(new Font("楷体", 30, 30));
	    init();
		this.setVisible(true);
	}
	public void init() {
		this.setLayout(null);
		l_name = new JLabel("用户名", JLabel.CENTER);
		l_password = new JLabel("用户密码", JLabel.CENTER);
		t_name = new JTextField();
		t_password = new JPasswordField();
		
		
		
		
		// 管理的登陸界面
		b_login = new JButton("登录");
		b_login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(t_name.getText());
				String password = new String(t_password.getPassword());
				User t =null;
				IUserDao dao = new UserDaoImpl();
				t = dao.query(id);
				//User u = new User(id,password);
				if (uService.login(t)) {
				     new MainFrame(t);
				     fun();
				} else {
					showMessage("用户名或密码不正确，请重新输入！");
					t_name.setText("");
					t_password.setText("");
					t_name.setFocusable(true);
					// setFocusable设置组件是否可被选中，
					// 将控件设置成可获取焦点状态，默认是无法获取焦点的，
					// 只有设置成true，才能获取控件的点击事件
				}
			}
		});
		b_reset = new JButton("重置");
		b_reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				t_name.setText("");
				t_password.setText("");
			}		
		});
		b_register = new JButton("点我注册");
		b_register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int stuid = Integer.parseInt(t_name.getText());
				String password = new String(t_password.getPassword());
				if (password.equals("")) {
					showMessage("用户名或密码不能为空！");
				} else {
					User u = new User(stuid,password);
					String message = uService.register(u);
					showMessage(message);
				}
			}

		});
		//布局
		setBg();
		JPanel p = new JPanel();
		p.setOpaque(false);
		p.setLayout(new GridLayout(3,2,4,4));
		p.add(l_name);
		p.add(t_name);
		p.add(l_password);
		p.add(t_password);
		p.setBounds(5, 135, 300, 135);
		this.add(p);

		p = new JPanel();
		p.setLayout(new GridLayout(1, 3, 5, 5));
		p.add(b_login);
		p.add(b_reset);
		p.add(b_register);
		p.setBounds(30, 310, 450, 50);
		this.add(p);
	}

	public void showMessage(String name) {
		JOptionPane.showMessageDialog(this, name);
	}

	public static void main(String[] args) {
		new Login();
	}
	void fun() {
		this.setVisible(false);
	}
	public void setBg() {
	       ((JPanel)this.getContentPane()).setOpaque(false); 
			ImageIcon img = new ImageIcon
			("D:/icon/nuc2.jpg"); 
			JLabel background = new JLabel(img);
			this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); 
			background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight()); 
	}
	//JLayeredPane 允许组件在需要时互相重叠
	//add前一个参数是组件，后一个参数是Integer对象，
	//Integer指定容器中每个组件的深度，其中编号较高的组件位于其他组件之上。 
}
