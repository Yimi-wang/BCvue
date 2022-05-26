package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main extends JFrame implements ActionListener{
    JFrame mainframe;

    JFrame gameframe;

    Container mainContentPanel;

    Container gameContentPanel;

    JButton btnStartButton;
    JButton btnLoadButton;
    JButton btnSettingButton;
    JButton btnOnlineButton;

    //gameMode
    JButton GameModeQuestionButton; // ?按钮
    JButton GameModeLeftButton;//左箭头按钮
    JButton GameModeRightButton;//右箭头按钮
    JScrollPane GameModeInputJSP;//文本输入框，位于下来框下
    JLabel lblGameMode;//gamemode标签
    JComboBox GameModeComboBox;//单选框


    //AIMode
    JButton AIModeQuestionButton; // ?按钮
    JButton AIModeLeftButton;//左箭头按钮
    JButton AIModeRightButton;//右箭头按钮
    JLabel lblAIMode;//gamemode标签
    JComboBox AIModeComboBox;//单选框


    //牌
    // 玩家手上的牌
    List<Card> playerCards;

    //对手手上的牌
    List<Card> fighterCards;

    //定义六个牌堆
    List<Card> heapCardsList[] = new ArrayList[6];

    Card card[]=new Card[54];

    JTextField time[] = new JTextField[3]; //计时器

    boolean nextPlayer = false;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    Main window = new Main();
//                    window.mainframe.setVisible(true);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
        new Main();


    }

    /**
     * Create the application.
     */
    public Main() {
//        initialize();
//        mainframe.setVisible(true);
//        addEventListener();
        initializeGameFrame();
        gameframe.setVisible(true);
        CardInit();


    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // 初始化窗体
        mainframe = new JFrame("Bcvue game");
        mainframe.setBounds(300, 300, 720, 506);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainContentPanel = mainframe.getContentPane();

//        gameModePanel = new JPanel();
//        gameModePanel.setBounds(120, 120, 200, 200);
//        gameModePanel.setLayout(null);

        // 游戏文本标题
        JLabel jLabel = new JLabel("Bridge Chinois");
        jLabel.setBounds(30, 25, 300, 30);
        Font f = new Font("隶书",Font.PLAIN,30);
        jLabel.setFont(f);
        Color fg = new Color(255,255,255);
        jLabel.setForeground(fg);
        mainContentPanel.add(jLabel);

        // start按钮
        //加载背景图片
        String startPath="D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\images\\start.png";
        ImageIcon startIcon1=new ImageIcon(startPath);
        Image startImg = startIcon1.getImage();
        Image startNewimg = startImg.getScaledInstance(120,40,java.awt.Image.SCALE_SMOOTH);
        ImageIcon startIcon2 = new ImageIcon(startNewimg);
        btnStartButton = new RoundRectButton(startIcon2);
        btnStartButton.setBounds(30, 90, 120, 40);
        btnStartButton.setBorder(new RoundBorder(Color.WHITE));
        btnStartButton.setBackground(Color.RED);
        mainContentPanel.add(btnStartButton);


        // online
        //加载背景图片
        String onlinePath="D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\images\\online.png";
        ImageIcon onlineIcon1=new ImageIcon(onlinePath);
        Image onlineImg = onlineIcon1.getImage();
        Image onlineNewImg = onlineImg.getScaledInstance(120,40,java.awt.Image.SCALE_SMOOTH);
        ImageIcon onlineIcon2 = new ImageIcon(onlineNewImg);

        btnOnlineButton = new RoundRectButton(onlineIcon2);
        btnOnlineButton.setBounds(30, 150, 120, 40);
        mainContentPanel.add(btnOnlineButton);


        // load
        //加载背景图片
        String loadPath="D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\images\\load.png";
        ImageIcon loadIcon1=new ImageIcon(loadPath);
        Image loadImg = loadIcon1.getImage();
        Image loadNewImg = loadImg.getScaledInstance(120,40,java.awt.Image.SCALE_SMOOTH);
        ImageIcon loadIcon2 = new ImageIcon(loadNewImg);

        btnLoadButton = new RoundRectButton(loadIcon2);
        btnLoadButton.setBounds(30, 210, 120, 40);
        mainContentPanel.add(btnLoadButton);


        // load
        //加载背景图片
        String settingPath="D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\images\\setting.png";
        ImageIcon settingIcon1=new ImageIcon(settingPath);
        Image settingImg = settingIcon1.getImage();
        Image settingNewImg = settingImg.getScaledInstance(120,40,java.awt.Image.SCALE_SMOOTH);
        ImageIcon settingIcon2 = new ImageIcon(settingNewImg);

        btnSettingButton = new RoundRectButton(settingIcon2);
        btnSettingButton.setBounds(30, 270, 120, 40);
        mainContentPanel.add(btnSettingButton);

//        //添加gameMode
//        JLabel gameModeText = new JLabel("GameMode");
//        gameModePanel.add(gameModeText);
//        mainContentPanel.add(gameModePanel);

        lblGameMode = new JLabel("GameMode");
        lblGameMode.setBounds(200, 80, 300, 30);
        Font f1 = new Font("隶书",Font.PLAIN,30);
        lblGameMode.setFont(f1);
        Color fg1 = new Color(255,255,255);
        lblGameMode.setForeground(fg1);
        mainContentPanel.add(lblGameMode);

        GameModeComboBox = new JComboBox();
        // 绑定下拉框选项
        String[] strArray = { "BO1","BO3","Number of Fixe","Score Fixe"};
        for (String item : strArray)
        {
            GameModeComboBox.addItem(item);
        }
        GameModeComboBox.setFont(new Font("宋体", Font.PLAIN, 14));
        GameModeComboBox.setBounds(150, 140, 180, 30);
        mainContentPanel.add(GameModeComboBox);

        //添加问号按钮
        GameModeQuestionButton = new JButton("?");
        GameModeQuestionButton.setBounds(340, 140, 50, 30);
        mainContentPanel.add(GameModeQuestionButton);



        // 添加文本框
        JTextArea jta=new JTextArea("",7,30);
        jta.setLineWrap(true);    //设置文本域中的文本为自动换行
        jta.setForeground(Color.BLACK);    //设置组件的背景色
        jta.setFont(new Font("楷体",Font.BOLD,16));    //修改字体样式
        jta.setBackground(Color.white);    //设置按钮背景色
        GameModeInputJSP =new JScrollPane(jta);    //将文本域放入滚动窗口
        Dimension size=jta.getPreferredSize();    //获得文本域的首选大小
        GameModeInputJSP.setBounds(150,190,240,size.height);
        mainContentPanel.add(GameModeInputJSP);


        //添加左右按钮
        GameModeLeftButton = new JButton("←");
        GameModeLeftButton.setBounds(150, 340, 50, 30);
        mainContentPanel.add(GameModeLeftButton);
        GameModeRightButton = new JButton("→");
        GameModeRightButton.setBounds(340, 340, 50, 30);
        mainContentPanel.add(GameModeRightButton);


        // 添加AIMode**********************
        lblAIMode = new JLabel("AIMode");
        lblAIMode.setBounds(200, 80, 300, 30);
        Font f2 = new Font("隶书",Font.PLAIN,30);
        lblAIMode.setFont(f2);
        Color fg2 = new Color(255,255,255);
        lblAIMode.setForeground(fg2);
        mainContentPanel.add(lblAIMode);

        AIModeComboBox = new JComboBox();
        // 绑定下拉框选项
        String[] AIStrArray = { "AIrandom","AIsimple","AIminmax","AIrandom"};
        for (String item : AIStrArray)
        {
            AIModeComboBox.addItem(item);
        }
        AIModeComboBox.setFont(new Font("宋体", Font.PLAIN, 14));
        AIModeComboBox.setBounds(150, 140, 180, 30);
        mainContentPanel.add(AIModeComboBox);

        //添加问号按钮
        AIModeQuestionButton = new JButton("?");
        AIModeQuestionButton.setBounds(340, 140, 50, 30);
        mainContentPanel.add(AIModeQuestionButton);



        //添加左右按钮
        AIModeLeftButton = new JButton("←");
        AIModeLeftButton.setBounds(180, 240, 50, 30);
        mainContentPanel.add(AIModeLeftButton);
        AIModeRightButton = new JButton("→");
        AIModeRightButton.setBounds(300, 240, 50, 30);
        mainContentPanel.add(AIModeRightButton);


        // 设置背景, 背景要在最后面设置
        JLabel lblBackground = new JLabel(); // 创建一个标签组件对象
        URL resource = this.getClass().getResource("../images/MainMenu.png"); // 获取背景图片路径
        ImageIcon icon = new ImageIcon(resource); // 创建背景图片对象
        lblBackground.setIcon(icon); // 设置标签组件要显示的图标
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 设置组件的显示位置及大小
        mainContentPanel.add(lblBackground); // 将组件添加到面板中


        gameModeDisappear();
        AIModeDisappear();

    }



