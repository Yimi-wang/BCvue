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

    //桌面已出的牌
    List<Card> sentCards;

    // 已翻面但还未出的牌
    List<Card> frontCards;

    //定义六个牌堆
    List<Card> heapCardsList[] = new ArrayList[6];

    Card card[]=new Card[54];

    JTextField time[] = new JTextField[3]; //计时器

    boolean isAISending = false;


    //分支记录参数及标签
    JLabel gameScoreLabel;

    int playerScore=0;

    JLabel playerScoreLabel;

    int fighterScore=0;

    JLabel fighterScoreLabel;

    //出牌按钮
    JButton sendCardButton;

    //替换Card
    Card tCard;


    //Settings 设置
    JFrame settingJframe;

    Container settingContentPanel;

    JLabel settingJLabel;

    JLabel settingDesktoplbl;

    JLabel settingCardBack;

    JLabel settingShowCard;



    JRadioButton backradioBtn1;

    JRadioButton backradioBtn2;

    JRadioButton backradioBtn3;

    JRadioButton cardRadioBtn1;

    JRadioButton cardRadioBtn2;

    JRadioButton cardRadioBtn3;

    JRadioButton cardShowBtn1;

    JRadioButton cardShowBtn2;

    JButton settingGetBackBtn;

    JButton settingSaveBackBtn;







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
        //使用主界面模式则取消注释，将游戏界面模式注释掉，主界面模式看不到发牌效果
        //主界面模式
        initialize();
        mainframe.setVisible(true);
        addMainFrameEventListener();
        initializeGameFrame();
        gameframe.setVisible(false);
        addGameFrameEventListener();

        //只看游戏界面模式
//        initializeGameFrame();
//        gameframe.setVisible(true);
//        addGameFrameEventListener();
//        CardInit();
//        Time.second(1);
//        setHeapCardLastFront();






//        SwingUtilities.invokeLater(new GameTime(this));





    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // 初始化窗体
        mainframe = new JFrame("Bcvue game");
        mainframe.setSize( 720, 506);
        mainframe.setLocationRelativeTo(getOwner()); // 屏幕居中
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
    public void addMainFrameEventListener() {

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



    //游戏JFrame按钮点击事件注册
    public void addGameFrameEventListener(){
        sendCardButton.addActionListener(this);
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
            this.mainframe.setVisible(false);
////            initGame();
//            initializeGameFrame();
//            this.gameframe.setVisible(true);
//            CardInit();

//            initializeGameFrame();
//            gameframe.setVisible(false);
//            addGameFrameEventListener();
            gameframe.setVisible(true);
            CardInit();
            Time.second(1);
            setHeapCardLastFront();
        }
        if(e.getSource()==AIModeQuestionButton){
            JOptionPane.showMessageDialog(null, "这里给出本游戏AI模式的疑问解答\r\n如果您有什么不懂的，可以联系我们121212@gmail.com\r\n", "提示", JOptionPane.QUESTION_MESSAGE);
        }
        //发牌按钮点击事件
        if(e.getSource()==sendCardButton){
            for (Card playerCard : playerCards) {
                if(playerCard.clicked){
                    tCard = playerCard;
                    break;
                }
            }
            if(tCard!=null){
                playerCards.remove(tCard);
                Point point = new Point();
                point.setLocation(500, 430);
                Common.move(tCard,tCard.getLocation(), point);
                Common.rePosition(gameContentPanel,playerCards, 2);
                isAISending = true;


                fighterSendCard();

            }
        }
        if(e.getSource()==btnSettingButton){
            mainframe.setVisible(false);
            initSettingJFrame();
            addSettingActionListener();
            settingJframe.setVisible(true);
        }
        if(e.getSource()==settingGetBackBtn){

            settingJframe.dispose();
            mainframe.setVisible(true);
        }
        if(e.getSource()==settingSaveBackBtn){
            String re1,re2,re3;
            if(backradioBtn1.isSelected()){
                re1 = "1";
            } else if (backradioBtn2.isSelected()) {
                re1 = "2";
            } else{
                re1 = "3";
            }
            if(cardRadioBtn1.isSelected()){
                re2 = "1";
            } else if (cardRadioBtn2.isSelected()) {
                re2 = "2";
            } else{
                re2 = "3";
            }
            if(cardShowBtn1.isSelected()){
                re3 = "1";
            }else{
                re3 = "0";
            }
            FileUtil.writeProperties("D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\res\\default.cfg","BackGround",re1);
            FileUtil.writeProperties("D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\res\\default.cfg","BackCard",re2);
            FileUtil.writeProperties("D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\res\\default.cfg","showcard",re3);

            JOptionPane.showMessageDialog(null, "保存成功", "提示", JOptionPane.INFORMATION_MESSAGE);

        }
    }



