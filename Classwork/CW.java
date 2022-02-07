public class CW{
    public static boolean partialSum(int[] arr, int target){
        return partialSum(0,arr,target);
    }
    public static boolean partialSum(int start, int[] arr, int target){
        return true;
    }

    public static String toWords(int n){
        if (n==0) return ones[0];
        String[] place = {"teen", "hundred", "thousand", "million", "billion"};
        String[] ones = {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] tens = {"eleven", "twelve"};
        String[] tennie = {"ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy"};
        String tmp = ""+n;
        String[] num = new String[(tmp.length()/3)+1];
    }

    public static main(String[] args){

    }
}