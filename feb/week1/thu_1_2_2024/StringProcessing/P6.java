import java.util.Scanner;

public class P6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        String ans="";
        for (String i:s) {
            if (ans.length()<i.length()) {
                ans=i;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
