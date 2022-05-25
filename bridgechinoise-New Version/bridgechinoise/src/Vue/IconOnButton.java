package Vue;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * 自定义图片按钮
 * @author lenovo
 *
 */
public class IconOnButton {
    //声明窗体
    private JFrame frame = null;
    //获取按钮方法
    public void getButtonss(){
        JFrame frame=new JFrame();
        //这里是不是该用来自内容根的路径比较好？
        String path="D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\images\\start.png";
        ImageIcon icon1=new ImageIcon(path);
        Image img = icon1.getImage();
        Image newimg = img.getScaledInstance(120,30,java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newimg);
        System.out.println(icon.getIconHeight());
        System.out.println(icon.getIconWidth());
        JButton button=new JButton(icon);
        button.setBounds(10,10,120,40);
        //JButton button=new JButton("Click Me!");//new出一个按钮的对象
        frame.add(button);//向容器加入组件
        frame.setSize(600,300);
        frame.setLocation(300,200);
        frame.setVisible(true);
    }


    public static void main(String[] args){
        IconOnButton iob = new IconOnButton();
        iob.getButtonss();
    }

}