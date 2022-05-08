import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;

public class gamePage extends JPanel {
    private static final long abced = 1l;

    private int row = 10;     //设置行数
    private int col = 20;     //设置列数
    private final int BlockLength = 30;  //设置小方块宽度
    private final int BlockHeight = 30;  //设置小方块高度

    private JLabel[][] labels;  //设置labels储存方块信息

    public gamePage() {                  //constructor
        this.row = 10;
        this.col = 20;
        this.labels = new JLabel[row][col];
        this.setLayout(null);
        this.initialLabel();
    }

    private void initialLabel() {        //先将每个小方块填充为白色
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                JLabel a = new JLabel("", JLabel.CENTER);
                a.setBounds(i * BlockLength, j * BlockHeight, BlockLength, BlockHeight);//设置小方块边界
                a.setBorder(BorderFactory.createLineBorder(Color.GRAY)); //设置小方块边框
                a.setOpaque(true);  //设置小方块颜色为透明
                this.add(a);        //将小方块信息加入面板
                labels[i][j] = a;     //将小方块信息加入labels
            }
        }
    }

    public int[] returnSize() {        //返回JPanel大小，供JFrame使用
        int[] a = new int[2];
        a[0] = this.row * BlockLength;
        a[1] = this.col * BlockHeight;
        return a;
    }




}








