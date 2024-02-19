import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("sun of "+n+" is "+sumOfDigit(n));
        sc.close();
    }
    static int  sumOfDigit(int n){
        if (n==0) {
            return 0;
        }
        return n%10 + sumOfDigit(n/10);
    }
}