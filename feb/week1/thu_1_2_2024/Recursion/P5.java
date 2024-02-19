import java.util.Scanner;

public class P5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverse(s));
        sc.close();
    }

    static String reverse(String s) {
        if (s.length() == 1) {
            return "" + s.charAt(0);
        }
        return reverse(s.substring(1, s.length())) + s.charAt(0);
    }
}
