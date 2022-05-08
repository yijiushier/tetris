import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pauseAction {
    public static void PauseAction(JButton pause,JFrame PausePage){
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PausePage.setVisible(true);
            }
        });
    }
}
