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
    JButton GameModeQuestionButton; // ?��ť
    JButton GameModeLeftButton;//���ͷ��ť
    JButton GameModeRightButton;//�Ҽ�ͷ��ť
    JScrollPane GameModeInputJSP;//�ı������λ����������
    JLabel lblGameMode;//gamemode��ǩ
    JComboBox GameModeComboBox;//��ѡ��


    //AIMode
    JButton AIModeQuestionButton; // ?��ť
    JButton AIModeLeftButton;//���ͷ��ť
    JButton AIModeRightButton;//�Ҽ�ͷ��ť
    JLabel lblAIMode;//gamemode��ǩ
    JComboBox AIModeComboBox;//��ѡ��


    //��
    // ������ϵ���
    List<Card> playerCards;

    //�������ϵ���
    List<Card> fighterCards;

    //�����ѳ�����
    List<Card> sentCards;

    // �ѷ��浫��δ������
    List<Card> frontCards;

    //���������ƶ�
    List<Card> heapCardsList[] = new ArrayList[6];

    Card card[]=new Card[54];

    JTextField time[] = new JTextField[3]; //��ʱ��

    boolean isAISending = false;


    //��֧��¼��������ǩ
    JLabel gameScoreLabel;

    int playerScore=0;

    JLabel playerScoreLabel;

    int fighterScore=0;

    JLabel fighterScoreLabel;

    //���ư�ť
    JButton sendCardButton;

    //�滻Card
    Card tCard;



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
        //ʹ��������ģʽ��ȡ��ע�ͣ�����Ϸ����ģʽע�͵���������ģʽ����������Ч��
        //������ģʽ
//        initialize();
//        mainframe.setVisible(true);
//        addMainFrameEventListener();
//        initializeGameFrame();
//        gameframe.setVisible(false);
//        addGameFrameEventListener();

        //ֻ����Ϸ����ģʽ
        initializeGameFrame();
        gameframe.setVisible(true);
        addGameFrameEventListener();
        CardInit();
        Time.second(1);
        setHeapCardLastFront();






//        SwingUtilities.invokeLater(new GameTime(this));





    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // ��ʼ������
        mainframe = new JFrame("Bcvue game");
        mainframe.setBounds(300, 300, 720, 506);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainContentPanel = mainframe.getContentPane();

//        gameModePanel = new JPanel();
//        gameModePanel.setBounds(120, 120, 200, 200);
//        gameModePanel.setLayout(null);

        // ��Ϸ�ı�����
        JLabel jLabel = new JLabel("Bridge Chinois");
        jLabel.setBounds(30, 25, 300, 30);
        Font f = new Font("����",Font.PLAIN,30);
        jLabel.setFont(f);
        Color fg = new Color(255,255,255);
        jLabel.setForeground(fg);
        mainContentPanel.add(jLabel);

        // start��ť
        //���ر���ͼƬ
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
        //���ر���ͼƬ
        String onlinePath="D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\images\\online.png";
        ImageIcon onlineIcon1=new ImageIcon(onlinePath);
        Image onlineImg = onlineIcon1.getImage();
        Image onlineNewImg = onlineImg.getScaledInstance(120,40,java.awt.Image.SCALE_SMOOTH);
        ImageIcon onlineIcon2 = new ImageIcon(onlineNewImg);

        btnOnlineButton = new RoundRectButton(onlineIcon2);
        btnOnlineButton.setBounds(30, 150, 120, 40);
        mainContentPanel.add(btnOnlineButton);


        // load
        //���ر���ͼƬ
        String loadPath="D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\images\\load.png";
        ImageIcon loadIcon1=new ImageIcon(loadPath);
        Image loadImg = loadIcon1.getImage();
        Image loadNewImg = loadImg.getScaledInstance(120,40,java.awt.Image.SCALE_SMOOTH);
        ImageIcon loadIcon2 = new ImageIcon(loadNewImg);

        btnLoadButton = new RoundRectButton(loadIcon2);
        btnLoadButton.setBounds(30, 210, 120, 40);
        mainContentPanel.add(btnLoadButton);


        // load
        //���ر���ͼƬ
        String settingPath="D:\\OutSourcing\\CardGame\\BCvue\\bridgechinoise-New Version\\bridgechinoise\\src\\images\\setting.png";
        ImageIcon settingIcon1=new ImageIcon(settingPath);
        Image settingImg = settingIcon1.getImage();
        Image settingNewImg = settingImg.getScaledInstance(120,40,java.awt.Image.SCALE_SMOOTH);
        ImageIcon settingIcon2 = new ImageIcon(settingNewImg);

        btnSettingButton = new RoundRectButton(settingIcon2);
        btnSettingButton.setBounds(30, 270, 120, 40);
        mainContentPanel.add(btnSettingButton);

