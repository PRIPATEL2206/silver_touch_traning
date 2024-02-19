import java.util.Scanner;

public class P6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (isPalindrom(s)) {
            System.out.println(isPalindrom(s + " is palindrom"));
        } else
            System.out.println(isPalindrom(s + " is palindrom"));
        sc.close();
    }

    static boolean isPalindrom(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        return isPalindrom(s.substring(1, s.length() - 1));
    }
}
