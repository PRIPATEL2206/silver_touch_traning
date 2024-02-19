import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class P8 {
    public static void main(String[] args) {
        try {
            FileWriter fw=new FileWriter("abc1.txt");
            int i;
            Scanner sc = new Scanner(System.in);
            
            String s=sc.nextLine();
            fw.write(s);
            fw.close();
            FileReader fr = new FileReader("abc1.txt");
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
            fr.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
