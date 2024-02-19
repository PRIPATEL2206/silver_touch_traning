import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("enter the value of n: ");
        float n=sc.nextFloat();
        float p=sc.nextFloat();
        float r=sc.nextFloat();
        float t=sc.nextFloat();
        System.out.println(compoundInterest(p, r, n, t));
        sc.close();
    }
    static float compoundInterest(float p,float r,float n,float t){
        return p*(float)Math.pow((1+r/n), n*t);
    } 
}
