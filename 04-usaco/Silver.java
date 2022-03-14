import java.io.FileNotFoundException;

import java.util.*;
import java.io.*;
public class Silver {
    public static long solve(String filename){
        try{
            File what = new File(filename);
            Scanner input = new Scanner(what);
            int N = input.nextInt();
            int M = input.nextInt();
            int T = input.nextInt();
            int[][] landpaths = new int[N][M];
            char[][] land = new char[N][M];
            for(int i = 0; i<N;i++){
                String temp = input.next();
                for(int j = 0; j<M;j++){
                    land[i][j]=temp.charAt(j);
                }
            }
            int R1=input.nextInt()-1;
            int C1=input.nextInt()-1;
            int R2=input.nextInt()-1;
            int C2=input.nextInt()-1;
            for (int i = 0;i<N;i++){
                for (int j =0;j<M;j++){
                    if (land[i][j] == '*'){
                        landpaths[i][j]=-1;
                    }
                }
            }
            landpaths[R1][C1] = 1;
            input.close();
            for (int i = T;i>0;i--){
                
            }

            System.out.println(Arrays.toString(coor2));
            return landpaths[coor2[0]][coor2[1]];
        }catch(FileNotFoundException e){
            return -1;
        }
    }


    
}
