import java.util.Arrays;
public class Merge{
    public static void main(String[] args){
        int[] a = {5,4,3,2,1,0};
        int[] b = {0,1,1,2,2,2,6};
        int[] data = {17, 17, 61, 67, 47, 93, 12, 20, 4, 44, 68, 61, 67, 47, 93,12, 20, 4, 44, 68} ;
        System.out.println(Arrays.toString(mergesortH(data)));
    }
    public static int [] merge(int [] left, int[] right){
        int[] merged = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        for(int a = 0; a< merged.length;a++){
            if (i<left.length && j < right.length){
                if (left[i] < right[j]){
                    merged[a] = left[i];
                    i++;
                } else{
                    merged[a] = right[j];
                    j++;
                }
            } else if (i< left.length){
                merged[a] = left[i];
                i++;
            } else if (j< right.length){
                merged[a] = right[j];
                j++;
            }
        }
        return merged;
    }

    public static void mergesort(int [] data){
        int [] temp  =  mergesortH(data);
        for (int i =0;i<data.length;i++){
            data[i] = temp[i];
        }
    }

    public static int[] mergesortH(int [] data){
        if (data.length > 1){
            int mid = (data.length)/2;
            int[] left = Arrays.copyOfRange(data, 0, mid);
            int[] right = Arrays.copyOfRange(data, mid, data.length);
            return merge(mergesortH(left), mergesortH(right));
        }else{
            return data;
        }
    }
}