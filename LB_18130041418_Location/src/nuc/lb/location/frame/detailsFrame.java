package nuc.lb.location.frame;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import nuc.lb.location.entity.object;

public class detailsFrame extends JFrame{
	
	 JTextArea detail;
	 JLabel d = new JLabel("����",JLabel.CENTER);
	  public detailsFrame(object o) {
		this.setTitle("����鿴"); 
		this.setSize(600,580);
		this.setVisible(true);
		setbg();
		Font font = new Font("����",Font.BOLD,25);
		Font font2 = new Font("����",Font.PLAIN,15);
		System.out.println(o);
		detail = new JTextArea(o.getDescription()+",qq��"+o.getQq()+",�绰������ "+o.getNumber(),2,8);
		detail.setFont(font2);
		detail.setLineWrap(true); //�Զ�����
		//detail.setWrapStyleWord(true); //���У�������
		this.setLayout(null);	
		d.setBounds(55,420,100,40);
		d.setFont(font);
		detail.setBounds(160,425,300,100);
		this.add(d);
		this.add(detail);
	  }
	  void setbg() {
		  //����͸������Ϊfalse --->���Ǵ�����Ϊ͸��
		 ((JPanel)this.getContentPane()).setOpaque(false);
		  ImageIcon img = new ImageIcon("C:\\Users\\14119\\Desktop\\pr\\4.jpg"); 
		  JLabel background = new JLabel(img);
		  this.getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));
		  background.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
	  }
}