//        //���gameMode
//        JLabel gameModeText = new JLabel("GameMode");
//        gameModePanel.add(gameModeText);
//        mainContentPanel.add(gameModePanel);

        lblGameMode = new JLabel("GameMode");
        lblGameMode.setBounds(200, 80, 300, 30);
        Font f1 = new Font("����",Font.PLAIN,30);
        lblGameMode.setFont(f1);
        Color fg1 = new Color(255,255,255);
        lblGameMode.setForeground(fg1);
        mainContentPanel.add(lblGameMode);

        GameModeComboBox = new JComboBox();
        // ��������ѡ��
        String[] strArray = { "BO1","BO3","Number of Fixe","Score Fixe"};
        for (String item : strArray)
        {
            GameModeComboBox.addItem(item);
        }
        GameModeComboBox.setFont(new Font("����", Font.PLAIN, 14));
        GameModeComboBox.setBounds(150, 140, 180, 30);
        mainContentPanel.add(GameModeComboBox);

        //����ʺŰ�ť
        GameModeQuestionButton = new JButton("?");
        GameModeQuestionButton.setBounds(340, 140, 50, 30);
        mainContentPanel.add(GameModeQuestionButton);



        // ����ı���
        JTextArea jta=new JTextArea("",7,30);
        jta.setLineWrap(true);    //�����ı����е��ı�Ϊ�Զ�����
        jta.setForeground(Color.BLACK);    //��������ı���ɫ
        jta.setFont(new Font("����",Font.BOLD,16));    //�޸�������ʽ
        jta.setBackground(Color.white);    //���ð�ť����ɫ
        GameModeInputJSP =new JScrollPane(jta);    //���ı�������������
        Dimension size=jta.getPreferredSize();    //����ı������ѡ��С
        GameModeInputJSP.setBounds(150,190,240,size.height);
        mainContentPanel.add(GameModeInputJSP);


        //������Ұ�ť
        GameModeLeftButton = new JButton("��");
        GameModeLeftButton.setBounds(150, 340, 50, 30);
        mainContentPanel.add(GameModeLeftButton);
        GameModeRightButton = new JButton("��");
        GameModeRightButton.setBounds(340, 340, 50, 30);
        mainContentPanel.add(GameModeRightButton);


        // ���AIMode**********************
        lblAIMode = new JLabel("AIMode");
        lblAIMode.setBounds(200, 80, 300, 30);
        Font f2 = new Font("����",Font.PLAIN,30);
        lblAIMode.setFont(f2);
        Color fg2 = new Color(255,255,255);
        lblAIMode.setForeground(fg2);
        mainContentPanel.add(lblAIMode);

        AIModeComboBox = new JComboBox();
        // ��������ѡ��
        String[] AIStrArray = { "AIrandom","AIsimple","AIminmax","AIrandom"};
        for (String item : AIStrArray)
        {
            AIModeComboBox.addItem(item);
        }
        AIModeComboBox.setFont(new Font("����", Font.PLAIN, 14));
        AIModeComboBox.setBounds(150, 140, 180, 30);
        mainContentPanel.add(AIModeComboBox);

        //����ʺŰ�ť
        AIModeQuestionButton = new JButton("?");
        AIModeQuestionButton.setBounds(340, 140, 50, 30);
        mainContentPanel.add(AIModeQuestionButton);



        //������Ұ�ť
        AIModeLeftButton = new JButton("��");
        AIModeLeftButton.setBounds(180, 240, 50, 30);
        mainContentPanel.add(AIModeLeftButton);
        AIModeRightButton = new JButton("��");
        AIModeRightButton.setBounds(300, 240, 50, 30);
        mainContentPanel.add(AIModeRightButton);


        // ���ñ���, ����Ҫ�����������
        JLabel lblBackground = new JLabel(); // ����һ����ǩ�������
        URL resource = this.getClass().getResource("../images/MainMenu.png"); // ��ȡ����ͼƬ·��
        ImageIcon icon = new ImageIcon(resource); // ��������ͼƬ����
        lblBackground.setIcon(icon); // ���ñ�ǩ���Ҫ��ʾ��ͼ��
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // �����������ʾλ�ü���С
        mainContentPanel.add(lblBackground); // �������ӵ������


        gameModeDisappear();
        AIModeDisappear();

    }



    //gameMode��ʧ
    public void gameModeDisappear(){
        lblGameMode.setVisible(false);
        GameModeComboBox.setVisible(false);
        GameModeQuestionButton.setVisible(false);
        GameModeInputJSP.setVisible(false);
        GameModeLeftButton.setVisible(false);
        GameModeRightButton.setVisible(false);
    }


    //���ÿ��ƿɱ����
    public void CardCanClick(boolean b){
        for(int i=1;i<53;i++){
            card[i].canClick=b;
        }
    }

    //gameMode����
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
     * �����水ť��ʧ
     */
    public void mainFrameButtonDisappear(){
        btnStartButton.setVisible(false);
        btnLoadButton.setVisible(false);
        btnSettingButton.setVisible(false);
        btnOnlineButton.setVisible(false);
    }


    /**
     * �����水ť����
     */
    public void mainFrameButtonAppear(){
        btnStartButton.setVisible(true);
        btnLoadButton.setVisible(true);
        btnSettingButton.setVisible(true);
        btnOnlineButton.setVisible(true);

    }

    //��JFrame��ť����¼�ע��
    public void addMainFrameEventListener() {

        //�����水ť
        btnStartButton.addActionListener(this);
        btnLoadButton.addActionListener(this);
        btnOnlineButton.addActionListener(this);
        btnSettingButton.addActionListener(this);

        //gameMode��ť
        GameModeQuestionButton.addActionListener(this);
        GameModeLeftButton.addActionListener(this);
        GameModeRightButton.addActionListener(this);

        //AIMode��ť
        AIModeLeftButton.addActionListener(this);
        AIModeRightButton.addActionListener(this);
        AIModeQuestionButton.addActionListener(this);
    }



    //��ϷJFrame��ť����¼�ע��
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
            JOptionPane.showMessageDialog(null, "�����������Ϸģʽ�����ʽ��\r\n�������ʲô�����ģ�������ϵ����121212@gmail.com\r\n", "��ʾ", JOptionPane.QUESTION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "�����������ϷAIģʽ�����ʽ��\r\n�������ʲô�����ģ�������ϵ����121212@gmail.com\r\n", "��ʾ", JOptionPane.QUESTION_MESSAGE);
        }
        //���ư�ť����¼�
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
    }



