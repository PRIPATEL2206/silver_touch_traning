import java.util.Scanner;

public class P5 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int i=2;
        do {
            if( n%i==0 ){
                break;
            }
            i++;
        } while (i<=n/2);
        if (i>n/2) 
            System.err.println(n+" is prime number");
        
        else
            System.err.println(n+" is prime not number");

        sc.close();
    }

}