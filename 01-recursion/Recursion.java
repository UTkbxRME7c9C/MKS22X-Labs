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
            for(int i = 0;i<a2e.length;i++){
                printAllWords(length-1,word+a2e[i]);
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
    public static void main(String[] args){
        printNoDoubleLetterWords(3, "", a2c);
    }
}
