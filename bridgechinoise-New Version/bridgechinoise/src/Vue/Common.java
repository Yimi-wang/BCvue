package Vue;

import java.awt.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Common {



//    public static void move(Card card, Point from, Point to){
//        if(to.x != from.x){
//            double k=(1.0)*(to.y-from.y)/(to.x-from.x);
//            double b=to.y-to.x*k;
//            int flag=0;//判断向左还是向右移动步幅
//            if(from.x<to.x)
//                flag=20;
//            else {
//                flag=-20;
//            }
//            for(int i= from.x;Math.abs(i-to.x)>20;i+=flag){
//                double y = k*i+b;
//                card.setLocation(i,(int)y);
//                try{
//                    Thread.sleep(500);
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
//        }
//        //位置校准
//        card.setLocation(to);
//    }


    public static void move(Card card,Point from,Point to) {
        if (to.x != from.x) {
            double k = (1.0) * (to.y - from.y) / (to.x - from.x);
            double b = to.y - to.x * k;
            int flag = 0;//判断向左还是向右移动步幅
            if (from.x < to.x)
                flag = 20;
            else {
                flag = -20;
            }
            for (int i = from.x; Math.abs(i - to.x) > 20; i += flag) {
                double y = k * i + b;//这里主要用的数学中的线性函数

                card.setLocation(i, (int) y);
                try {
                    Thread.sleep(5); //延迟，可自己设置
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        //位置校准
        card.setLocation(to);
    }



    //对list排序
    public static void order(List<Card> list){
        Collections.sort(list,new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                // TODO Auto-generated method stub
                int a1=Integer.parseInt(o1.name.substring(0, 1));//花色
                int a2=Integer.parseInt(o2.name.substring(0,1));
                int b1=Integer.parseInt(o1.name.substring(2,o1.name.length()));//数值
                int b2=Integer.parseInt(o2.name.substring(2,o2.name.length()));
                int flag=0;

                //如果是A或者2
//                if(b1==1) b1+=20;
//                if(b2==1) b2+=20;
//                if(b1==2) b1+=30;
//                if(b2==2) b2+=30;
                flag=b2-b1;
                if(flag==0)
                    return a2-a1;
                else {
                    return flag;
                }
            }
        });
    }



    //重新定位 flag代表电脑1 ,2 或者是我
    public static void rePosition(Container gameContentPanel,List<Card> list,int flag){
        Point p=new Point();
        if(flag==1)
        {
            p.x=150+(list.size()+1)*15;
            p.y=30;
        }
        if(flag==2)
        {//我的排序 _y=450 width=830
            p.x=150+(list.size()+1)*15;
            p.y=620;
        }
        int len=list.size();
        for (Card card : list) {
            Common.move(card, card.getLocation(), p);
            gameContentPanel.setComponentZOrder(card, 0);
            p.x += 25;

        }
    }
}
