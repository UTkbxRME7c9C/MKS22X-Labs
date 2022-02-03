public class Recursion{
    public static final char[] a2e = {'a','b','c','d','e'};
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
        /*Print all words that are made of the characters in the array of letters.
    *There may not be consecutive equal letters, so:
    *aax is not allowed, but axa is allowed.
    *@param length : the length of the words that are to be printed
    *@param letters: the letters you should be using,
    *@precondition: letters contains at least 2 characters, and has no duplicates.
    */
    public static void printNoDoubleLetterWords(int length,char[] letters){
        printNoDoubleLetterWords(length,"",letters);
    }

    /*Print all words that are made of the characters in letters. There may not be consecutive equal letters,
    *aax is not allowed, but axa is allowed.
    *@param length : either how many more letters need to be
    *@param word   : the partial word so far.
    *@param letters: the letters you should be using
    */
    public static void printNoDoubleLetterWords(int length,String word,char[]letters){
        //WRITE THIS METHOD
    }
    public static void main(String[] args){
        printAllWords(3);
    }
}
