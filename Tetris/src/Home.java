import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Home {
    public static void main(String[] args) {
        //导入按钮图片素材
        ImageIcon StartButton=new ImageIcon("Tetris/src/buttons/StartButton.png");
        ImageIcon StartButtonPressed=new ImageIcon("Tetris/src/buttons/StartButtonPressed.png");
        ImageIcon ExitButton=new ImageIcon("Tetris/src/buttons/ExitButton.png");
        ImageIcon ExitButtonPressed=new ImageIcon("Tetris/src/buttons/ExitButtonPressed.png");
        ImageIcon RankingListButton=new ImageIcon("Tetris/src/buttons/RankingListButton.png");
        ImageIcon RankingListButtonPressed=new ImageIcon("Tetris/src/buttons/RankingListButtonPressed.png");
        ImageIcon OptionButton=new ImageIcon("Tetris/src/buttons/OptionButton.png");
        ImageIcon OptionButtonPressed=new ImageIcon("Tetris/src/buttons/OptionButtonPressed.png");
        ImageIcon NewGameButton=new ImageIcon("Tetris/src/buttons/NewGameButton.png");
        ImageIcon NewGameButtonPressed=new ImageIcon("Tetris/src/buttons/NewGameButtonPressed.png");
        ImageIcon GameSaverButton=new ImageIcon("Tetris/src/buttons/GameSaverButton.png");
        ImageIcon GameSaverButtonPressed=new ImageIcon("Tetris/src/buttons/GameSaverButtonPressed.png");
        ImageIcon BackButton=new ImageIcon("Tetris/src/buttons/BackButton.png");
        ImageIcon BackButtonPressed=new ImageIcon("Tetris/src/buttons/BackButtonPressed.png");
        ImageIcon ApplyButton=new ImageIcon("Tetris/src/buttons/ApplyButton.png");
        ImageIcon ApplyButtonPressed=new ImageIcon("Tetris/src/buttons/ApplyButtonPressed.png");
        ImageIcon BackButtonBig=new ImageIcon("Tetris/src/buttons/BackButtonBig.png");
        ImageIcon BackButtonBigPressed=new ImageIcon("Tetris/src/buttons/BackButtonBigPressed.png");
        ImageIcon NoButton=new ImageIcon("Tetris/src/buttons/NoButton.png");
        ImageIcon YesButton=new ImageIcon("Tetris/src/buttons/YesButton.png");
        ImageIcon HomeButton=new ImageIcon("Tetris/src/buttons/HomeButton.png");
        ImageIcon PauseButton=new ImageIcon("Tetris/src/buttons/PauseButton.png");
        ImageIcon PauseButtonPressed=new ImageIcon("Tetris/src/buttons/PauseButtonPressed.png");
        ImageIcon ContinueButton=new ImageIcon("Tetris/src/buttons/ContinueButton.png");
        ImageIcon HowToPlayButton=new ImageIcon("Tetris/src/buttons/HowToPlayButton.png");
        ImageIcon DifficultyButton=new ImageIcon("Tetris/src/buttons/DifficultyButton.png");
        ImageIcon BG=new ImageIcon("Tetris/src/bg/bg.png");
        ImageIcon BG1=new ImageIcon("Tetris/src/bg/bg1.png");
        ImageIcon ButtonBG=new ImageIcon("Tetris/src/buttons/ButtonBG.png");
        //bgm
        Music bgm=new Music("Tetris/src/bgm/bgm.wav");


        //创建游戏主页面
        JFrame homePage=new JFrame("HomePage");
        homePage.setSize(400,650);
        homePage.setLocationRelativeTo(null);
        homePage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //homePage 设置
        JPanel homePanel=new JPanel(null);
        homePage.setContentPane(homePanel);

        //为开始界面添加背景
        JLabel homePageBG=new JLabel();
        setBackGround.SetBackGround(homePageBG,homePage,BG,homePanel);

        //play按钮
        JButton play=new JButton();
        homePanel.add(play);
        SetButton.SetButton(play,StartButton,StartButtonPressed);
        play.setBounds(100,200,StartButton.getIconWidth(),StartButton.getIconHeight());

        //Exit按钮
        JButton Exit=new JButton();
        homePanel.add(Exit);
        SetButton.SetButton(Exit,ExitButton,ExitButtonPressed);
        Exit.setBounds(100,500,StartButton.getIconWidth(),StartButton.getIconHeight());

        //退出游戏
        Exit.addActionListener(e -> System.exit(0));

        //下拉列表框选择难度
        JLabel Difficulty=new JLabel("Difficulty");
        homePanel.add(Difficulty);
        String[] difficulties=new String[]{"Level 1","Level 2","Level 3","Level 4"};
        Difficulty.setIcon(DifficultyButton);
        Difficulty.setBounds(50,273,DifficultyButton.getIconWidth(),DifficultyButton.getIconHeight());
        final JComboBox<String> chooseDifficulty= new JComboBox<>(difficulties);

        homePage.add(chooseDifficulty);
        chooseDifficulty.setBounds(210,290,100,30);
        Color BGColor=new Color(254,229,163);
        chooseDifficulty.setBackground(BGColor);
        chooseDifficulty.setFont(new Font("方正舒体",Font.BOLD,20));
        chooseDifficulty.setForeground(new Color(52,46,31));

        //点击Ranking List按钮跳转到排行榜界面
        JButton RankingList=new JButton();
        homePage.add(RankingList);
        SetButton.SetButton(RankingList,RankingListButton,RankingListButtonPressed);
        RankingList.setBounds(100,340,StartButton.getIconWidth(),StartButton.getIconHeight());

        //开始游戏过渡界面
        JFrame ChooseGamePage=new JFrame("ChooseGame");
        ChooseGamePage.setSize(400,650);
        ChooseGamePage.setLocationRelativeTo(null);
        ChooseGamePage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //ChooseGame Page 设置
        JPanel chooseGame=new JPanel(null);
        ChooseGamePage.setContentPane(chooseGame);
        JLabel ChooseGameBG=new JLabel();
        setBackGround.SetBackGround(ChooseGameBG,ChooseGamePage,BG1,chooseGame);


        //New Game按钮
        JButton NewGame=new JButton();
        chooseGame.add(NewGame);
        SetButton.SetButton(NewGame,NewGameButton,NewGameButtonPressed);
        NewGame.setBounds(100,200,NewGameButton.getIconWidth(),NewGameButton.getIconHeight());


        //GameSaver按钮
        JButton GameSaves=new JButton();
        chooseGame.add(GameSaves);
        SetButton.SetButton(GameSaves,GameSaverButton,GameSaverButtonPressed);
        GameSaves.setBounds(100,275,GameSaverButton.getIconWidth(),GameSaverButton.getIconHeight());

        //从选择游戏返回主页面的Back按钮
        JButton BackToHomePageFromChooseGame=new JButton();
        chooseGame.add(BackToHomePageFromChooseGame);
        SetButton.SetButton(BackToHomePageFromChooseGame,BackButtonBig,BackButtonBigPressed);
        BackToHomePageFromChooseGame.setBounds(100,350, BackButtonBig.getIconWidth(),BackButtonBigPressed.getIconHeight());
        changePage.ChangePage(BackToHomePageFromChooseGame,ChooseGamePage,homePage);

        //点击play按钮跳转到选择游戏界面
        changePage.ChangePage(play,homePage,ChooseGamePage);

        //点击GameSavers跳转到存档界面
        JFrame GameSaversPage=new JFrame("Saves");
        GameSaversPage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GameSaversPage.setSize(400,650);
        JPanel GameSaverPanel=new JPanel(null);
        GameSaversPage.setContentPane(GameSaverPanel);
        GameSaversPage.setLocationRelativeTo(null);
        JLabel GameSaversBG=new JLabel();
        setBackGround.SetBackGround(GameSaversBG,GameSaversPage,BG1,GameSaverPanel);

        //存档Label
        JLabel Savers=new JLabel("历史存档");
        Savers.setFont(new Font("方正舒体",Font.BOLD,30));
        Savers.setForeground(Color.DARK_GRAY);
        GameSaverPanel.add(Savers);
        Savers.setBounds(125,70,150,50);

        //从存档界面返回选择游戏界面的Back按钮
        JButton BackToChooseGamePageFromGameSaversPage=new JButton();
        GameSaverPanel.add(BackToChooseGamePageFromGameSaversPage);
        SetButton.SetButton(BackToChooseGamePageFromGameSaversPage,BackButtonBig,BackButtonBigPressed);
        BackToChooseGamePageFromGameSaversPage.setBounds(100,500,BackButtonBig.getIconWidth(),BackButtonBig.getIconHeight());

        //changePage操作
        changePage.ChangePage(GameSaves,ChooseGamePage,GameSaversPage);
        changePage.ChangePage(BackToChooseGamePageFromGameSaversPage,GameSaversPage,ChooseGamePage);

        //点击New Game按钮开始新游戏
        JFrame GamePage=new JFrame("Game Running");
        gamePage GamePanel=new gamePage();
        GamePage.setSize(400,650);
        GamePage.setLocationRelativeTo(null);
        GamePage.setContentPane(GamePanel);
        GamePanel.setLayout(null);
        GamePage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        changePage.ChangePage(NewGame,ChooseGamePage,GamePage);
        JLabel GamePageBG=new JLabel();
        setBackGround.SetBackGround(GamePageBG,GamePage,BG1,GamePanel);


        chooseDifficulty.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==ItemEvent.SELECTED){
                    switch (chooseDifficulty.getSelectedIndex()){
                        case 0:GamePanel.setDifficulty(1000);break;
                        case 1:GamePanel.setDifficulty(500);break;
                        case 2:GamePanel.setDifficulty(250);break;
                        case 3:GamePanel.setDifficulty(125);break;
                        default:break;
                    }

                    System.out.println("游戏难度设置为"+chooseDifficulty.getSelectedItem());
                }
            }
        });

        //
        NewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //bgm.start(true);
                GamePanel.startgame();
                GamePage.addKeyListener(GamePanel);


            }
        });

        //bgm.setVolume(7);

        //Pause暂停界面设置
        JFrame PausePage=new JFrame("Pause");
        PausePage.setSize(300,300);
        PausePage.setLocationRelativeTo(null);
        JPanel PausePanel=new JPanel(null);
        PausePage.setContentPane(PausePanel);
        JLabel PausePageBG=new JLabel();
        setBackGround.SetBackGround(PausePageBG,PausePage,BG1,PausePanel);

        //Pause按钮
        JButton Pause=new JButton();
        GamePage.add(Pause);
        Pause.setFocusable(false);
        SetButton.SetButton(Pause,PauseButton,PauseButtonPressed);
        Pause.setBounds(218,480,PauseButton.getIconWidth(),PauseButton.getIconHeight());
        GamePage.requestFocus();

        //显示下一个方块的label



        //显示score的label



        //暂停游戏
        Pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bgm.stop();
                GamePanel.pause();
                PausePage.setVisible(true);

            }
        });

        //从暂停返回主页面的按钮
        JButton BackToHomePageFromPausePage=new JButton();
        PausePanel.add(BackToHomePageFromPausePage);
        SetButton.SetButton(BackToHomePageFromPausePage,HomeButton,HomeButton);

        BackToHomePageFromPausePage.setBounds(30,150,HomeButton.getIconWidth(),HomeButton.getIconHeight());


        //继续游戏按钮
        JButton ContinuePlay=new JButton();
        ContinuePlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PausePage.setVisible(false);
                GamePanel.ContinueGame();
            }
        });
        PausePanel.add(ContinuePlay);
        SetButton.SetButton(ContinuePlay,ContinueButton,ContinueButton);
        ContinuePlay.setBounds(220,175,ContinueButton.getIconWidth(),ContinueButton.getIconHeight());

        ContinuePlay.addActionListener(e -> bgm.continues());




        //返回主页面是询问是否存档
        JFrame SaveOrNot=new JFrame();
        JPanel SaveOrNotPanel=new JPanel(null);
        SaveOrNot.setContentPane(SaveOrNotPanel);
        SaveOrNot.setSize(300,300);
        SaveOrNot.setLocationRelativeTo(null);
        JLabel SaveOrNotBG=new JLabel();
        setBackGround.SetBackGround(SaveOrNotBG,SaveOrNot,BG1,SaveOrNotPanel);

        //询问是否存档的Label
        JLabel SaveOrNotLabel=new JLabel("Do you want to save your game?");
        SaveOrNotPanel.add(SaveOrNotLabel);
        SaveOrNotLabel.setBounds(20,10,200,50);

        //Yes按钮
        JButton DoSave=new JButton();
        DoSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GamePage .removeKeyListener(GamePanel);
            }
        });
        SaveOrNotPanel.add(DoSave);
        SetButton.SetButton(DoSave,YesButton,YesButton);
        DoSave.setBounds(25,50,YesButton.getIconWidth(),YesButton.getIconHeight());

        //No按钮
        JButton NotSave=new JButton();
        NotSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GamePage.removeKeyListener(GamePanel);
            }
        });
        SaveOrNotPanel.add(NotSave);
        SetButton.SetButton(NotSave,NoButton,NoButton);
        NotSave.setBounds(165,50,NoButton.getIconWidth(),NoButton.getIconHeight());

        //从是否存档界面返回暂停界面Back按钮
        JButton BackToPausePageFromSaveOrNot=new JButton();
        SaveOrNotPanel.add(BackToPausePageFromSaveOrNot);
        SetButton.SetButton(BackToPausePageFromSaveOrNot,BackButton,BackButtonPressed);
        BackToPausePageFromSaveOrNot.setBounds(120,145,BackButton.getIconWidth(),BackButton.getIconHeight());
        changePage.ChangePage(BackToPausePageFromSaveOrNot,SaveOrNot,PausePage);

        //
        BackToHomePageFromPausePage.addActionListener(e -> {
            PausePage.setVisible(false);
            SaveOrNot.setVisible(true);
        });

        //保存并回到开始界面
        DoSave.addActionListener(e -> {
            SaveOrNot.setVisible(false);
            GamePage.setVisible(false);
            homePage.setVisible(true);
            //保存数据操作



        });

        NotSave.addActionListener(e -> {
            SaveOrNot.setVisible(false);
            GamePage.setVisible(false);
            homePage.setVisible(true);



        });

        //HowToPlay界面
        JFrame HowToPlayPage=new JFrame("How To Play");
        HowToPlayPage.setSize(200,325);
        JPanel HowToPlayPanel=new JPanel(null);
        HowToPlayPage.setContentPane(HowToPlayPanel);
        HowToPlayPage.setLocationRelativeTo(null);
        JLabel HowToPlayBG=new JLabel();
        setBackGround.SetBackGround(HowToPlayBG,HowToPlayPage,BG1,HowToPlayPanel);

        //从暂停界面到帮助界面
        JButton HowToPlay=new JButton();
        PausePanel.add(HowToPlay);
        SetButton.SetButton(HowToPlay,HowToPlayButton,HowToPlayButton);
        HowToPlay.setBounds(130,164,HowToPlayButton.getIconWidth(),HowToPlayButton.getIconHeight());
        changePage.ChangePage(HowToPlay,PausePage,HowToPlayPage);

        //帮助label
        JLabel HowToPlayLabel=new JLabel("爱咋玩咋玩");
        HowToPlayPanel.add(HowToPlayLabel);
        HowToPlayLabel.setBounds(40,10,100,100);

        //从帮助界面返回暂停界面
        JButton BackToPausePageFromHowToPLayPage=new JButton();
        HowToPlayPanel.add(BackToPausePageFromHowToPLayPage);
        SetButton.SetButton(BackToPausePageFromHowToPLayPage,BackButton,BackButtonPressed);
        BackToPausePageFromHowToPLayPage.setBounds(7,200,BackButton.getIconWidth(),BackButton.getIconHeight());
        changePage.ChangePage(BackToPausePageFromHowToPLayPage,HowToPlayPage,PausePage);


        //排行榜界面
        JFrame rankingLIstPage=new JFrame("Ranking List");
        rankingLIstPage.setSize(400,650);
        rankingLIstPage.setLocationRelativeTo(null);
        JPanel rankingLIstPanel=new JPanel(null);
        rankingLIstPage.setContentPane(rankingLIstPanel);
        rankingLIstPage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel rankingListPageBG=new JLabel();
        setBackGround.SetBackGround(rankingListPageBG,rankingLIstPage,BG1,rankingLIstPanel);

        //排行榜label
        JLabel rankingList=new JLabel("ranking");
        rankingLIstPanel.add(rankingList);
        rankingList.setBounds(150,200,150,50);

        //从排行榜返回Home的Back按钮
        JButton BackToHomePageFromRankingListPage=new JButton();
        rankingLIstPanel.add(BackToHomePageFromRankingListPage);
        SetButton.SetButton(BackToHomePageFromRankingListPage,BackButtonBig,BackButtonBigPressed);
        BackToHomePageFromRankingListPage.setBounds(100,485,BackButtonBig.getIconWidth(),BackButtonBig.getIconHeight());
        changePage.ChangePage(BackToHomePageFromRankingListPage,rankingLIstPage,homePage);

        //RankingList按钮设置
        changePage.ChangePage(RankingList,homePage,rankingLIstPage);

        //主页选项按钮和选项页面
        JButton Option=new JButton();
        homePanel.add(Option);
        SetButton.SetButton(Option,OptionButton,OptionButtonPressed);
        Option.setBounds(100,420,OptionButton.getIconWidth(),OptionButton.getIconHeight());

        //Option界面
        JFrame OptionPage=new JFrame("Option");
        OptionPage.setSize(400,650);
        JPanel OptionPanel=new JPanel(null);
        OptionPage.setContentPane(OptionPanel);
        OptionPage.setLocationRelativeTo(null);
        changePage.ChangePage(Option,homePage,OptionPage);
        JLabel OptionPageBG=new JLabel();
        setBackGround.SetBackGround(OptionPageBG,OptionPage,BG1,OptionPanel);

        //从选项界面返回Home的Back按钮
        JButton BackToHomePageFromOptionPage=new JButton();
        OptionPanel.add(BackToHomePageFromOptionPage);
        SetButton.SetButton(BackToHomePageFromOptionPage,BackButton,BackButtonPressed);
        BackToHomePageFromOptionPage.setBounds(165,500,BackButton.getIconWidth(),BackButton.getIconHeight());
        changePage.ChangePage(BackToHomePageFromOptionPage,OptionPage,homePage);

        //Apply选项更改
        JButton ConfirmOptionChange=new JButton();
        OptionPanel.add(ConfirmOptionChange);
        SetButton.SetButton(ConfirmOptionChange,ApplyButton,ApplyButtonPressed);
        ConfirmOptionChange.setBounds(35,500,ApplyButton.getIconWidth(),ApplyButton.getIconHeight());
        //保存选项更改






        //显示窗口
        homePage.setVisible(true);


    }
}
