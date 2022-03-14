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
            char[][] land = new char[N][M];
            for(int i = 0; i<N;i++){
                String temp = input.next();
                for(int j = 0; j<M;j++){
                    land[i][j]=temp.charAt(j);
                }
            }
            int[] coor1 = new int[2];
            int[] coor2 = new int[2];
            coor1[0]=input.nextInt()-1;
            coor1[1]=input.nextInt()-1;
            coor2[0]=input.nextInt()-1;
            coor2[1]=input.nextInt()-1;
            input.close();
            int[][] landpaths = new int[N][M];
            for(int i = 0; i<N;i++){
                for(int j = 0; j<M;j++){
                    if (Math.abs(coor1[0]-i) > T || Math.abs(coor1[1]-j) >T) break;
                }
            }
            System.out.println(Arrays.toString(coor2));
            return landpaths[coor2[0]][coor2[1]];
        }catch(FileNotFoundException e){
            return -1;
        }
    }
    
}
