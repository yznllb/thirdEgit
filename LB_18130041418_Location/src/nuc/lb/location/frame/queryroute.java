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
    String[] place = {"��¥","ͼ���","�ݷ�¥","�»�¥","ʮ��¥","���ѧԺ","����ɽ","��Ӿ��",
    		"�����","����","����","��ë��","�б��Ƶ�","���ٳ�"
    		,"������Ԣ","��Ӯ��Ԣ",};
    int b=0,endness=0;
    
    public queryroute() {
    	this.setTitle("�������");
    	this.setSize(660,680);
    	this.setVisible(true);
    	setBg();
    	init();
    }
    
    void init() {
    	begin = new JLabel("������",JLabel.CENTER);
    	end = new JLabel("Ŀ�ĵ�",JLabel.CENTER);
    	distance = new JLabel("�����̾���",JLabel.CENTER);
    	time = new JLabel("Ԥ�Ƶ���ʱ��",JLabel.CENTER);
    	choose1 = new JComboBox();
    	choose2 = new JComboBox();
    	init2();
    	d = new JTextField();
    	t = new JTextField();
    	click = new JButton("��ѯ");
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
				//System.out.println("����Ϊ-----"+dist);
				String s =null;
				s = String.valueOf(dist);
				d.setText(s);
				
				String s2 =null;
				s2 =String.valueOf(utime);
				t.setText(s2+"����");
				if(flag) {
					d.setText("0");
					t.setText("0����");
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
    	//����
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
    	choose1.addItem("��¥"); choose1.addItem("ͼ���"); 
    	choose1.addItem("�ݷ�¥");
    	choose1.addItem("�»�¥"); choose1.addItem("ʮ��¥");
    	choose1.addItem("���ѧԺ");
    	choose1.addItem("����ɽ"); choose1.addItem("�����"); 
    	choose1.addItem("��Ӿ��");
    	choose1.addItem("����"); choose1.addItem("����");
    	choose1.addItem("��ë���");
    	choose1.addItem("�б��Ƶ�"); choose1.addItem("���ٳ�");
    	choose1.addItem("������Ԣ");choose1.addItem("��Ӯ��Ԣ");
    	
    	
    	choose2.addItem("��¥"); choose2.addItem("ͼ���"); choose2.addItem("�ݷ�¥");
    	choose2.addItem("�»�¥"); choose2.addItem("ʮ��¥"); choose2.addItem("���ѧԺ");
    	choose2.addItem("����ɽ"); choose2.addItem("�����"); choose2.addItem("��Ӿ��");
    	choose2.addItem("����"); choose2.addItem("����"); choose2.addItem("��ë���");
    	choose2.addItem("�б��Ƶ�"); choose2.addItem("���ٳ�");
    	choose2.addItem("������Ԣ");choose2.addItem("��Ӯ��Ԣ");
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
