import javax.swing.*;
import java.awt.*;

public class game extends JFrame  {
    gamePage page=new gamePage();
    JFrame frame=new JFrame();
    ImageIcon BG1=new ImageIcon("tetris/Tetris/src/bg/bg1.png");


    public  game(){
        page.setLayout(null);
        page.startgame();
        addKeyListener(page);
        frame.setTitle("Game Running");
        add(page);
        setSize(400, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        JLabel GamePageBG=new JLabel();
        setBackGround.SetBackGround(GamePageBG,frame,BG1,page);

    }
}