package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Card extends JLabel implements MouseListener{

	String name;//ͼƬurl����
	boolean up;//�Ƿ�������
	boolean canClick=false;//�Ƿ�ɱ����
	boolean clicked=false;//�Ƿ�����
	public Card( String name, boolean up){
		this.name=name;
		this.up=up;
	    if(this.up)
	    	this.turnFront();
	    else {
			this.turnBack();
		}
		this.setSize(71, 96);
		this.setVisible(true);
		this.addMouseListener(this);
	}
	//����
	public void turnFront() {
		//SwingUtil������ʹ��ImageIcon�ȱ�����С��ȫ��䡣
		this.setIcon(SwingUtil.createAutoAdjustIcon("D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\res\\images\\" + name + ".gif", true));
		this.up = true;
	}
	//����
	public void turnBack() {
		this.setIcon(SwingUtil.createAutoAdjustIcon("D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\res\\images\\back.gif", true));
		this.up = false;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(canClick)
		{
			Point from=this.getLocation();
			int step; //�ƶ��ľ���
			if(clicked)
				step=-20;
			else {
				step=20;
			}
			clicked=!clicked; //����
			//����ѡ�е�ʱ����ǰ�ƶ�һ��/����һ��
			Common.move(this,from,new Point(from.x,from.y-step));
		}
	}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}

}
