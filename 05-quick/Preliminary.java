import java.util.*;
public class Preliminary{
    private static Random rand = new Random();
    public static void main(String[] args){
        int [] data = new int[] {4,3,2,1,0};
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
            if (data[start] < data[0]){
                temp = data[1];
                data[1]=data[start];
                data[start]=temp;
            } else if (data[start] > data[0]){
                end-=1;
                temp = data[end];
                data[end] = data[start];
                data[start] = temp;
                start--;
            } else{
                if (switc){
                    switc = false;
                    temp = data[1];
                    data[1]=data[start];
                    data[start]=temp;
                } else{
                    switc = true;
                    end-=1;
                    temp = data[end];
                    data[end] = data[start];
                    data[start] = temp;
                    start--;
                }
            }
            start++;
        }
        temp = data[0];
        data[0]=data[start-1];
        data[start-1] = temp;
        return start-1;
    }
}