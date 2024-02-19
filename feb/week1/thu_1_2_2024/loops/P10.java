import java.util.Scanner;

public class P10 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        
        int gcd=1;
        while (a>0 && b>0) {
            if (a<b) {
                int t=a;
                a=b;
                b=t;
                continue;
            }
            if (a%b==0) {
                gcd=b;
                break;
            }
            int t=a%b;
            a=b;
            b=t;
        }
        System.out.println("Gcd of "+a+" and "+b +" is "+gcd);
        sc.close();
    }
}
