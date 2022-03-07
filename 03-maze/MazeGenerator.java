import java.util.Random;
public class MazeGenerator {
    private static Random a = new Random();
    public static void generate(char[][] maze, int startrow, int startcol){
        generateMaze(maze, startrow, startcol);
        maze[startrow][startcol] = 'S';
        while (true){
            int i = a.nextInt(maze.length);
            int j = a.nextInt(maze[0].length);
            if(maze[i][j] == ' '){
                maze[i][j] = 'E';
                break;
            }
        }
    }
    public static void generateMaze(char[][] maze, int startrow, int startcol){
        if (startrow <= 0){
            //generate(maze, startrow+1, startcol);
        } else if (startcol <= 0){
            //generate(maze, startrow, startcol+1);
        } else if (startrow >= maze.length-1){
           // generate(maze, startrow-1, startcol);
        } else if (startcol >= maze[0].length-1) {
           // generate(maze, startrow, startcol-1);
        }
        else if (maze[startrow][startcol] == ' '){
           // generate(maze, startrow, startcol-1);
        } else{
            int spaces = 0;
            if (maze[startrow][startcol+1] == ' ' ) spaces++;
            if (maze[startrow][startcol-1] == ' ' ) spaces++;
            if (maze[startrow+1][startcol] == ' ' ) spaces++;
            if (maze[startrow-1][startcol] == ' ' ) spaces++;
            if (spaces>1){ 
           //     generate(maze, startrow, startcol-1);
            }
            else {
                maze[startrow][startcol] = ' ';
                generateMaze(maze, startrow+1, startcol);
                generateMaze(maze, startrow, startcol-1);
                generateMaze(maze, startrow, startcol+1);
                generateMaze(maze, startrow-1, startcol);
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


// private int solve(int row, int col){ //you can add more parameters since this is private
//     //automatic animation! You are welcome.
//     animate();
//     if (maze[row][col]=='E'){
//         return 0;
//     }else if (maze[row][col]=='#' || maze[row][col] == '.' || maze[row][col]=='@'){
//         return -1;
//     }else{
//         maze[row][col] = '@';
//         animate();
//         int s = solve(row+1, col);
//         int n = solve(row-1,col);
//         int w = solve(row,col+1);
//         int e = solve(row,col-1);
//         if (s>-1){
//             return s+1;
//         } else if (n>-1){
//             return n+1;
//         } else if (w>-1){
//             return w+1;
//         } else if (e>-1){
//             return e+1;
//         }else{
//             maze[row][col] = '.';
//             animate();
//             return -1;
//         }
//     }
// }

// private void animate(){
//     if(animate){
//         gotoTop();
//         System.out.println(this);
//         wait(50);
//     }
// }