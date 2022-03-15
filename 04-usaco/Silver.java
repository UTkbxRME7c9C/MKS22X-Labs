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
            int[][][] landpaths = new int[2][N][M];
            for(int i = 0; i<N;i++){
                String temp = input.next();
                for(int j = 0; j<M;j++){
                  if (temp.charAt(j) == '*'){
                    landpaths[0][i][j] = -1;
                    landpaths[1][i][j] = -1;
                  }
                }
            }
            int R1=input.nextInt()-1;
            int C1=input.nextInt()-1;
            int R2=input.nextInt()-1;
            int C2=input.nextInt()-1;
            landpaths[0][R1][C1] = 1;
            landpaths[1][R1][C1] = 1;
            input.close();
            int first = 0;
            int second = 1;
            for (int time = 0;time<T;time++){
                if (first==1){
                  first=0;
                  second=1;
                }else{
                  first=1;
                  second=0;
                }
                for(int i=0;i<N;i++){
                  for(int j=0;j<M;j++){
                    if (landpaths[first][i][j] != -1){
                      int temp = 0;
                      if (i>0){
                        if (landpaths[first][i-1][j] != -1) temp+=landpaths[first][i-1][j];
                      }
                      if (i<N-1){
                        if (landpaths[first][i+1][j] != -1) temp+=landpaths[first][i+1][j];
                      }
                      if (j>0){
                        if (landpaths[first][i][j-1] != -1) temp+=landpaths[first][i][j-1];
                      }
                      if (j<M-1){
                        if (landpaths[first][i][j+1] != -1) temp+=landpaths[first][i][j+1];
                      }
                      landpaths[second][i][j] = temp;
                    }
                  }
                }
            }
            System.out.println(Arrays.deepToString(landpaths));
            return landpaths[second][R2][C2];
        }catch(FileNotFoundException e){
            return -1;
        }
    }



}
