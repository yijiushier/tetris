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

    private JLabel[][] labels;  //设置labels储存方块信息,用于画布
    private int data [][]=new int[row][col]; //data储存已落下方块信息
    private int type=-1;  ;//  type表示方块类型，范围从0到6，一开始设type=-1表示新游戏，即无方块落下
    private int state  ;// state表示方块旋转状态，范围从0到3
    private int nexttype;  //nexttype表示下一方块类型
    private int nextstate;  // nextstate表示方块下一状态
    int x;        //x，y表示这个block的位置，在Newblock中，预设x=4，y=0，即表示方块已开始从画面最上方中间位置下落
    int y;
    private final int [][]block_0= { //l型方块
            {1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final int [][]block_1= { //倒l型方块
            {2, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0},
            {0, 0, 2, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {2, 0, 0, 0, 2, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0},
            {2, 2, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final int [][]block_2= {  //z型方块
            {0, 3, 0, 0, 3, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
            {3, 3, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 3, 0, 0, 3, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0},
            {3, 3, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final int [][]block_3= { //倒z型方块
            {4, 0, 0, 0, 4, 4, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0},
            {0, 4, 4, 0, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {4, 0, 0, 0, 4, 4, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0},
            {0, 4, 4, 0, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final int [][]block_4= {   //一字型方块
            {5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {5, 0, 0, 0, 5, 0, 0, 0, 5, 0, 0, 0, 5, 0, 0, 0},
            {5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {5, 0, 0, 0, 5, 0, 0, 0, 5, 0, 0, 0, 5, 0, 0, 0}
    };
    private final int [][]block_5= {   //田型方块
            {6, 6, 0, 0, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {6, 6, 0, 0, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {6, 6, 0, 0, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {6, 6, 0, 0, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    private final int [][]block_6= {   //T型方块
            {0, 7, 0, 0, 7, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {7, 0, 0, 0, 7, 7, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0},
            {7, 7, 7, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 7, 0, 0, 7, 7, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0}
    };
    private final int[][][]block={ //其中数字大于1代表有方块，不同数字代表不同颜色
            block_0,
            block_1,
            block_2,
            block_3,
            block_4,
            block_5,
            block_6
    };

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

    private void NewBlock(){   //产生新方块
        if(type==-1) {  //当type=-1时表示当前没有方块下落，所以要初始化一个方块，并且预设下一方块的type和state
            type = (int) (7 * Math.random());  //随机产生方块类型
            state = (int) (4 * Math.random());  //随机产生方块state
            nexttype = (int) (7 * Math.random());  //随机设定下一方块类型
            nextstate = (int) (4 * Math.random());  //随机设定下一方块state
        }
        else {      //此时游戏已经开始
            type = nexttype;  //将预设方块类型赋予当前方块
            state = nextstate; //将预设方块state赋予当前方块
            nexttype = (int) (7 * Math.random()); //随机设定下一方块类型
            nextstate = (int) (4 * Math.random());//随机设定下一方块state
        }
        int x=4;  //x表示方块x坐标，即4✖️4方块左上角x坐标
        int y=0;  //y表示方块y坐标，即4✖️4方块左上角y坐标

        //这里写gameover判断条件
    }


    private void add() {    //add表示将block方块坐标信息加入data中
        int[] a = block[type][state];    //将block内信息导入a
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (y <= i && i <= y + 3 && x <= j && j <= x + 3) {//判断条件是i，j坐标是否包含在block内
                    data[i][j] = a[(i - y) * 4 + j - x]; //如果在，则将block内信息导入data
                }
            }
        }
    }

    private void Left(){ //左移操作，需要判断能否左移
        int []a=block[type][state];
        boolean t=true;
           for(int k=0;k<a.length;k++) {
               if (a[k] > 0) {
                   if (k % 4 + x - 1 < 0 || data[k / 4 + y][k % 4 + x - 1] > 0) {
                       t = false;
                       break;
                   }
               }
           }
           if(t)
               x=x-1;
    }

    private void Right() { //右移操作，判断能否右移
        int[] a = block[type][state];
        boolean t = true;
        for (int k = 0; k < a.length; k++) {
            if (a[k] > 0) {
                if (k % 4 + x + 1 > this.row || data[k / 4 + y][k % 4 + x + 1] > 0) {
                    t = false;
                    break;
                }
            }
        }
        if (t)
            x = x + 1;
    }
    
    private void Down() {    //下落操作，判断能否下落
        int[] a = block[type][state];
        boolean t = true;
        for (int k = 0; k < a.length; k++) {
            if (a[k] > 0) {
                if (k / 4 + y + 1 > this.col || data[k / 4 + y + 1][k % 4 + x] > 0) {
                    t = false;
                    break;
                }
                ;
            }
        }
        if (t)
            y = y + 1;
    }
    
    private void Rotate() {  //旋转操作，判断能否旋转
        int[] a;
        boolean t = true;
        if (state == 3) {
            a = block[type][0];
        } else {
            a = block[type][state + 1];
        }
        for (int k = 0; k < a.length; k++) {
            if (a[k] > 0) {
                if (k % 4 + x > this.row || k % 4 + x < 0 || k / 4 + y > this.col || data[k / 4 + y][k % 4 + x] > 0) {
                    t = false;
                    break;
                }
            }
        }
        if (t) {
            state = state + 1;
        }
    }
    
    








    public int[] returnSize(){        //返回JPanel大小，供JFrame使用
        int[] a = new int[2];
        a[0] = this.row * this.BlockLength;
        a[1] = this.col * this.BlockHeight;
        return a;
    }
}














