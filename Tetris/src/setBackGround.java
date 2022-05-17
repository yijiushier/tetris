import javax.swing.*;

public class setBackGround {
    public static void SetBackGround(JLabel label,JFrame BackFrame,ImageIcon BackPicture,JPanel FrontPanel){
        label.setIcon(BackPicture);
        BackFrame.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        label.setBounds(0,-30,BackPicture.getIconWidth(),BackPicture.getIconHeight());
        FrontPanel.setOpaque(false);
    }
}
