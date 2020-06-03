package nuc.lb.location.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import nuc.lb.location.dao.IObjectsDao;
import nuc.lb.location.dao.ObjectsDaoImpl;
import nuc.lb.location.entity.object;

public class AddObject extends JFrame{
	
	JTextField otype,oplace,onumber,oqq,odescription,oname,oid;
	JButton click;
	JLabel type,place,number,qq,description,name,id;
	
     public AddObject() {
    	 this.setVisible(true);
 	     this.setTitle("���ʧ����Ʒ");
 	     this.setSize(520,670);
 	     init();
     }
     void init() {
    	 Font font = new Font("����",Font.BOLD,20);
    	 otype = new JTextField();
    	 oplace = new JTextField();
    	 onumber = new JTextField();
    	 oqq = new JTextField();
    	 odescription = new JTextField();
    	 oname = new JTextField();
    	 oid = new JTextField();
    	 
    	 type = new JLabel("��Ʒ����",JLabel.CENTER);
    	 place = new JLabel("���ֵ�ַ",JLabel.CENTER);
    	 number = new JLabel("��ϵ��ʽ",JLabel.CENTER);
    	 qq = new JLabel("����QQ",JLabel.CENTER);
    	 description = new JLabel("��Ʒ����",JLabel.CENTER);
    	 name = new JLabel("��Ʒ����",JLabel.CENTER);
    	 id = new JLabel("��Ʒ���",JLabel.CENTER);
    	 
    	 
    	 click = new JButton("�ύ����");
    	 click.setFont(font);
    	 
    	 JLabel title = new JLabel("ʧ������",JLabel.CENTER);
    	 title.setFont(new Font("����",Font.BOLD,30));
         title.setBounds(5,5,200,100);
         this.add(title);
       
    	 this.setLayout(null);
    	 type.setBounds(5,130,100,50);
    	 type.setFont(font);
    	 this.add(type);
    	 otype.setBounds(110,130,200,40);
    	 this.add(otype);
    	 //==================
    	 place.setBounds(5,190,100,50);
    	 place.setFont(font);
    	 this.add(place);
    	 oplace.setBounds(110,190,200,40);
    	 this.add(oplace);
    	 //===================
    	 number.setBounds(5,250,100,50);
    	 number.setFont(font);
    	 this.add(number);
    	 onumber.setBounds(110,250,200,40);
    	 this.add(onumber);
    	 //===================
    	 qq.setBounds(5,310,100,50);
    	 qq.setFont(font);
    	 this.add(qq);
    	 oqq.setBounds(110,310,200,40);
    	 this.add(oqq);
    	 //===================
    	 description.setBounds(5,380,100,50);
    	 description.setFont(font);
    	 this.add(description);
    	 odescription.setBounds(110,380,200,40);
    	 this.add(odescription);
    	 //====================    	 
    	 name.setBounds(5,450,100,50);
    	 name.setFont(font);
    	 this.add(name);
    	 oname.setBounds(110,450,200,40);
    	 this.add(oname);
    	//====================    	 
    	 id.setBounds(5,520,100,50);
    	 id.setFont(font);
    	 this.add(id);
    	 oid.setBounds(110,520,200,40);
    	 this.add(oid);
    	//
    	 click.setBounds(155,580,130,50);
    	 this.add(click);
    	 click.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 //���
		    	 IObjectsDao dao = new ObjectsDaoImpl();
		    	
		    	 String stype,splace,snumber,sqq,sdescription,sname; int sid;
		    	 stype = otype.getText();
		    	 splace = oplace.getText();
		    	 snumber = onumber.getText();
		    	 sqq = oqq.getText();
		    	 sdescription = odescription.getText();
		    	 sname = oname.getText();
		    	 sid = Integer.parseInt(oid.getText());
		    	 object o = new object(sid,stype,splace,snumber,sqq,sdescription,sname);
		    	 boolean flag = false;
		    	 flag = dao.addObject(o);
		    	 if(flag=true) {
		    		 showMessage("��ӳɹ�");
		    		 fun();
		    	 }else {
		    		 showMessage("���ʧ��,��������ȷ����Ϣ");
		    		 otype.setText("");
		    		 oplace.setText("");
		    		 onumber.setText("");
		    		 oqq.setText("");
		    		 odescription.setText("");
		    		 oname.setText("");
		    		 oid.setText("");
		    	 }
			}	 
    	 });
    	 
    	
     }
     void showMessage(String s) {
    	 JOptionPane.showMessageDialog(this,s);
     }
     void fun() {
    	 this.setVisible(false);
     }
}


