package nuc.lb.location.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import nuc.lb.location.dao.IObjectsDao;
import nuc.lb.location.dao.ObjectsDaoImpl;
import nuc.lb.location.entity.object;

public class QueryAllObjectFrame extends JFrame {

	JLabel l_bName;
	JTextField t_bName;
	JLabel l_bClass;
	JComboBox<String> c_bClass;
	JButton b_query;
	JTable t_books;
	Object[] title = { "编号", "类型", "地址", "电话号码", "QQ", "简述", "名字" };
	Object[][] objects = new Object[100][7];
	int t = 0;

	public QueryAllObjectFrame() {
		this.setTitle("所有的失物信息");
		this.setSize(525, 500);
		this.setVisible(true);
		Font font = new Font("楷体", Font.BOLD, 23);
		l_bName = new JLabel("失物编号");
		t_bName = new JTextField();
		l_bClass = new JLabel("类别", JLabel.CENTER);
		b_query = new JButton("查询");
		b_query.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				init3();
				init4();
			}
		});
		init();
	}

	void init() {
		// 定义一个一维数组和二维数组
         
		String s[] = new String[4];
		c_bClass = new JComboBox<String>();
		
		Object[][] objects = new Object[100][7];
		Book[] bookList = null;
		IObjectsDao b = new ObjectsDaoImpl();
		Map<String, object> map = b.getObjects();
		Set<String> keyset = map.keySet();
		for (Iterator<String> iter = keyset.iterator(); iter.hasNext();) {
			String key = iter.next();
			object o = map.get(key);
			c_bClass.addItem(o.getUname());
			for (int j = 0; j < 7; j++) {
				switch (j) {
				case 0:
					objects[t][j] = o.getUid();
					break;
				case 1:
					objects[t][j] = o.getOtype();
					break;
				case 2:
					objects[t][j] = o.getPlace();
					break;
				case 3:
					objects[t][j] = o.getNumber();
					break;
				case 4:
					objects[t][j] = o.getQq();
					break;
				case 5:
					objects[t][j] = o.getDescription();
					break;
				case 6:
					objects[t++][j] = o.getUname();
					break;
				}
			}
		}
		JScrollPane pane = new JScrollPane();
		t_books = new JTable(objects, title);
		this.setLayout(null);
		// 自定义布局
		l_bName.setBounds(10, 10, 80, 30);
		this.add(l_bName);

		t_bName.setBounds(100, 10, 80, 30);
		this.add(t_bName);

		l_bClass.setBounds(300, 10, 80, 30);
		this.add(l_bClass);

		c_bClass.setBounds(400, 10, 80, 30);
		this.add(c_bClass);

		b_query.setBounds(190, 10, 80, 30);
		this.add(b_query);

		t_books.setBounds(10, 50, 480, 380);
//    		this.add(t_books);
		pane.setBounds(10, 50, 480, 360);

		// 表格组件加到滚动面板
		pane.getViewport().add(t_books);

		this.getContentPane().add(pane);
	}

	public void showMessage(String name) {
		JOptionPane.showMessageDialog(this, name);
	}

	void init3() {
        	String getID = t_bName.getText();
			int id = Integer.parseInt(getID);
			//根据书籍的id来查询
			IObjectsDao dao = new ObjectsDaoImpl();
			object o = new object();
			o = dao.query(id);
			if(null == o) {
				showMessage("抱歉,此书籍不存在,请输入正确的书籍编号");
			}else {
        	Object[][] only = new Object[100][7];
			for (int j = 0; j < 7; j++) {
				switch (j) {
				case 0:
					only[0][j] = o.getUid();
					break;
				case 1:
					only[0][j] = o.getOtype();
					break;
				case 2:
					only[0][j] = o.getPlace();
					break;
				case 3:
					only[0][j] = o.getNumber();
					break;
				case 4:
					only[0][j] = o.getQq();
					break;
				case 5:
					only[0][j] = o.getDescription();
					break;
				case 6:
					only[0][j] = o.getUname();
					break;
				}
			}
			JScrollPane pane = new JScrollPane();
	        DefaultTableModel dtm= new DefaultTableModel(only,title);//定义表格模型
			JTable table1 = new JTable(dtm);
			table1.setBounds(10,50,480,380);
			
			pane.setBounds(10, 50,480, 360);
			pane.getViewport().add(table1);
			this.getContentPane().add(pane);
			//System.out.println("此时的t=="+t);
			for(int i=1;i<t;i++) {
			  dtm.removeRow(i) ;
			}
			//刷新
			dtm.fireTableDataChanged();
           }
	}

	void init4() {

		String getID = t_bName.getText();
		int id = Integer.parseInt(getID);
		JButton check = new JButton("查看详情");
		check.setBounds(350, 420, 80, 40);
		this.add(check);
		// this.invalidate();
		//this.repaint();
		init3();
		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IObjectsDao dao = new ObjectsDaoImpl();
				object o = new object();
				o = dao.query(id);
				detailsFrame t = new detailsFrame(o);
			}
		});

	}
}
