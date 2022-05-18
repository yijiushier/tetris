import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.lang.Override;

public class gamePage extends JPanel implements KeyListener {


    private final int row = 10;     //设置行数
    private final int col = 20;     //设置列数
    private final int BlockLength = 25;  //设置小方块宽度
    private final int BlockHeight = 25;  //设置小方块高度



    private int [][]data =new int[row][col]; //data储存已落下方块信息
    private int type=-1;  //  type表示方块类型，范围从0到6，一开始设type=-1表示新游戏，即无方块落下
    private int state  ;// state表示方块旋转状态，范围从0到3
    private int nexttype;  //nexttype表示下一方块类型
    private int nextstate;  // nextstate表示方块下一状态
    int x;        //x，y表示这个block的位置，在Newblock中，预设x=4，y=0，即表示方块已开始从画面最上方中间位置下落
    int y;
    private int score=0;  //score储存得分
    private Timer timer;
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

        newData();


        timer=new Timer(1000,new TimerListener() );
        timer.start();
    }



    private void NewBlock(){   //产生新方块
        if(type==-1) {  //当type=-1时表示当前没有方块下落，所以要初始化一个方块，并且预设下一方块的type和state
            type = (int) ((500 * Math.random()) % 7);  //随机产生方块类型
            state = (int) ((500 * Math.random()%4));  //随机产生方块state
            nexttype = (int) ((500 * Math.random()%7));  //随机设定下一方块类型
            nextstate = (int) ((500 * Math.random()%4));  //随机设定下一方块state
        }
        else {      //此时游戏已经开始
            type = nexttype;  //将预设方块类型赋予当前方块
            state = nextstate; //将预设方块state赋予当前方块
            nexttype = (int) ((500* Math.random()%7)); //随机设定下一方块类型
            nextstate = (int) ((500 * Math.random())%4);//随机设定下一方块state
        }
         x=4;  //x表示方块x坐标，即4✖️4方块左上角x坐标
         y=0;  //y表示方块y坐标，即4✖️4方块左上角y坐标

        if(!gameOver()){
            newData();
            repaint();
        }
    }

    private boolean gameOver() {   //判断何时游戏结束
        int[] a = block[type][state];
        boolean t = true;
        for (int k = 0; k < a.length; k++) {
            if (a[k] > 0) {
                if (data[k % 4 + x][k / 4 + y] > 0) {
                    t = false;
                    break;
                }
            }
        }
        return t;
    }


    private void add() {    //add表示将block方块坐标信息加入data中
        int[] a = block[type][state];//将block内信息导入a
        for(int k=0;k<a.length;k++){
            if(a[k]>0) data[k % 4 + x][k / 4 + y] = a[k];
        }

    }

    private void Left(){ //左移操作，需要判断能否左移
        int []a=block[type][state];
        boolean t=true;
        for(int k=0;k<a.length;k++) {
            if (a[k] > 0) {
                if (k % 4 + x - 1 < 0 || data[k %4 + x-1][k /4 + y ] > 0) {
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
                if (k % 4 + x + 1 > this.row-1 || data[k % 4 + x+1][k / 4 + y ] > 0) {
                    t = false;
                    break;
                }
            }
        }
        if (t)
            x = x + 1;
    }

    private void Down() {    //下落操作，判断能否下落

        boolean t = true;
        for (int k = 0; k < 16; k++) {
            if (block[type][state][k] > 0) {
                if (k / 4 + y + 1 > this.col-1 || data[k % 4 + x][k / 4 + y+1] > 0) {
                    t = false;
                    break;
                }
            }
        }
        if (t) {
             y++;
        }
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
                if (k % 4 + x > this.row-1 || k % 4 + x < 0 || k / 4 + y > this.col-1 || data[k % 4 + x][k / 4 + y] > 0) {
                    t = false;
                    break;
                }
            }
        }
        if (!t) {
            if(state==0)
                state=3;
            else {
                state = state-1 ;
            }
        }
    }

    private void deleteLine(){   //消行操作，判断能否消行
        for(int i=this.col-1;i>=0;i--){
            boolean t=true;
            for(int j=0;j<this.row;j++){
                if(data[j][i]==0){
                    t=false;
                    break;
                }
            }
            if(t){
                for(int a=i;a>0;i--){
                    for(int b=0;b<this.row;b++)
                        data[b][a]=data[b][a-1];
                }
                for(int b=0;b<this.row;b++)
                    data[b][0]=0;
                score+=10;  //消行成功得分➕10
            }
        }
    }

    private void newData(){  //将data里数据清空，方便开始游戏
        for (int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++)
                data[i][j]=0;
        }
    }


    public void paint(Graphics g){
        super.paint((g));//清屏；
        int[]a=block[type][state];
        for(int i=0;i<this.row;i++){
            for(int j=0;j<this.col;j++){

                    switch(data[i][j]){
                        case 1:g.setColor(Color.CYAN);break;
                        case 2:g.setColor(Color.YELLOW);break;
                        case 3:g.setColor(Color.RED);break;
                        case 4:g.setColor(Color.GREEN);break;
                        case 5:g.setColor(Color.BLUE);break;
                        case 6:g.setColor(Color.PINK);break;
                        case 7:g.setColor(Color.orange);break;
                        default:g.setColor(Color.GRAY);break;
                    }
                    g.fillRect(i*this.BlockHeight,j*this.BlockHeight,BlockLength,BlockHeight);
                    g.setColor(Color.GRAY);
                    g.drawRect(i*this.BlockHeight,j*this.BlockHeight,BlockLength,BlockHeight);

            }
        }
        for(int k=0;k<a.length;k++) {
            if (a[k] > 0) {
                switch (a[k]) {
                    case 1:
                        g.setColor(Color.CYAN);
                        break;
                    case 2:
                        g.setColor(Color.YELLOW);
                        break;
                    case 3:
                        g.setColor(Color.RED);
                        break;
                    case 4:
                        g.setColor(Color.GREEN);
                        break;
                    case 5:
                        g.setColor(Color.BLUE);
                        break;
                    case 6:
                        g.setColor(Color.PINK);
                        break;
                    case 7:
                        g.setColor(Color.orange);
                        break;
                    default:
                        g.setColor(Color.GRAY);
                        break;
                }
                g.fillRect((k % 4 + x) * this.BlockHeight, (k / 4 + y) * this.BlockHeight, BlockLength, BlockHeight);
                g.setColor(Color.GRAY);
                g.drawRect((k % 4 + x) * this.BlockHeight, (k / 4 + y) * this.BlockHeight, BlockLength, BlockHeight);
            }
        }
    }

    public void startgame(){
        newData();
        NewBlock();

    }
    public void pause(){
        timer.stop();
    }
    public void ContinueGame(){
        timer.start();
    }








    public int[] returnSize(){        //返回JPanel大小，供JFrame使用
        int[] a = new int[2];
        a[0] = this.row * this.BlockLength;
        a[1] = this.col * this.BlockHeight;
        return a;
    }

    class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent args0) {
            {
               int y1=y;
                Down();
                if(y1==y){
                    add();
                    deleteLine();
                    NewBlock();
                }
                repaint();
            }
        }
    }



    @Override   //加入键盘监听
    public void keyPressed(KeyEvent e){  //加入键盘监听
        switch(e.getKeyCode()){
            case KeyEvent.VK_DOWN:   Down();repaint();break;
            case KeyEvent.VK_LEFT:   Left();repaint();break;
            case KeyEvent.VK_RIGHT:   Right();repaint();break;
            case KeyEvent.VK_UP:      Rotate();repaint();break;
            default:break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {


    }


}


