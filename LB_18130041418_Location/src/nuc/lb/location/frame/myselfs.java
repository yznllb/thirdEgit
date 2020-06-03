package nuc.lb.location.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import nuc.lb.location.dao.IObjectsDao;
import nuc.lb.location.dao.ObjectsDaoImpl;
import nuc.lb.location.entity.object;

public class myselfs extends JFrame{
	Object[] title = { "编号", "类型", "地址", "电话号码", "QQ", "简述", "名字" };
	Object[][] objects = new Object[100][7];
	int t = 0;
	
      public myselfs() {
    	this.setTitle("个人的失物信息");
  		this.setSize(460,577);
  		this.setVisible(true);
  		//Font font = new Font("楷体", Font.BOLD, 23);
  		init();
      }
      void init() {
    	  IObjectsDao dao = new ObjectsDaoImpl();
    	  Map<String,object> map = new HashMap<>();
    	  map = dao.getObjectsByIo();
    	  Set<String> keySet = map.keySet();
    	  for(Iterator<String> iter = keySet.iterator();iter.hasNext();) {
    		  String key = iter.next();
    		  object o = map.get(key);
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
    	  this.setLayout(null);
    	  JLabel t = new JLabel("查看个人信息",JLabel.CENTER);
    	  t.setFont(new Font("楷体",Font.BOLD,30));
    	  t.setBounds(5,5,200,120);
    	  this.add(t);
    	  
    	  JScrollPane pane = new JScrollPane();
    	  DefaultTableModel dtm = new DefaultTableModel(objects,title);
    	  JTable table = new JTable(dtm);
    	  table.setBounds(5,110,400,380);
    	  this.add(table);
    	  pane.setBounds(5,110,400,360);
    	  pane.getViewport().add(table);
    	  this.getContentPane().add(pane);
    	
    	  JButton ret = new JButton("返回");
    	  ret.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fun();
			}
    		  
    	  });
    	  ret.setBounds(240,487,100,40);
    	  this.add(ret);
    	  
      }
      void fun() {
    	  this.setVisible(false);
      }
}
