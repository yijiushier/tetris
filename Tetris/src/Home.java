import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Home {
    public static void main(String[] args) {
        //创建游戏主页面
        JFrame homePage=new JFrame("HomePage");
        homePage.setSize(400,650);
        homePage.setLocationRelativeTo(null);
        homePage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //homePage 设置
        JPanel homePanel=new JPanel();
        homePage.setContentPane(homePanel);
        JButton play=new JButton("Play");
        homePanel.add(play);
        JButton Exit=new JButton("Exit");
        homePanel.add(Exit);

        //退出游戏
        Exit.addActionListener(e -> System.exit(0));

        //下拉列表框选择难度
        JLabel Difficulty=new JLabel("Difficulty");
        homePanel.add(Difficulty);
        String[] difficulties=new String[]{"Level 1","Level 2","Level 3","Level 4"};
        final JComboBox<String> chooseDifficulty= new JComboBox<>(difficulties);
        chooseDifficulty.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange()==ItemEvent.SELECTED){
                    System.out.println("游戏难度设置为"+chooseDifficulty.getSelectedItem());
                }
            }
        });
        homePage.add(chooseDifficulty);

        //点击Ranking List按钮跳转到排行榜界面
        JButton RankingList=new JButton("Ranking List");
        homePage.add(RankingList);

        //开始游戏过渡界面
        JFrame ChooseGamePage=new JFrame("ChooseGame");
        ChooseGamePage.setSize(400,650);
        ChooseGamePage.setLocationRelativeTo(null);
        ChooseGamePage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //ChooseGame Page 设置
        JPanel chooseGame=new JPanel();
        ChooseGamePage.setContentPane(chooseGame);
        JButton NewGame=new JButton("New Game");
        chooseGame.add(NewGame);
        JButton GameSaves=new JButton("GameSaves");
        chooseGame.add(GameSaves);
        JButton BackToHomePageFromChooseGame=new JButton("Back");
        chooseGame.add(BackToHomePageFromChooseGame);
        changePage.ChangePage(BackToHomePageFromChooseGame,ChooseGamePage,homePage);

        //点击play按钮跳转到选择游戏界面
        changePage.ChangePage(play,homePage,ChooseGamePage);

        //点击GameSavers跳转到存档界面
        JFrame GameSaversPage=new JFrame("Saves");
        GameSaversPage.setSize(400,650);
        JPanel GameSaverPanel=new JPanel();
        GameSaversPage.setContentPane(GameSaverPanel);
        GameSaversPage.setLocationRelativeTo(null);
        JLabel Savers=new JLabel("历史存档");
        JButton BackToChooseGamePageFromGameSaversPage=new JButton("Back");
        GameSaverPanel.add(Savers);
        GameSaverPanel.add(BackToChooseGamePageFromGameSaversPage);
        changePage.ChangePage(GameSaves,ChooseGamePage,GameSaversPage);
        changePage.ChangePage(BackToChooseGamePageFromGameSaversPage,GameSaversPage,ChooseGamePage);

        //点击New Game按钮开始新游戏
        JFrame GamePage=new JFrame("Game Running");
        JPanel GamePanel=new JPanel();
        GamePage.setSize(400,650);
        GamePage.setLocationRelativeTo(null);
        GamePage.setContentPane(GamePanel);
        GamePage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        changePage.ChangePage(NewGame,ChooseGamePage,GamePage);
        JButton Pause=new JButton("Pause");

        //返回主页面是询问是否存档
        JFrame SaveOrNot=new JFrame();
        SaveOrNot.setLocationRelativeTo(null);
        SaveOrNot.setSize(200,200);
        SaveOrNot.setLocationRelativeTo(null);
        JLabel SaveOrNotLabel=new JLabel("Do you want to save your game?");
        JButton DoSave=new JButton("Yes");
        JButton NotSave=new JButton("No");
        JButton BackToPausePageFromSaveOrNot=new JButton("Back");
        JPanel SaveOrNotPanel=new JPanel();
        SaveOrNot.setContentPane(SaveOrNotPanel);
        SaveOrNotPanel.add(DoSave);
        SaveOrNotPanel.add(NotSave);
        SaveOrNotLabel.add(BackToPausePageFromSaveOrNot);


        //Pause按钮、暂停界面设置
        GamePanel.add(Pause);
        JFrame PausePage=new JFrame("Pause");
        PausePage.setSize(200,200);
        PausePage.setLocationRelativeTo(null);
        JPanel PausePanel=new JPanel();
        PausePage.setContentPane(PausePanel);
        JButton BackToHomePageFromPausePage=new JButton("Home");
        PausePanel.add(BackToHomePageFromPausePage);
        JButton ContinuePlay=new JButton("Continue");
        ContinuePlay.addActionListener(e -> PausePage.setVisible(false));
        PausePanel.add(ContinuePlay);
        BackToHomePageFromPausePage.addActionListener(e -> {
            PausePage.setVisible(false);
            SaveOrNot.setVisible(true);
        });
        JButton HowToPlay=new JButton("How To Play");
        PausePanel.add(HowToPlay);

        //暂停游戏
        pauseAction.PauseAction(Pause,PausePage);

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
        JPanel HowToPlayPanel=new JPanel();
        HowToPlayPage.setContentPane(HowToPlayPanel);
        HowToPlayPage.setLocationRelativeTo(null);
        JLabel HowToPlayLabel=new JLabel("爱咋玩咋玩");
        JButton BackToPausePageFromHowToPLayPage=new JButton("Back");
        HowToPlayPanel.add(HowToPlayLabel);
        HowToPlayPanel.add(BackToPausePageFromHowToPLayPage);
        changePage.ChangePage(HowToPlay,PausePage,HowToPlayPage);
        changePage.ChangePage(BackToPausePageFromHowToPLayPage,HowToPlayPage,PausePage);


        //排行榜界面
        JFrame rankingLIstPage=new JFrame("Ranking List");
        rankingLIstPage.setSize(400,650);
        rankingLIstPage.setLocationRelativeTo(null);
        rankingLIstPage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel rankingList=new JLabel("ranking");
        JPanel rankingLIstPanel=new JPanel();
        rankingLIstPage.setContentPane(rankingLIstPanel);
        rankingLIstPanel.add(rankingList);
        JButton BackToHomePageFromRankingListPage=new JButton("Back");
        rankingLIstPanel.add(BackToHomePageFromRankingListPage);
        changePage.ChangePage(BackToHomePageFromRankingListPage,rankingLIstPage,homePage);

        //RankingList按钮设置
        changePage.ChangePage(RankingList,homePage,rankingLIstPage);

        //主页选项按钮和选项页面
        JButton Option=new JButton("Option");
        homePanel.add(Option);
        JFrame OptionPage=new JFrame("Option");
        OptionPage.setSize(400,650);
        JPanel OptionPanel=new JPanel();
        OptionPage.setContentPane(OptionPanel);
        OptionPage.setLocationRelativeTo(null);
        changePage.ChangePage(Option,homePage,OptionPage);
        JButton BackToHomePageFromOptionPage=new JButton("Back");
        JButton ConfirmOptionChange=new JButton("Apply");
        OptionPanel.add(ConfirmOptionChange);
        //保存选项更改




        OptionPanel.add(BackToHomePageFromOptionPage);
        changePage.ChangePage(BackToHomePageFromOptionPage,OptionPage,homePage);

        //显示窗口
        homePage.setVisible(true);


    }
}

