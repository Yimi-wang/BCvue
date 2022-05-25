package Vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Main extends JFrame implements ActionListener{

    JFrame mainframe;

    Container mainContentPanel;

    JPanel gameModePanel;
    JButton btnStartButton;
    JButton btnLoadButton;
    JButton btnSettingButton;
    JButton btnOnlineButton;

    JButton landlord[]=new JButton[2];//抢地主按钮

    JButton btnQuestionButton; // ❓按钮

    JButton leftButton;//左箭头按钮

    JButton rightButton;//右箭头按钮

    JScrollPane inputJSP;//文本输入框，位于下来框下

    JLabel lblGameMode;//gamemode标签


    JComboBox comboBox;//单选框



    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main window = new Main();
                    window.mainframe.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Main() {
        initialize();
        addEventListener();
        gameModeDisappear();

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

        comboBox = new JComboBox();
        // 绑定下拉框选项
        String[] strArray = { "BO1","BO3","Number of Fixe","Score Fixe"};
        for (String item : strArray)
        {
            comboBox.addItem(item);
        }
        comboBox.setFont(new Font("宋体", Font.PLAIN, 14));
        comboBox.setBounds(150, 140, 180, 30);
        mainContentPanel.add(comboBox);

        //添加问号按钮
        btnQuestionButton = new JButton("❓");
        btnQuestionButton.setBounds(340, 140, 50, 30);
        mainContentPanel.add(btnQuestionButton);



        // 添加文本框
        JTextArea jta=new JTextArea("",7,30);
        jta.setLineWrap(true);    //设置文本域中的文本为自动换行
        jta.setForeground(Color.BLACK);    //设置组件的背景色
        jta.setFont(new Font("楷体",Font.BOLD,16));    //修改字体样式
        jta.setBackground(Color.white);    //设置按钮背景色
        inputJSP=new JScrollPane(jta);    //将文本域放入滚动窗口
        Dimension size=jta.getPreferredSize();    //获得文本域的首选大小
        inputJSP.setBounds(150,190,240,size.height);
        mainContentPanel.add(inputJSP);



        //添加左右按钮
        leftButton = new JButton("←");
        leftButton.setBounds(150, 340, 50, 30);
        mainContentPanel.add(leftButton);
        rightButton = new JButton("→");
        rightButton.setBounds(340, 340, 50, 30);
        mainContentPanel.add(rightButton);




        // 设置背景, 背景要在最后面设置
        JLabel lblBackground = new JLabel(); // 创建一个标签组件对象
        URL resource = this.getClass().getResource("../images/MainMenu.png"); // 获取背景图片路径
        ImageIcon icon = new ImageIcon(resource); // 创建背景图片对象
        lblBackground.setIcon(icon); // 设置标签组件要显示的图标
        lblBackground.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 设置组件的显示位置及大小
        mainContentPanel.add(lblBackground); // 将组件添加到面板中

    }

    //gameMode消失
    public void gameModeDisappear(){
        lblGameMode.setVisible(false);
        comboBox.setVisible(false);
        btnQuestionButton.setVisible(false);
        inputJSP.setVisible(false);
        leftButton.setVisible(false);
        rightButton.setVisible(false);
    }

    //gameMode出现
    public void gameModeAppear(){
        lblGameMode.setVisible(true);
        comboBox.setVisible(true);
        btnQuestionButton.setVisible(true);
        inputJSP.setVisible(true);
        leftButton.setVisible(true);
        rightButton.setVisible(true);
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

    public void addEventListener() {

        //主界面按钮
        btnStartButton.addActionListener(this);
        btnLoadButton.addActionListener(this);
        btnOnlineButton.addActionListener(this);
        btnSettingButton.addActionListener(this);

        //gameMode按钮
        btnQuestionButton.addActionListener(this);
        leftButton.addActionListener(this);
        rightButton.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnStartButton){
            mainFrameButtonDisappear();
            gameModeAppear();
        }
        if(e.getSource()==leftButton){
            mainFrameButtonAppear();
            gameModeDisappear();
        }
        if(e.getSource()==btnQuestionButton){
            JOptionPane.showMessageDialog(null, "这里给出本游戏模式的疑问解答\r\n如果您有什么不懂的，可以联系我们121212@gmail.com\r\n", "提示", JOptionPane.QUESTION_MESSAGE);
        }
    }


}


