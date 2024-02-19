import java.util.Scanner;

public class P5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            int a=12;
            String s=sc.nextLine();
            int b=a/Integer.parseInt(s);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
