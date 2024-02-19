import java.util.Scanner;

public class P7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(gcd(a,b));
        sc.close();
    }
    static int gcd(int a,int b){
        if (a<b) {
            return gcd(b, a);
        }
        if (a%b==0) {
            return b;
        }
        return gcd(b, a%b);
    }
}