//    private void initGame(){
//        initializeGameFrame();
//        gameframe.setVisible(true);
//        CardInit();
//    }

    public void initializeGameFrame(){

        this.gameframe = new JFrame("Bcvue game");
        gameframe.setSize(1000,800);
        gameframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        gameframe.setResizable(false);
        gameframe.setLocationRelativeTo(getOwner()); // 屏幕居中
        gameContentPanel = gameframe.getContentPane();


        //分值记录标签
        gameScoreLabel = new JLabel("Game points");
        gameScoreLabel.setBounds(780, 15, 200, 25);
        Font f11 = new Font("隶书",Font.PLAIN,30);
        gameScoreLabel.setFont(f11);
        Color fg11 = new Color(255,255,255);
        gameScoreLabel.setForeground(fg11);
        gameContentPanel.add(gameScoreLabel);

        fighterScoreLabel = new JLabel("fighter points: "+fighterScore);
        fighterScoreLabel.setBounds(780, 55, 200, 20);
        Font f13 = new Font("隶书",Font.PLAIN,20);
        fighterScoreLabel.setFont(f13);
        Color fg13 = new Color(255,255,255);
        fighterScoreLabel.setForeground(fg13);
        gameContentPanel.add(fighterScoreLabel);

        playerScoreLabel = new JLabel("your points: "+playerScore);
        playerScoreLabel.setBounds(780, 85, 200, 20);
        Font f12 = new Font("隶书",Font.PLAIN,20);
        playerScoreLabel.setFont(f12);
        Color fg12 = new Color(255,255,255);
        playerScoreLabel.setForeground(fg12);
        gameContentPanel.add(playerScoreLabel);

        //初始化牌组
        sentCards = new ArrayList<>();
        frontCards = new ArrayList<>();



        //出牌按钮
        sendCardButton = new JButton("出牌");
        sendCardButton.setBounds(500, 560, 100, 30);
        gameContentPanel.add(sendCardButton);




        gameContentPanel.setLayout(null);
        gameContentPanel.setBackground(new Color(46,139,87)); //设置背景颜色

    }


    //更新用户以及对手得分
    public void setScore(int flag, int score){
        if(flag==1){//为1时，是fighter
            fighterScoreLabel.setText("fighter points: "+score);
        }
        if(flag==2){
            playerScoreLabel.setText("your points: "+score);
        }
    }


    //根据六张翻面的牌判断能否出牌
    public boolean checkCards(List<Card> c,List<Card>[] current){
        //待完善



        return true;
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
        Common.rePosition(gameContentPanel,fighterCards, 1); //1是fighter
        Common.rePosition(gameContentPanel,playerCards, 2); //2是player
    }


    // 分别对六个牌堆的最后一张进行翻牌
    public void setHeapCardLastFront(){
        for (List<Card> cardList : heapCardsList) {
            frontCards.add(cardList.get(cardList.size()-1));
            cardList.get(cardList.size()-1).turnFront();
        }
    }


    //AI发送卡牌函数
    public void fighterSendCard(){
        int size = fighterCards.size();
        int i = new Random().nextInt(size); //随机获取AI现有卡牌中的一张
        Card card1 = fighterCards.get(i);
        fighterCards.remove(card1); //将卡牌从AI卡牌数组中移除
        sentCards.add(card1); //记录到已打出的卡牌数组中
        frontCards.add(card1); //记录到翻面卡牌数组中
        Point point = new Point(); //设置新的点
        point.setLocation(350, 200);
        card1.turnFront(); //卡牌翻面
        Common.move(card1, card1.getLocation(), point); //移动卡牌到指定位置
        Common.rePosition(gameContentPanel,fighterCards, 1);

    }


    //setting Gui
    public void initSettingJFrame(){

        settingJframe = new JFrame("Bcvue game");
        settingJframe.setSize(600,600);
        settingJframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        gameframe.setResizable(false);
        settingJframe.setLocationRelativeTo(getOwner()); // 屏幕居中
        settingContentPanel = settingJframe.getContentPane();


        settingGetBackBtn = new JButton("返回");
        settingGetBackBtn.setBounds(130,500,60,30);
        settingContentPanel.add(settingGetBackBtn);


        settingSaveBackBtn = new JButton("保存");
        settingSaveBackBtn.setBounds(370,500,60,30);
        settingContentPanel.add(settingSaveBackBtn);

        //初始化组件
        settingJLabel = new JLabel("Configuration");
        settingJLabel.setBounds(220,20,200,30);
        Font f1 = new Font("隶书",Font.PLAIN,18);
        settingJLabel.setFont(f1);
        settingContentPanel.add(settingJLabel);

        JLabel seprate0 = new JLabel("");
        seprate0.setBounds(0, 55, 10000, 1);
        seprate0.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        settingContentPanel.add(seprate0);

        settingDesktoplbl = new JLabel("Set desktop background:");
        settingDesktoplbl.setBounds(30,60,230,30);
        settingDesktoplbl.setFont(f1);
        settingContentPanel.add(settingDesktoplbl);

        backradioBtn1 = new JRadioButton("", true);
        backradioBtn1.setBounds(60,100,30,30);
        settingContentPanel.add(backradioBtn1);
        JLabel back1 = new JLabel(SwingUtil.createAutoAdjustIcon("D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\images\\back1.png", true));
        back1.setBounds(90,100,100,60);
        settingContentPanel.add(back1);

        backradioBtn2 = new JRadioButton("", false);
        backradioBtn2.setBounds(230,100,30,30);
        settingContentPanel.add(backradioBtn2);
        JLabel back2 = new JLabel(SwingUtil.createAutoAdjustIcon("D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\images\\back2.png", true));
        back2.setBounds(260,100,100,60);
        settingContentPanel.add(back2);

        backradioBtn3 = new JRadioButton("", false);
        backradioBtn3.setBounds(390,100,30,30);
        settingContentPanel.add(backradioBtn3);
        JLabel back3 = new JLabel(SwingUtil.createAutoAdjustIcon("D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\images\\back3.png", true));
        back3.setBounds(420,100,100,60);
        settingContentPanel.add(back3);
        ButtonGroup btnBackGroup = new ButtonGroup();
        btnBackGroup.add(backradioBtn1);
        btnBackGroup.add(backradioBtn2);
        btnBackGroup.add(backradioBtn3);

        //分割线
        JLabel seprate1 = new JLabel("");
        seprate1.setBounds(0, 180, 10000, 1);
        seprate1.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        settingContentPanel.add(seprate1);


        settingCardBack = new JLabel("Set card background:");
        settingCardBack.setBounds(30,200,230,30);
        settingCardBack.setFont(f1);
        settingContentPanel.add(settingCardBack);
//
        cardRadioBtn1 = new JRadioButton("", true);
        cardRadioBtn1.setBounds(60,250,30,30);
        settingContentPanel.add(cardRadioBtn1);
        JLabel cardBack1 = new JLabel(SwingUtil.createAutoAdjustIcon("D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\images\\cardBack1.png", true));
        cardBack1.setBounds(90,250,60,90);
        settingContentPanel.add(cardBack1);

        cardRadioBtn2 = new JRadioButton("", false);
        cardRadioBtn2.setBounds(230,250,30,30);
        settingContentPanel.add(cardRadioBtn2);
        JLabel cardBack2 = new JLabel(SwingUtil.createAutoAdjustIcon("D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\images\\cardBack2.png", true));
        cardBack2.setBounds(260,250,60,90);
        settingContentPanel.add(cardBack2);

        cardRadioBtn3 = new JRadioButton("", false);
        cardRadioBtn3.setBounds(390,250,30,30);
        settingContentPanel.add(cardRadioBtn3);
        JLabel cardBack3 = new JLabel(SwingUtil.createAutoAdjustIcon("D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\images\\cardBack3.png", true));
        cardBack3.setBounds(420,250,60,90);
        settingContentPanel.add(cardBack3);
        ButtonGroup btnCardGroup = new ButtonGroup();
        btnCardGroup.add(cardRadioBtn1);
        btnCardGroup.add(cardRadioBtn2);
        btnCardGroup.add(cardRadioBtn3);


        //分割线2
        JLabel seprate2 = new JLabel("");
        seprate2.setBounds(0, 390, 10000, 1);
        seprate2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        settingContentPanel.add(seprate2);



        settingShowCard = new JLabel("Show card:");
        settingShowCard.setBounds(30,400,230,30);
        settingShowCard.setFont(f1);
        settingContentPanel.add(settingShowCard);


        cardShowBtn1 = new JRadioButton("Yes", true);
        Font f2 = new Font("隶书",Font.PLAIN,20);
        cardShowBtn1.setFont(f2);
        cardShowBtn1.setBounds(120,440,120,30);
        settingContentPanel.add(cardShowBtn1);


        cardShowBtn2 = new JRadioButton("No", false);
        cardShowBtn2.setFont(f2);
        cardShowBtn2.setBounds(300,440,120,30);
        settingContentPanel.add(cardShowBtn2);
        ButtonGroup btnShowGroup = new ButtonGroup();
        btnShowGroup.add(cardShowBtn1);
        btnShowGroup.add(cardShowBtn2);


        settingContentPanel.setLayout(null);

    }

    //添加setting界面监听
    public void addSettingActionListener(){
        cardRadioBtn1.addActionListener(this);
        cardRadioBtn2.addActionListener(this);
        cardRadioBtn3.addActionListener(this);
        backradioBtn1.addActionListener(this);
        backradioBtn2.addActionListener(this);
        backradioBtn3.addActionListener(this);
        cardShowBtn1.addActionListener(this);
        cardShowBtn2.addActionListener(this);
        settingGetBackBtn.addActionListener(this);
        settingSaveBackBtn.addActionListener(this);

    }

}

