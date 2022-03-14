import java.io.FileNotFoundException;

import java.util.*;
import java.io.*;
public class Silver {
    public static long solve(String filename){
        try{
            File what = new File(filename);
            Scanner input = new Scanner(what);
            String[] temp = input.nextLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            int M = Integer.parseInt(temp[1]);
            int T = Integer.parseInt(temp[2]);
            char[][] land = new char[N][M];
            for(int i = 0; i<N;i++){
                for(int j = 0; j<M;j++){
                    land[i][j]=input.next().charAt(0);
                }
            }
            input.close();
            return 1;
        }catch(FileNotFoundException e){
            return -1;
        }
    }
    
}
