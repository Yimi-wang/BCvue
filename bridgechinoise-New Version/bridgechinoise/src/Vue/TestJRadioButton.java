package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestJRadioButton {

    public static void main(String[] args)  {
        //定义单选按钮
        ButtonGroup group=new ButtonGroup();
        JRadioButton networkButton=new JRadioButton("网络",true);
        group.add(networkButton);
        JRadioButton blueToothButton=new JRadioButton("蓝牙",false);
        group.add(blueToothButton);
        //ButtonGroup放在JPanel中
        JPanel ButtonPanel=new JPanel();
        ButtonPanel.add(networkButton);
        ButtonPanel.add(blueToothButton);
        //Panel放在JFrame中
        JFrame jf=new JFrame("单选按钮");
        jf.add(ButtonPanel, BorderLayout.CENTER);
        //加上一个Jlable,改变单选按钮时，jlable也相应变化
        JLabel label=new JLabel();
        label.setText("默认");
        jf.add(label,BorderLayout.NORTH);
        jf.pack();
        jf.setVisible(true);
        //改变时定义监听器
        ActionListener listener=new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                switch (e.getActionCommand()) {
                    case "网络":
                        label.setText("网络");
                        break;
                    case "蓝牙":
                        label.setText("蓝牙");
                        break;
                    default:
                        break;
                }
            }
        };//listener
        //定义单选按钮监听器
        networkButton.addActionListener(listener);
        blueToothButton.addActionListener(listener);
    }//main

}
