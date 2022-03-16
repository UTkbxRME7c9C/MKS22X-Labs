import java.util.*;
public class Quick{
    private static Random rand = new Random();
    public static void main(String[] args){
        int [] data = new int[] {7,6,5,4,3,2,1,0};
        System.out.println("Original: "+Arrays.toString(data));
        int pivot = partition(data, 0, 4);
        System.out.println("Pivot value: "+data[pivot]+ ", Pivot index: "+pivot);
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
    /*return the value that is the kth smallest value of the array.
    *@param data must have a length > 0
    *@param k is 0 to data.length-1 inclusive
    *@postcondition The array may be modified. */
        int tempk = data.length-1;
        int a =partition(data, 0, tempk);
        
        return 1;
    }
    public static void quicksort(int[] data){

    }
}