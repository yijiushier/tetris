import javax.swing.*;

public class SetButton {
    public static void SetButton(JButton Button,ImageIcon DefaultImage,ImageIcon PressedImage){
        Button.setContentAreaFilled(false);
        Button.setBorderPainted(false);
        Button.setIcon(DefaultImage);
        Button.setPressedIcon(PressedImage);
    }
}
