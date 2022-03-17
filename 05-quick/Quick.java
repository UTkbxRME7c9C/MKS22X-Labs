import java.util.*;
public class Quick{
    private static Random rand = new Random();
    public static void main(String[] args){
        int [] data = new int[] {7,6,5,4,3,2,1,0};
       //int[] data = {17, 61, 67, 47, 93,12, 20, 4, 44, 68} ;
        for(int i = 0;i<data.length;i++){
            System.out.println(quickselect(data,i));
        }
        //int pivot = partition( data , 0,data.length-1);
        //System.out.println("Pivot value: "+data[pivot]+ ", Pivot index: "+pivot);
        System.out.println("Modified: "+Arrays.toString(data));
        System.out.println();
    }
    public static int partition(int[] data, int start, int end){
        // possible fix this
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
        int start = 0;
        int end = data.length-1;
        while(true){
            int p = partition(data, start, end);
            if (p == k){
               // System.out.println(Arrays.toString(data));
                 return data[k];
            }else if (p < k){
                start = p+1;
            } else{
                end = p-1;
            }
        }
    }
    public static void quicksort(int[] data){
        quicksort(data,0,data.length-1);
    }
    public static void quicksort(int[] data, int start, int end){
        while (start<end){
            int p = partition(data, start, end);
            int nstart = p+1;
            int nend = p-1;
            quicksort(data, nstart,end);
            quicksort(data,start,nend);
            start = nstart;
            end = nend;
        }
    }
}