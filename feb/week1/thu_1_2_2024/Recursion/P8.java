import java.util.Scanner;

public class P8 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sumOfN(n));
        sc.close();
    }
    static int  sumOfN(int n){
        if (n==0) {
            return 0;
        }
        return n+sumOfN(n-1);
    }
}
