import java.awt.Color;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;
import java.io.*;
import java.lang.Override;
import java.awt.Font;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;



public class gamePage extends JPanel implements KeyListener  {


    private final int row = 10;     //设置行数
    private final int col = 20;     //设置列数
    private final int BlockLength = 25;  //设置小方块宽度
    private final int BlockHeight = 25;  //设置小方块高度



    private int [][]data =new int[row][col]; //data储存已落下方块信息
    private int type=-1;  //  type表示方块类型，范围从0到6，一开始设type=-1表示新游戏，即无方块落下
    private int state  ;// state表示方块旋转状态，范围从0到3
    private int nextType;  //nextType表示下一方块类型
    private int nextState;  // nextState表示方块下一状态
    int x;        //x，y表示这个block的位置，在NewBlock中，预设x=4，y=0，即表示方块已开始从画面最上方中间位置下落
    int y;
    private int score=0;  //score储存得分
    private Timer timer;
    private int t=1000;
    private boolean GameRunning=true;
    private String[] StoredData=new String[206];

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

    public gamePage() {

    }

    public void setDifficulty(int t){
        this.t=t;
    }



    private void NewBlock(){   //产生新方块
        if(type==-1) {  //当type=-1时表示当前没有方块下落，所以要初始化一个方块，并且预设下一方块的type和state
            type = (int) ((500 * Math.random()) % 7);  //随机产生方块类型
            state = (int) ((500 * Math.random()%4));  //随机产生方块state
        }
        else {      //此时游戏已经开始
            type = nextType;  //将预设方块类型赋予当前方块
            state = nextState; //将预设方块state赋予当前方块
        }
        nextType = (int) ((500 * Math.random()%7));  //随机设定下一方块类型
        nextState = (int) ((500 * Math.random()%4));  //随机设定下一方块state

        x=4;  //x表示方块x坐标，即4✖️4方块左上角x坐标
         y=0;  //y表示方块y坐标，即4✖️4方块左上角y坐标

        if(!gameOver()){
            timer.cancel();
        }
    }

    //为主程序提供代表游戏进行的boolean值
public boolean isGameRunning(){
        return GameRunning;
}

    public boolean gameOver() {   //判断何时游戏结束
        int[] a = block[type][state];
        boolean t = true;
        for (int k = 0; k < a.length; k++) {
            if (a[k] > 0) {
                if (data[k % 4 + x][k / 4 + y] > 0) {
                    t= false;
                    GameRunning=false;
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

        boolean t = true;
        if (state == 3) {
            state=0;
        }
        else {
            state=state+1;
        }
        for (int k = 0; k <16; k++) {
            if (block[type][state][k] > 0) {
                if (k % 4 + x > this.row - 1 || k % 4 + x < 0 || k / 4 + y > this.col - 1
                        ||k/4+y<0|| data[k % 4 + x][k / 4 + y] > 0) {
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
                for(int a=i;a>0;a--){
                    for(int b=0;b<this.row;b++)
                        data[b][a]=data[b][a-1];
                }
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
                        default:g.setColor(new Color(254,229,163));break;
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
        for(int c=0;c<block[nextType][nextState].length;c++){
            if(block[nextType][nextState][c]>0){
                switch (block[nextType][nextState][c]) {
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
                g.fillRect((c % 4 + 12) * this.BlockHeight-10, (c / 4 + 12) * this.BlockHeight, BlockLength, BlockHeight);
                g.setColor(Color.GRAY);
                g.drawRect((c % 4 + 12) * this.BlockHeight-10, (c / 4 + 12) * this.BlockHeight, BlockLength,BlockHeight);
            }
        }
        g.setFont(new Font("楷体", Font.BOLD, 30));
        g.drawString("得分",283,4*BlockHeight);
        g.drawString(String.valueOf(score),12*BlockLength,6*BlockHeight);
        g.drawString("下一方块",260,10*BlockHeight);
    }

    public void startGame(){
        newData();
        NewBlock();
        this.timer=new Timer();
        this.timer.schedule(new task(),0,t);

    }
    public void loadGame(){
        NewBlock();
        this.timer=new Timer();
        this.timer.schedule(new task(),0,t);
    }
    public void pause(){
        this.timer.cancel();
    }
    public void ContinueGame(){
        this.timer=new Timer();
        this.timer.schedule(new task(),0,t);
    }
    public void home() {
        this.timer.cancel();
    }

    //为主程序提供最新分数值
    public String getScore(){
        return String.valueOf(score);
    }

    //将玩家分数清零
    public void resetScore(){
        score=0;
    }






    public int[] returnSize(){        //返回JPanel大小，供JFrame使用
        int[] a = new int[2];
        a[0] = this.row * this.BlockLength;
        a[1] = this.col * this.BlockHeight;
        return a;
    }





    class task extends TimerTask {
        @Override
        public void run(){
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

    public void setStoredData(){
        StoredData[0]=Integer.toString(x);
        StoredData[1]=Integer.toString(y);
        StoredData[2]=Integer.toString(type);
        StoredData[3]=Integer.toString(state);
        StoredData[4]=Integer.toString(nextType);
        StoredData[5]=Integer.toString(nextState);
            for (int j=0;j<data.length;j++){
                for (int k=0;k<data[j].length;k++){
                    StoredData[6+20*j+k]=Integer.toString(data[j][k]);
                }
            }
    }

    //改变代表游戏运行的boolean值
    public void resetGameRunning(){
        GameRunning=true;
    }


    //save

     public void saveDataToFile(String fileName) {
        BufferedWriter writer = null;
        File file = new File("Tetris/src/savers\\"+ fileName + ".txt");
        //如果文件不存在，则新建一个
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //写入
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false),StandardCharsets.UTF_8));
            for (int i=0;i<StoredData.length;i++) {
                writer.write(StoredData[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("文件写入成功！");
    }

    public String getDataFromFile(String fileName) {

        String Path="Tetris/src/savers\\" + fileName+ ".txt";
        BufferedReader reader = null;
        StringBuilder lastStr = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            reader = new BufferedReader(inputStreamReader);
            String tempString;
            while ((tempString = reader.readLine()) != null) {
                lastStr.append(tempString);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return lastStr.toString();
    }

    public void setData(String storedData){
        this.x=Integer.parseInt(storedData.substring(0,1));
        this.y=Integer.parseInt(storedData.substring(1,2));
        this.type=Integer.parseInt(storedData.substring(2,3));
        this.state=Integer.parseInt(storedData.substring(3,4));
        this.nextType=Integer.parseInt(storedData.substring(4,5));
        this.nextState=Integer.parseInt(storedData.substring(5,6));

               for (int j=0;j<data.length;j++){
                   for (int k=0;k<data[j].length;k++){
                       data[j][k]=Integer.parseInt(storedData.substring(6+20*j+k,6+20*j+k+1));
                   }
       }
    }

}
