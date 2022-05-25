package Vue;

import Modele.Brand;
import Modele.GameProcessVue;
import Modele.Jeu;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
/*
参考网站https://stackoverflow.com/questions/48758977/how-to-display-cards-in-a-card-game-in-java-and-have-them-clickable-for-selectio
网站上是在cards建立了手牌，而我则是在Modele中的Gameprocess中建立手牌，都是link，playercard【0】就是我的手牌
现在有bug，问题估计出在鼠标监听上。
 */
public class cards implements Runnable {
    Jeu j;

    public static void start() {
        SwingUtilities.invokeLater(new cards());
    }

    public void run() {
        //不知道用处
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        //保证Jeu j playercard 里头有手卡
        GameProcessVue gameprocessvue = new GameProcessVue();
        j = gameprocessvue.creatJeu();
        //gameprocessvue.gameMode(j);（启动游戏）

        //界面
        JFrame frame = new JFrame("Testing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //end

        //填充手牌
        frame.add(new GamePane(j));
        //end
        //初始化正常界面大小
        frame.pack();
        //end

        //窗口位于屏幕中间
        frame.setLocationRelativeTo(null);
        //end

        //显示窗口
        frame.setVisible(true);
    }

    //构造函数
    public cards() {
    }

    public Iterable<Brand> reveresed(LinkedList<Brand> brands) {
        List<Brand> reversed = j.playercard[0];
        Collections.reverse(reversed);
        return reversed;
    }

    public class GamePane extends JPanel {
        private Map<Brand, Rectangle> mapCards;

        private Brand selected;

        public GamePane(Jeu j) {
            //点击鼠标，如果点击是卡的位置，则会将卡向上移，不是的话已经移动过的卡回退原来的位置）

            mapCards = new HashMap<>(j.playercard[0].size());

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (selected != null) {
                        Rectangle bounds = mapCards.get(selected);
                        bounds.y += 30;
                        repaint();
                    }
                    selected = null;
                    // This is done backwards, as the last card is on
                    // top.  Of course you could render the cards
                    // in reverse order, but you get the idea
                    /*
                        应该是这里的reserved方程有问题，才导致bug
                        原来的方法也是把玩家手卡的内容颠倒顺序，说实话我不知道为什么要这么做
                     */
                    //List<Brand> playercardinverse = (List<Brand>) reveresed(j.playercard[0]);
                        //for (Brand card : playercardinverse) {
                        for(Brand card : j.playercard[0]){
                        Rectangle bounds = mapCards.get(card);
                        if (bounds.contains(e.getPoint())) {
                            selected = card;
                            bounds.y -= 30;
                            //打印玩家手牌
                            System.out.println(card.toString());
                            repaint();
                            break;
                        }
                    }
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(1200, 400);
        }

        @Override
        public void invalidate() {
            super.invalidate();
            mapCards.clear();
            //画长方形，并且将每个长方形和card绑定
            //确定每个卡片的高与宽
            int cardHeight = (getHeight() - 20) / 6;
            int cardWidth = (int) (cardHeight * 0.6);
            //int xDelta = cardWidth / 2;
            //每个卡片的偏移量
            int xDelta = cardWidth +5;
            //int xPos = (int) ((getWidth() / 2) - (cardWidth * (j.playercard[0].size() / 4.0)));
            //第一个卡片的横坐标和纵坐标
            int xPos = getWidth() / 10;
            int yPos = (getHeight() - 20) - cardHeight;
            //建立一个hashmap，使每个长方形和每个卡片进行对应。
            for (Brand card : j.playercard[0]) {
                Rectangle bounds = new Rectangle(xPos, yPos, cardWidth, cardHeight);
                mapCards.put(card, bounds);
                xPos += xDelta;
            }
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();


            for (Brand card : j.playercard[0]) {
                Rectangle bounds = mapCards.get(card);
                //System.out.println(bounds);
                //根据长方形的位置，填充图片
                if (bounds != null) {
                    BufferedImage imageCard;
                    File imgFile = new File("./bridgechinoise-New Version/bridgechinoise/res/images/card (" + card.id + ").gif");
                    try {
                        imageCard = ImageIO.read(imgFile);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    int cardHeight = (getHeight() - 20) / 6;
                    int cardWidth = (int) (cardHeight * 0.6);
                    //画图像
                    g2d.drawImage(imageCard, bounds.x, bounds.y, cardWidth, cardHeight, null);
                    //画长方形边框
                    g2d.setColor(Color.BLACK);
                    g2d.draw(bounds);
                }
            }
            g2d.dispose();
        }

    }

}