//    private void initGame(){
//        initializeGameFrame();
//        gameframe.setVisible(true);
//        CardInit();
//    }

    public void initializeGameFrame(){

        gameframe = new JFrame("Bcvue game");
        gameframe.setSize(1000,800);
        gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        gameframe.setResizable(false);
        gameframe.setLocationRelativeTo(getOwner()); // 屏幕居中
        gameContentPanel = gameframe.getContentPane();
        gameContentPanel.setLayout(null);

        gameContentPanel.setBackground(new Color(46,139,87)); //设置背景颜色


    }


    //初始化牌及牌的发牌动态效果演示
    private void CardInit(){
        int count =1 ;
//
//        Card card1 = new Card( "1-1", false);
//        card1.setBounds(100,100,70,100);
//        gameContentPanel.add(card1);

        //初始化牌
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 13; j++) {
                if (i == 5)
                    break;
                else {
                    card[count] = new Card( i + "-" + j, false);
                    card[count].setLocation(400, 250);
                    gameContentPanel.add(card[count]);
                    count++;
                }
            }
        }

        //打乱顺序
        for(int i=0;i<100;i++){
            Random random=new Random();
            int a=random.nextInt(52)+1;
            int b=random.nextInt(52)+1;
            Card k=card[a];
            card[a]=card[b];
            card[b]=k;
        }

        //开始发牌
        //初始化我的牌列表与对手牌列表
        fighterCards = new ArrayList<>();
        playerCards = new ArrayList<>();
        //先发两个人的牌
        boolean b=false;
        int t=0;
        for(int i=1;i<=22;i++){
            if(i%2==0){
                t++;
            }
            if(b){
                Common.move(card[i],card[i].getLocation(), new Point(340+t*25,620));
                card[i].canClick=true;
                playerCards.add(card[i]);
                card[i].turnFront();
                b = false;
            }else{
                Common.move(card[i],card[i].getLocation(), new Point(340+t*25,30));
                card[i].canClick=true;
                fighterCards.add(card[i]);
                card[i].turnBack();
                b = true;
            }
            gameContentPanel.setComponentZOrder(card[i], 0);
        }


        for(int i=0;i<=5;i++){
            heapCardsList[i]=new ArrayList<>();
        }

        int k=0;
        for(int i=23;i<53;i++){
            switch((i-23)%6){
                case 0:
                    Common.move(card[i],card[i].getLocation(), new Point(100+k*10,160));
                    heapCardsList[0].add(card[i]);
                    card[i].turnBack();
                    break;
                case 1:
                    Common.move(card[i],card[i].getLocation(), new Point(100+k*10,320));
                    heapCardsList[1].add(card[i]);
                    card[i].turnBack();
                    break;
                case 2:
                    Common.move(card[i],card[i].getLocation(), new Point(100+k*10,480));
                    heapCardsList[2].add(card[i]);
                    card[i].turnBack();
                    break;
                case 3:
                    Common.move(card[i],card[i].getLocation(), new Point(700+k*10,160));

                    heapCardsList[3].add(card[i]);
                    card[i].turnBack();
                    break;
                case 4:
                    Common.move(card[i],card[i].getLocation(), new Point(700+k*10,320));
                    heapCardsList[4].add(card[i]);
                    card[i].turnBack();
                    break;
                case 5:
                    Common.move(card[i],card[i].getLocation(), new Point(700+k*10,480));
                    heapCardsList[5].add(card[i]);
                    card[i].turnBack();
                    break;
                default:
                    break;

            }
            if(i%6==0)
                k++;
            //设置最新的牌在顶层
            gameContentPanel.setComponentZOrder(card[i], 0);
        }


        //重新对牌进行排序
        Common.order(fighterCards);
        Common.order(playerCards);
        Common.rePosition(gameContentPanel,fighterCards, 1); //0是fighter
        Common.rePosition(gameContentPanel,playerCards, 2); //1是player


    }


    //gameMode消失
    public void gameModeDisappear(){
        lblGameMode.setVisible(false);
        GameModeComboBox.setVisible(false);
        GameModeQuestionButton.setVisible(false);
        GameModeInputJSP.setVisible(false);
        GameModeLeftButton.setVisible(false);
        GameModeRightButton.setVisible(false);
    }


    //设置卡牌可被点击
    public void CardCanClick(boolean b){
        for(int i=1;i<53;i++){
            card[i].canClick=b;
        }
    }

    //gameMode出现
    public void gameModeAppear(){
        lblGameMode.setVisible(true);
        GameModeComboBox.setVisible(true);
        GameModeQuestionButton.setVisible(true);
        GameModeInputJSP.setVisible(true);
        GameModeLeftButton.setVisible(true);
        GameModeRightButton.setVisible(true);
    }


    public void AIModeDisappear(){
        lblAIMode.setVisible(false);
        AIModeComboBox.setVisible(false);
        AIModeQuestionButton.setVisible(false);
        AIModeLeftButton.setVisible(false);
        AIModeRightButton.setVisible(false);
    }
    public void AIModeAppear(){
        lblAIMode.setVisible(true);
        AIModeComboBox.setVisible(true);
        AIModeQuestionButton.setVisible(true);
        AIModeLeftButton.setVisible(true);
        AIModeRightButton.setVisible(true);
    }



    /**
     * 主界面按钮消失
     */
    public void mainFrameButtonDisappear(){
        btnStartButton.setVisible(false);
        btnLoadButton.setVisible(false);
        btnSettingButton.setVisible(false);
        btnOnlineButton.setVisible(false);
    }


    /**
     * 主界面按钮出现
     */
    public void mainFrameButtonAppear(){
        btnStartButton.setVisible(true);
        btnLoadButton.setVisible(true);
        btnSettingButton.setVisible(true);
        btnOnlineButton.setVisible(true);

    }

    //主JFrame按钮点击事件注册
    public void addEventListener() {

        //主界面按钮
        btnStartButton.addActionListener(this);
        btnLoadButton.addActionListener(this);
        btnOnlineButton.addActionListener(this);
        btnSettingButton.addActionListener(this);

        //gameMode按钮
        GameModeQuestionButton.addActionListener(this);
        GameModeLeftButton.addActionListener(this);
        GameModeRightButton.addActionListener(this);

        //AIMode按钮
        AIModeLeftButton.addActionListener(this);
        AIModeRightButton.addActionListener(this);
        AIModeQuestionButton.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnStartButton){
            mainFrameButtonDisappear();
            gameModeAppear();
        }
        if(e.getSource()== GameModeLeftButton){
            mainFrameButtonAppear();
            gameModeDisappear();
        }
        if(e.getSource()==GameModeRightButton){
            AIModeAppear();
            gameModeDisappear();
        }
        if(e.getSource()== GameModeQuestionButton){
            JOptionPane.showMessageDialog(null, "这里给出本游戏模式的疑问解答\r\n如果您有什么不懂的，可以联系我们121212@gmail.com\r\n", "提示", JOptionPane.QUESTION_MESSAGE);
        }
        if(e.getSource()==AIModeLeftButton){
            AIModeDisappear();
            gameModeAppear();
        }
        if(e.getSource()==AIModeRightButton){
            mainframe.setVisible(false);
//            initGame();
        }
        if(e.getSource()==AIModeQuestionButton){
            JOptionPane.showMessageDialog(null, "这里给出本游戏AI模式的疑问解答\r\n如果您有什么不懂的，可以联系我们121212@gmail.com\r\n", "提示", JOptionPane.QUESTION_MESSAGE);
        }
    }
}


