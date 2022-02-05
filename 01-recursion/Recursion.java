public class Recursion{
    public static final char[] a2e = {'a','b','c','d','e'};
    public static final char[] a2c = {'a','b','c'};

    public static void printAllWords(int length){
        printAllWords(length,"");
    }
    public static void printAllWords(int length,String word){
        if (length==0){
            System.out.println(word);
        }else{
            for(char i = 'a';i<'f';i++){
                printAllWords(length-1,word+i);
            }
        }
    }

    public static void printNoDoubleLetterWords(int length,char[] letters){
        printNoDoubleLetterWords(length,"",letters);
    }
    public static void printNoDoubleLetterWords(int length,String word,char[]letters){
        if (length==0){
            boolean t = true;
            for(int i = 0;i<word.length()-1;i++){
                if (word.charAt(i) == word.charAt(i+1)){
                    t = false;
                    break;
                }
            }
            if (t) System.out.println(word);
        }else{
            for(int i = 0;i<letters.length;i++){
                printNoDoubleLetterWords(length-1, word + letters[i], letters);
            }
        }
    }

    public static String reverse(String s){
        if (s.length()==0) return "";
        return reverse(s.substring(1))+s.charAt(0);
    }

    public static double sqrt(int n){
        return sqrt(n,1.0);
    }
    public static double sqrt(int n, double guess){
        double newguess = ((n/guess)+guess)/2;
        if (Math.floor(newguess*100000)/100000 == Math.floor(guess*100000)/100000) return newguess;
        return sqrt(n,newguess);
    }
    public static long count = 0; 
    public static long countNoDoubleLetterWords(int length,String word){ 
        if (length==0){
            boolean t = true;
            String s = "";
            for(int i = 0;i<word.length();i++){
                s += 'a';
            }
            if (word.equals(s)) count=0;
            for(int i = 0;i<word.length()-1;i++){
                if (word.charAt(i) == word.charAt(i+1)){
                    t = false;
                    break;
                }
            }
            if (t) count++;
        }else{
            for(char i = 'a';i<'z'+1;i++){
                countNoDoubleLetterWords(length-1, word+i);
            }
        }
    return count;
    }

    public static int fibIter(int n, int f1, int f2){
        if (n==0) return f2;
        return fibIter(n-1,f1+f2,f1);
    }

    public static void main(String[] args){
        System.out.println(fibIter(0,1,0));
        System.out.println(fibIter(1,1,0));
        System.out.println(fibIter(2,1,0));
        System.out.println(fibIter(3,1,0));

    }

}
