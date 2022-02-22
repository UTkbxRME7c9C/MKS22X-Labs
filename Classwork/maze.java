import java.io.File;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class maze{

    public static char[][] printline(String filename) throws FileNotFoundException{
        File fil = new File(filename);
        Scanner input = new Scanner(fil);
        String tmp = "";
        while(input.hasNextLine()){
            tmp+=input.nextLine() + "\n";
        }
        input.close();
        String[] temp = tmp.split("\n");
        char[][] lines = new char[temp.length][];
        for(int i = 0;i<lines.length;i++){
            lines[i] = temp[i].toCharArray();
        }
        return lines;
    }

    public static String toStr(char[][] board){
        String ans = "";
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[0].length;j++){
                ans+=board[i][j];
            }
            ans+="\n";
        }
        return ans;
    }
    public static void main(String[] args){
        try {
            System.out.println(toStr(printline("mze")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}