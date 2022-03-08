import java.util.Random;
import java.util.ArrayList;
public class MazeGenerator {
    private static Random a = new Random();
    private static final int[][] offset = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public static void generate(int startrow, int startcol){
        char[][]maze = new char[startrow][startcol];
        for (int i = 0;i<maze.length;i++){
            for (int j = 0;j<maze[0].length;j++){
                maze[i][j] = '#';
            }
        }
        generate(maze, startrow, startcol);
    }
    public static void generate(char[][] maze, int startrow, int startcol){
        generateMaze(maze, startrow, startcol, 2, new int[2]);
        maze[startrow][startcol] = 'S';
        int radius = (Math.min(maze.length,maze[0].length))/2;
        while (true){
            int i = a.nextInt(maze.length);
            int j = a.nextInt(maze[0].length);
            if(maze[i][j] == ' ' && (startrow-radius>=i || startrow+radius <=i) && (startcol-radius>=j || startcol+radius <=j)){
                maze[i][j] = 'E';
                break;
            }
        }
    }
    private static boolean canCurve(char[][]board,int row,int col){
        if (row<=0 || col <= 0 || row>=board.length-1 || col>=board[0].length-1  || board[row][col] == ' ') return false;
        int spaces = 0;
        if (board[row][col+1] == ' ') spaces++;
        if (board[row][col-1] == ' ') spaces++;
        if (board[row+1][col] == ' ') spaces++;
        if (board[row-1][col] == ' ') spaces++;
        if (spaces>=2) return false;
        return true;
        
    }
    public static void generateMaze(char[][] maze, int startrow, int startcol, int repturn, int[] turns){
        if (canCurve(maze, startrow, startcol)){
            maze[startrow][startcol] = ' ';
            ArrayList<Integer> index = new ArrayList<Integer>();
            index.add(0);
            index.add(1);
            index.add(2);
            index.add(3);
            while(index.size()>0){
                if(repturn>0){
                    repturn--;
                    generateMaze(maze, startrow+turns[0], startcol+turns[1], repturn, turns);
                }else{
                    int direction = index.remove(a.nextInt(index.size()));
                    turns[0] = offset[direction][0];
                    turns[1] = offset[direction][1];
                    repturn = 2;
                    generateMaze(maze, startrow+turns[0], startcol+turns[1], repturn, turns);
                }
            }
        }

    }
    public static String toString(char[][] maze){
        String ans = "";
        for(int i = 0; i < maze.length;i++){
            for(int j = 0; j < maze[0].length;j++){
                ans+=maze[i][j];
            }
            ans+="\n";
        }
        return ans;
    }
}
