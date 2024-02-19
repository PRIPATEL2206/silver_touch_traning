import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverseString="";
        int n=s.length();
        
        System.out.print("string ");
        for (int i = 0; i < n; i++) {
            System.out.print(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            reverseString+=s.charAt(n-i-1);
        }
        System.out.print("revers string :");
        for (int i = 0; i < n; i++) {
            System.out.print(reverseString.charAt(i));
        }

        sc.close();
    }
}
