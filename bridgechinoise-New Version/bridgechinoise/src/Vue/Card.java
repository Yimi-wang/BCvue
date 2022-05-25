package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Card extends JLabel implements MouseListener{

	String name;//图片url名字
	boolean up;//是否正反面
	boolean canClick=false;//是否可被点击
	boolean clicked=false;//是否点击过
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
	//正面
	public void turnFront() {
		//SwingUtil工具类使得ImageIcon等比例缩小完全填充。
		this.setIcon(SwingUtil.createAutoAdjustIcon("D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\res\\images\\" + name + ".gif", true));
		this.up = true;
	}
	//反面
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
			int step; //移动的距离
			if(clicked)
				step=-20;
			else {
				step=20;
			}
			clicked=!clicked; //反向
			//当被选中的时候，向前移动一步/后退一步
			Common.move(this,from,new Point(from.x,from.y-step));
		}
	}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}

}
