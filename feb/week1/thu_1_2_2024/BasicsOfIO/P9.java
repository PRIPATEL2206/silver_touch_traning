import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P9 {
    public static void main(String[] args) {
       try {
        Scanner sc = new Scanner(new File("abc.csv"));
        sc.useDelimiter(",");
        while (sc.hasNext()) {
            System.out.print(sc.next());
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
       
        
    }
}
