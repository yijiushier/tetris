import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Keyboard{


@Override
public void keyPressed(KeyEvent a){
    switch (a.getKeyCode()){
        case KeyEvent.VK_DOWN:
            Down();
            break;
        case KeyEvent.VK_LEFT:
            Left();
            break;
        case KeyEvent.VK_RIGHT:
            Right();
            break;
        case KeyEvent.VK_UP:
            Rotate();
            break;
    }
}

}
