import java.util.ArrayDeque;

public class Calculator{
    public static double eval(String s){
        ArrayDeque<Double> num = new ArrayDeque<Double>();
        for(int i = 0; i<s.length();i++){

        }
        if (num.size() > 1){
            throw new IllegalArgumentException("Too many operands");
        }return num.getFirst();
    }
}