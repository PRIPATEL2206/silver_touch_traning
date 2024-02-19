import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(n+" fibonaki is "+ nThFibonacci(n, 0, 1));
        sc.close();
    }
    static int nThFibonacci(int n,int a0,int a1){
        if (n==0|| n==1) {
            return n;
        }
        if (n==2) {
            return a0+a1;
        }
        return nThFibonacci(n-1,a1,a1+a0);
    }
}
