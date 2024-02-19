import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            boolean isAlreadyIn = false;
            for (int j = 0; j < ans.length(); j++) {
                if (ans.charAt(j) == s.charAt(i)) {
                    isAlreadyIn = true;
                }
            }
            if (!isAlreadyIn) {
                ans += s.charAt(i);
            }
        }
        System.out.println("string after removeing duplicates is : "+ ans);

        sc.close();
    }
}
