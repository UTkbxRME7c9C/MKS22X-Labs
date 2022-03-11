import java.util.*;
import java.io.*;
public class Bronze{
    public static long solve(String filename) throws FileNotFoundException{
        ArrayList<Integer> palot = new ArrayList<Integer>();
        File what = new File(filename);
        Scanner input = new Scanner(what);
        String[] temp = input.nextLine().split(" ");
        int R = Integer.parseInt(temp[0]);
        int C = Integer.parseInt(temp[1]);
        int E = Integer.parseInt(temp[2]);
        int[][] land = new int[R][C];
        for(int i = 0; i<R;i++){
            for(int j = 0; j<C;j++){
                land[i][j]=input.nextInt();
            }
        }
        while(input.hasNextInt()){
            palot.add(input.nextInt());
        }
        input.close();
        while(palot.size()>0){
            int R_s = palot.remove(0)-1;
            int C_s = palot.remove(0)-1;
            int D_s = palot.remove(0);
            //find biggest number in square
            int maxnum = 0;
            for(int i = 0;i<3;i++){
                for(int j = 0; j<3;j++){
                    maxnum = Math.max(land[R_s+i][C_s+j], maxnum);
                }
            }     
            maxnum -= D_s;
            for(int i = 0;i<3;i++){
                for(int j = 0; j<3;j++){
                    if (land[R_s+i][C_s+j]>maxnum){
                        land[R_s+i][C_s+j] = maxnum;
                    }
                }
            }
        }
        int total = 0;
        for(int i = 0; i<R;i++){
            for(int j = 0; j<C;j++){
                if (E <= land[i][j]){
                    land[i][j] = 0;
                } else {
                    land[i][j] = E-land[i][j];
                }
                total+=land[i][j];
            }
        }
        //System.out.println(Arrays.deepToString(land));
        //System.out.println((total*72)*72);
        return ((total*72)*72);
    }
}