import java.util.*;
public class Quick{
    private static Random rand = new Random();
    public static void main(String[] args){
        //int [] data = {7,6,5,4,3,2,1,0};
        int[] data = {17, 61, 67, 47, 93,12, 20, 4, 44, 68} ;
        // for(int i = 0;i<data.length;i++){
        //     System.out.println(quickselect(data,i));
        // }
        quicksort(data);
        // int pivot = partition( data , 4,data.length-1);
        // System.out.println("Pivot value: "+data[pivot]+ ", Pivot index: "+pivot);
        System.out.println("Modified: "+Arrays.toString(data));
        System.out.println();
    }
    public static int partition(int[] data, int start, int end){
        end++;
        int pivot = rand.nextInt((end)-start)+start;
        int temp = data[start];
        data[start] = data[pivot];
        data[pivot] = temp;
        boolean switc = true;
        int newstart = start;
        start++;
        while(start<end){
            boolean isTall = data[start] < data[newstart];
            boolean isEqual = data[start] == data[newstart];
            if (isTall || (isEqual && switc)){
                if (isEqual) switc = false;
                temp = data[newstart+1];
                data[newstart+1]=data[start];
                data[start]=temp;
            } else{
                if (isEqual) switc = true;
                end--;
                temp = data[end];
                data[end] = data[start];
                data[start] = temp;
                start--;
            }
            start++;
        }
        temp = data[newstart];
        data[newstart]=data[start-1];
        data[start-1] = temp;
        return start-1;
    }
    public static int quickselect(int[] data, int k){
        int start = 0;
        int end = data.length-1;
        while(true){
            int p = partition(data, start, end);
            if (p == k){
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
    public static int partitionDutch(int[] data, int start, int end){
        int mid = (start+end)/2;
        end++;
        int pivot = rand.nextInt((end)-start)+start;
        int temp = data[mid];
        data[mid] = data[pivot];
        data[pivot] = temp;
        int newstart = start;
        start++;
        while(start<end){
            boolean isTall = data[start] < data[newstart];
            boolean isEqual = data[start] == data[newstart];
            if (!isEqual){
                if (isTall){
                    temp = data[newstart+1];
                    data[newstart+1]=data[start];
                    data[start]=temp;
                } else{
                    end--;
                    temp = data[end];
                    data[end] = data[start];
                    data[start] = temp;
                    start--;          
                }
            }
            start++;
        }
        return start-1;
    }
}