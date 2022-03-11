import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args){
        try{
            Bronze.solve("makelake.in");
        } catch(FileNotFoundException e){
            System.out.println("no");
        }
    }
}
