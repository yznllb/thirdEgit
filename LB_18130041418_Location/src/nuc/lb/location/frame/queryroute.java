package nuc.lb.location.frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import nuc.lb.location.db.distance_dij;

public class queryroute extends JFrame{
    JLabel begin,end,distance,time;
    JComboBox choose1,choose2;
    JTextField d,t;
    JButton click;
    String[] place = {"主楼","图书馆","逸夫楼","德怀楼","十号楼","软件学院","二龙山","游泳馆",
    		"窦大夫祠","篮球场","足球场","羽毛球场","中北酒店","主操场"
    		,"文澜公寓","文赢公寓",};
    int b=0,endness=0;
    
    public queryroute() {
    	this.setTitle("距离把握");
    	this.setSize(660,680);
    	this.setVisible(true);
    	setBg();
    	init();
    }
    
    void init() {
    	begin = new JLabel("出发点",JLabel.CENTER);
    	end = new JLabel("目的地",JLabel.CENTER);
    	distance = new JLabel("相距最短距离",JLabel.CENTER);
    	time = new JLabel("预计到达时间",JLabel.CENTER);
    	choose1 = new JComboBox();
    	choose2 = new JComboBox();
    	init2();
    	d = new JTextField();
    	t = new JTextField();
    	click = new JButton("查询");
    	click.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				d.setText("");
				String begin = (String) choose1.getSelectedItem();
				String end = (String) choose2.getSelectedItem();
				boolean flag = false;
				if(begin.equals(end)) {
					flag=true;
				}
				for(int i=0;i<place.length;i++) {
					if(place[i].equals(begin)) {
						b=i;
					}else if(place[i].equals(end)) {
						endness=i;
					}
				}
				//System.out.println("begin=="+b+"end==="+endness);
				//distance_dij dij = new distance_dij(b,e);
				int dist = distance_dij.fun(b,endness);
				int utime = dist/60;
				if(dist%60!=0) {
					utime+=1;
				}
				//System.out.println("距离为-----"+dist);
				String s =null;
				s = String.valueOf(dist);
				d.setText(s);
				
				String s2 =null;
				s2 =String.valueOf(utime);
				t.setText(s2+"分钟");
				if(flag) {
					d.setText("0");
					t.setText("0分钟");
				}
			} 		
    	});
    	
    	
    	
    	this.setLayout(null);
    	begin.setBounds(5,450,100,30);
    	this.add(begin);
    	choose1.setBounds(120,450,100,30);
    	this.add(choose1);
    	end.setBounds(235,450,100,30);
    	this.add(end);
    	choose2.setBounds(350,450,100,30);
    	this.add(choose2);
    	//布局
    	JPanel p = new JPanel();
    	p.setOpaque(false);
    	p.setLayout(new GridLayout(3,2,10,10));
    	p.add(distance);
    	p.add(d);
    	p.add(time);
    	p.add(t);
    	p.setBounds(25,500,200,140);
    	this.add(p);
    	click.setBounds(375,520,100,45);
    	this.add(click);
    }
    void init2() {
    	choose1.addItem("主楼"); choose1.addItem("图书馆"); 
    	choose1.addItem("逸夫楼");
    	choose1.addItem("德怀楼"); choose1.addItem("十号楼");
    	choose1.addItem("软件学院");
    	choose1.addItem("二龙山"); choose1.addItem("窦大夫祠"); 
    	choose1.addItem("游泳馆");
    	choose1.addItem("篮球场"); choose1.addItem("足球场");
    	choose1.addItem("羽毛球馆");
    	choose1.addItem("中北酒店"); choose1.addItem("主操场");
    	choose1.addItem("文澜公寓");choose1.addItem("文赢公寓");
    	
    	
    	choose2.addItem("主楼"); choose2.addItem("图书馆"); choose2.addItem("逸夫楼");
    	choose2.addItem("德怀楼"); choose2.addItem("十号楼"); choose2.addItem("软件学院");
    	choose2.addItem("二龙山"); choose2.addItem("窦大夫祠"); choose2.addItem("游泳馆");
    	choose2.addItem("篮球场"); choose2.addItem("足球场"); choose2.addItem("羽毛球馆");
    	choose2.addItem("中北酒店"); choose2.addItem("主操场");
    	choose2.addItem("文澜公寓");choose2.addItem("文赢公寓");
    }
    public void setBg() {
	       ((JPanel)this.getContentPane()).setOpaque(false); 
			ImageIcon img = new ImageIcon
			("C:/Users/14119/Desktop/pr/psb.jpg"); 
			JLabel background = new JLabel(img);
			this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); 
			background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight()); 
	}
}
