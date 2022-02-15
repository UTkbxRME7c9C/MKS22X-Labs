import java.util.Scanner;
import java.util.Random;
public class Text{
    private static Random rand = new Random();
    private static int seed = rand.nextInt();
    private static boolean isEmpty = false;
  /*Base colors*/
    public static final int BLACK = 30;
    public static final int RED = 31;
    public static final int GREEN = 32;
    public static final int YELLOW = 33;
    public static final int BLUE = 34;
    public static final int MAGENTA = 35;
    public static final int CYAN = 36;
    public static final int WHITE = 37;

    public static final String CLEAR_SCREEN =  "\033[2J";
    public static final String HIDE_CURSOR =  "\033[?25l";
    public static final String SHOW_CURSOR =  "\033[?25h";
    public static final String RESET = "\033[0m"+SHOW_CURSOR;

    public static final int BACKGROUND = 10;
    public static final int BRIGHT = 60;
  
    public static final int BOLD = 1;
    public static final int UNDERLINE = 4;
    public static final int INVERTED = 7;
  
    /*Reset colors*/
    public static void reset(){
      System.out.print("\u001b[0m");
    }
  
  
    public static void hideCursor(){
      System.out.print("\u001b[?25l");
    }
  
    public static void showCursor(){
      System.out.print("\u001b[?25h");
    }
  
    /*Move the cursor to a specified row/col on the terminal*/
    public static void go(int row,int col){
        System.out.print("\u001b[" + row + ";" + col + "f");
    }
  
    /*Erases all text on the terminal.*/
    public static void clear(){
      System.out.print("\u001b[2J");
    }
  
    /*Overloaded Colorize methods.
      c1,c2 and c3 are any color modifiers such as bold/color/background color etc.
    */
    public static String colorize(String text,int c1){
      return ("\u001b[" + c1 + "m"+text+"\u001b[0m");
    }
    public static String colorize(String text,int c1,int c2){
      return ("\u001b[" + c1 + ";" + c2 + "m"+text+"\u001b[0m");
    }
    public static String colorize(String text,int c1,int c2,int c3){
      return ("\u001b[" + c1 + ";" + c2 + ";" + c3 + "m"+text+"\u001b[0m");
    }
  
    public static void border(int w, int h, int bordercol, int textcol){
      bordercol += BACKGROUND;
      go(1,1);
      for(int i = 1;i<=w;i++){
        System.out.print(colorize("-",bordercol,textcol));
      } 
      for(int i = 1;i<=h;i++){
        go(i,1);
        System.out.print(colorize("|",bordercol,textcol));
        go(i,w);
        System.out.print(colorize("|",bordercol,textcol));
      } 
      go(h,1);
      for(int i = 1;i<=w;i++){
        System.out.print(colorize("-",bordercol,textcol));
      }    
      go(1,1);System.out.print(colorize("*",bordercol,textcol));
      go(h,1);System.out.print(colorize("*",bordercol,textcol));
      go(1,w);System.out.print(colorize("*",bordercol,textcol));
      go(h,w);System.out.print(colorize("*",bordercol,textcol));
      go(h+1,0);
    }

    private static void randary(boolean newseed, int w){// for testing only
      Random newrand;
      if (newseed){
        newrand = new Random(seed);
      }else{
        seed = rand.nextInt();
        newrand = new Random(seed);
      }
      int[] randum = {newrand.nextInt(100),newrand.nextInt(100),newrand.nextInt(100),newrand.nextInt(100)};
      for(int i = 0;i<4;i++){
        int space = (((w/4)*(i))+2);
        go(2,space);
        if (randum[i] <= 25){
          System.out.println(colorize(Integer.toString(randum[i]),RED));
        }else if (randum[i] >= 75){
          System.out.println(colorize(Integer.toString(randum[i]),GREEN));
        }else{
          System.out.println(colorize(Integer.toString(randum[i]),WHITE));
        }
      }
    }
    public static void wait(int millis){
      try {
        Thread.sleep(millis);
      }
      catch (InterruptedException e) {
      }
    }
    //Tested and working in:
    //git-bash (windows 10),    wsl (windows 10+11),   powershell windows 11
    public static void main(String[] args) { // for testing only
      hideCursor();
      clear();
      if (isEmpty){
        randary(true, 80);
        isEmpty = false;
      } else {randary(false, 80);}
      border(80,30, BLUE, BLACK);
      go(31,0);
      System.out.print(">");
      Scanner a = new Scanner(System.in);
      String b = a.nextLine();
      if (b.equals("q") || b.equals("quit")){
        reset();
        showCursor();
        a.close();
      } else if (b.equals("")){
        isEmpty = true;
        main(null);
      } else {
        main(null);
      }
    }

  }