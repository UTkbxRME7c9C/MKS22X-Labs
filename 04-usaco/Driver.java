import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args){
        try{
            System.out.println(Bronze.solve(args[0]));
        } catch(FileNotFoundException e){
            System.out.println("no");
        }
    }
}