//    private void initGame(){
//        initializeGameFrame();
//        gameframe.setVisible(true);
//        CardInit();
//    }

    public void initializeGameFrame(){

        this.gameframe = new JFrame("Bcvue game");
        gameframe.setSize(1000,800);
        gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        gameframe.setResizable(false);
        gameframe.setLocationRelativeTo(getOwner()); // ��Ļ����
        gameContentPanel = gameframe.getContentPane();


        //��ֵ��¼��ǩ
        gameScoreLabel = new JLabel("Game points");
        gameScoreLabel.setBounds(780, 15, 200, 25);
        Font f11 = new Font("����",Font.PLAIN,30);
        gameScoreLabel.setFont(f11);
        Color fg11 = new Color(255,255,255);
        gameScoreLabel.setForeground(fg11);
        gameContentPanel.add(gameScoreLabel);

        fighterScoreLabel = new JLabel("fighter points: "+fighterScore);
        fighterScoreLabel.setBounds(780, 55, 200, 20);
        Font f13 = new Font("����",Font.PLAIN,20);
        fighterScoreLabel.setFont(f13);
        Color fg13 = new Color(255,255,255);
        fighterScoreLabel.setForeground(fg13);
        gameContentPanel.add(fighterScoreLabel);

        playerScoreLabel = new JLabel("your points: "+playerScore);
        playerScoreLabel.setBounds(780, 85, 200, 20);
        Font f12 = new Font("����",Font.PLAIN,20);
        playerScoreLabel.setFont(f12);
        Color fg12 = new Color(255,255,255);
        playerScoreLabel.setForeground(fg12);
        gameContentPanel.add(playerScoreLabel);

        //��ʼ������
        sentCards = new ArrayList<>();
        frontCards = new ArrayList<>();



        //���ư�ť
        sendCardButton = new JButton("����");
        sendCardButton.setBounds(500, 560, 100, 30);
        gameContentPanel.add(sendCardButton);




        gameContentPanel.setLayout(null);
        gameContentPanel.setBackground(new Color(46,139,87)); //���ñ�����ɫ

    }


    //�����û��Լ����ֵ÷�
    public void setScore(int flag, int score){
        if(flag==1){//Ϊ1ʱ����fighter
            fighterScoreLabel.setText("fighter points: "+score);
        }
        if(flag==2){
            playerScoreLabel.setText("your points: "+score);
        }
    }


    //�������ŷ�������ж��ܷ����
    public boolean checkCards(List<Card> c,List<Card>[] current){
        //������



        return true;
    }











    //��ʼ���Ƽ��Ƶķ��ƶ�̬Ч����ʾ
    private void CardInit(){
        int count =1 ;
//
//        Card card1 = new Card( "1-1", false);
//        card1.setBounds(100,100,70,100);
//        gameContentPanel.add(card1);

        //��ʼ����
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

        //����˳��
        for(int i=0;i<100;i++){
            Random random=new Random();
            int a=random.nextInt(52)+1;
            int b=random.nextInt(52)+1;
            Card k=card[a];
            card[a]=card[b];
            card[b]=k;
        }

        //��ʼ����
        //��ʼ���ҵ����б���������б�
        fighterCards = new ArrayList<>();
        playerCards = new ArrayList<>();
        //�ȷ������˵���
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
            //�������µ����ڶ���
            gameContentPanel.setComponentZOrder(card[i], 0);
        }


        //���¶��ƽ�������
        Common.order(fighterCards);
        Common.order(playerCards);
        Common.rePosition(gameContentPanel,fighterCards, 1); //1��fighter
        Common.rePosition(gameContentPanel,playerCards, 2); //2��player
    }


    // �ֱ�������ƶѵ����һ�Ž��з���
    public void setHeapCardLastFront(){
        for (List<Card> cardList : heapCardsList) {
            frontCards.add(cardList.get(cardList.size()-1));
            cardList.get(cardList.size()-1).turnFront();
        }
    }


    //AI���Ϳ��ƺ���
    public void fighterSendCard(){
        int size = fighterCards.size();
        int i = new Random().nextInt(size); //�����ȡAI���п����е�һ��
        Card card1 = fighterCards.get(i);
        fighterCards.remove(card1); //�����ƴ�AI�����������Ƴ�
        sentCards.add(card1); //��¼���Ѵ���Ŀ���������
        frontCards.add(card1); //��¼�����濨��������
        Point point = new Point(); //�����µĵ�
        point.setLocation(350, 200);
        card1.turnFront(); //���Ʒ���
        Common.move(card1, card1.getLocation(), point); //�ƶ����Ƶ�ָ��λ��
        Common.rePosition(gameContentPanel,fighterCards, 1);

    }
}
//class GameTime extends Thread{
//    Main main;
//
//    public GameTime(Main main){
//        this.main = main;
//    }
//
//    @Override
//    public void run() {
////        while(main.playerCards.size()<=0 || main.fighterCards.size()<=0){
////
////        }
//
////        while(true){
////            Time.second(10);
////            if(main.isAISending){
////                main.fighterSendCard();
////
////                break;
////            }
////        }
//        GameTime2 gameTime2 = new GameTime2(main);
//        gameTime2.run();
//    }
//}
//
//
//class GameTime2 extends Thread{
//    Main main;
//
//    public GameTime2(Main main){
//        this.main = main;
//    }
//
//    @Override
//    public void run() {
//        while(true){
//            Time.second(10);
//            if(main.isAISending){
//                main.fighterSendCard();
//
//                break;
//            }
//        }
//
//    }
//}


