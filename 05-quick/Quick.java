import java.util.*;
public class Quick{
    private static Random rand = new Random();
    public static void main(String[] args){
        //int [] data = new int[] {7,6,5,4,3,2,1,0};
        int[] data = {17, 61, 67, 47, 93,12, 20, 4, 44, 68} ;
        System.out.println("Original: "+Arrays.toString(data));
        // int pivot = partition(data, 0, 4);
         System.out.println("Pivot value: "+quickselect(data, 0)+ ", Pivot index: ");
         System.out.println("Modified: "+Arrays.toString(data));
        System.out.println();
    }
    public static int partition(int[] data, int start, int end){
        end++;
        int pivot = rand.nextInt((end)-start)+start;
        int temp = data[0];
        data[0] = data[pivot];
        data[pivot] = temp;
        boolean switc = true;
        if (start==0) start=1;
        while(start<end){
            boolean isTall = data[start] < data[0];
            boolean isEqual = data[start] == data[0];
            if (isTall || (isEqual && switc)){
                if (isEqual) switc = false;
                temp = data[1];
                data[1]=data[start];
                data[start]=temp;
            } else{
                if (isEqual) switc = true;
                end-=1;
                temp = data[end];
                data[end] = data[start];
                data[start] = temp;
                start--;
            }
            start++;
        }
        temp = data[0];
        data[0]=data[start-1];
        data[start-1] = temp;
        return start-1;
    }
    public static int quickselect(int[] data, int k){
        int partstart = 0;
        int partend = data.length-1;
        while(true){
            int p = partition(data, partstart, partend);
            if (p == k){
                 return data[k];
            }else if (p < k){
                partstart =p+1;
            } else{
                partend = p-1;
            }
        }
    }
    public static void quicksort(int[] data){

    }
}