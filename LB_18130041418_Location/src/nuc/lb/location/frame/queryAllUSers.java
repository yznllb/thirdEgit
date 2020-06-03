package nuc.lb.location.frame;

import java.awt.Font;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import nuc.lb.location.dao.IUserDao;
import nuc.lb.location.dao.UserDaoImpl;
import nuc.lb.location.entity.User;
import nuc.lb.location.entity.object;

public class queryAllUSers extends JFrame{
     JButton ret;
    JLabel l_bName;
 	JTextField t_bName;
 	JLabel t;
 	JButton b_query;
 	JTable t_books;
 	Object[] title = { "�û��˺�", "����", "�绰����", "סַ", "΢��", "�꼶���", "�û�����" };
 	Object[][] objects = new Object[100][7];
 	int f = 0;
 	public queryAllUSers() {
 		this.setTitle("���е��û���Ϣ");
		this.setSize(450,500);
		this.setVisible(true);
		Font font = new Font("����", Font.BOLD, 23);
		init();
 	}
 	void init() {
 		
 		IUserDao dao = new UserDaoImpl();
 		Map<String,User> map = dao.getUsers();
 		Set<String> keySet = map.keySet();
 		User[] us = null;
 		for(Iterator<String> iter = keySet.iterator();iter.hasNext();) {
 			String key = iter.next();
			User u = map.get(key);
			for (int j = 0; j < 7; j++) {
				switch (j) {
				case 0:
					objects[f][j] = u.getStuid();
					break;
				case 1:
					objects[f][j] = u.getName();
					break;
				case 2:
					objects[f][j] = u.getNumber();
					break;
				case 3:
					objects[f][j] = u.getHome();
					break;
				case 4:
					objects[f][j] = u.getWechat();
					break;
				case 5:
					objects[f][j] = u.getId();
					break;
				case 6:
					objects[f++][j] = u.getPassword();
					break;
				}
			}
 		}
 		this.setLayout(null);
 		t = new JLabel("���е��û�",JLabel.CENTER);
 		t.setFont(new Font("����",Font.BOLD,30));
 		t.setBounds(5,5,200,120);
 		this.add(t);
 		JScrollPane pane = new JScrollPane();
		t_books = new JTable(objects, title);

		// �������ӵ��������
		pane.getViewport().add(t_books);
		pane.setBounds(5,100,420,340);
		this.getContentPane().add(pane);
 	}
}
