import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
public class maze{
    public static int printline(String filename) throws FileNotFoundException{
        File fil = new File(filename);
        Scanner input = new Scanner(fil);
        String c = "";
        int tol = 0;
        while(input.hasNextLine());
            c+=input.nextInt();
            tol++;
        input.close();
        return tol;
    }
    public static void main(String[] args){
        try {
            System.out.println(printline("maze"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}