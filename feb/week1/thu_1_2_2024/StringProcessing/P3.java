import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n=s.length();
        boolean isPalindrome=true;

        for (int i = 0; i < n/2; i++) {
            if (s.charAt(i)!=s.charAt(n-i-1)) {
                isPalindrome=false;
                break;
            }
        }
        if (isPalindrome) {
            System.err.println("String is palindrome");
        }
        else{
            System.err.println("String is not palindrome");

        }
        sc.close();
    }
}
