import java.util.*;
import java.io.*;
public class Maze{
    private char[][] maze;
    private boolean animate;//false by default
    private int startRow,startCol;

    public Maze(String filename) throws FileNotFoundException{
        animate = false;
        File fil = new File(filename);
        Scanner input = new Scanner(fil);
        String tmp = "";
        while(input.hasNextLine()){
            tmp+=input.nextLine() + "!";
        }
        input.close();
        for(int i = 0; i<tmp.length();i++){
            if (tmp.charAt(i)=='S') break;
            if (tmp.charAt(i)=='!'){
                startRow=0;
                startCol++;
            }else{
                startRow++;
            }
        }
        String[] temp = tmp.split("!");
        maze = new char[temp.length][];
        for(int i = 0;i<maze.length;i++){
            maze[i] = temp[i].toCharArray();
        }
    }

    private void wait(int millis){
        try {
        Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }

    public void setAnimate(boolean b){
        animate = b;
    }

    public static void clearTerminal(){
        System.out.println("\033[2J");
    }
    public static void gotoTop(){
        System.out.println("\033[1;1H");
    }

    public String toString(){
        String ans = "";
        for(int i = 0; i < maze.length;i++){
            for(int j = 0; j < maze[0].length;j++){
                ans+=maze[i][j];
            }
            ans+="\n";
        }
        return ans;
    }


    public int solve(){
        if(animate){
        clearTerminal();
        }
        return solve(startCol,startRow);

    }

    private int solve(int row, int col){ //you can add more parameters since this is private
        //automatic animation! You are welcome.
        animate();
        if (maze[row][col]=='E'){
            return 0;
        }else if (maze[row][col]=='#' || maze[row][col] == '.' || maze[row][col]=='@'){
            return -1;
        }else{
            maze[row][col] = '@';
            animate();
            int s = solve(row+1, col);
            int n = solve(row-1,col);
            int w = solve(row,col+1);
            int e = solve(row,col-1);
            if (s>-1){
                return s+1;
            } else if (n>-1){
                return n+1;
            } else if (w>-1){
                return w+1;
            } else if (e>-1){
                return e+1;
            }else{
                maze[row][col] = '.';
                animate();
                return -1;
            }
        }
    }

    private void animate(){
        if(animate){
            gotoTop();
            System.out.println(this);
            wait(50);
        }
    }
}