import java.io.FileReader;

public class P7 {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("abc.txt");
     
                int i;
            while (( i = fr.read()) !=-1) {
                    System.out.print((char)i);
        }
        fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
