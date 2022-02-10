public class CW{
    public static String toWords(int n){
        if (n==0) return "zero";
        String[] place = {"hundred", "thousand", "million", "billion",};
        String[] ones = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] tens = {"eleven", "twelve", "thirteen" ,"fourteen" ,"fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
        String[] tennie = {"ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String tmp = ""+Math.abs(n);
        String[] num;
        if (tmp.length()%3==0){
            num = new String[(tmp.length()/3)];
        } else {num = new String[(tmp.length()/3)+1];}
        for (int i = num.length-1;i>=0;i--){
            if(tmp.length()>3){
                num[i]=tmp.substring(tmp.length()-3);
                tmp = tmp.substring (0,tmp.length()-3);
            } else {num[i]=tmp;}
        }
        if (n<0){tmp="negative ";} else {tmp="";}
        return tmp;
    }

    public static void main(String[] args){

    }
}