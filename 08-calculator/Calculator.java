import java.util.ArrayDeque;

public class Calculator{
    public static double eval(String s){
        ArrayDeque<Double> num = new ArrayDeque<Double>();
        double temp;
        String[] st = s.split(" ");
        for(int i = 0; i<st.length;i++){
            boolean isTooSmall = num.size()<2;
            switch(st[i]){
                case "+":
                    if (isTooSmall) throw new IllegalArgumentException("Too few operands for operation +");
                    num.addFirst(num.removeFirst() + num.removeFirst());
                    break;
                case "*":
                    if (isTooSmall) throw new IllegalArgumentException("Too few operands for operation *");
                    num.addFirst(num.removeFirst() * num.removeFirst());
                    break;
                case "-":
                    if (isTooSmall) throw new IllegalArgumentException("Too few operands for operation -");
                    temp = num.removeFirst();
                    num.addFirst(num.removeFirst() - temp);
                    break;
                case "/":
                    if (isTooSmall) throw new IllegalArgumentException("Too few operands for operation /");
                    temp = num.removeFirst();
                    num.addFirst(num.removeFirst() / temp);
                    break;
                case "%":
                    if (isTooSmall) throw new IllegalArgumentException("Too few operands for operation %");
                    temp = num.removeFirst();
                    num.addFirst(num.removeFirst() % temp);
                    break;
                default:
                    num.addFirst(Double.parseDouble(st[i]));
            }
        }
        if (num.size() > 1) throw new IllegalArgumentException("Too many operands");
        return num.getFirst();
    }
    public static void main(String[] args){

    }
}