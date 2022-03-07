public class MazeGenerator {
    public static void generate(char[][] maze, int startrow, int startcol){

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
