import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int fact=1;
        for (int i = 2; i <= n; i++) {
            fact*=i;
        }
        System.out.println(fact);
        sc.close();
    }    
}
