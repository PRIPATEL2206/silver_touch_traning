import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int i=0;
        int cur=1;
        int prw=1;
        System.out.print(1+" , ");
        do {
            System.out.print(cur+" , ");
            i++;
            int temp=cur;
            cur+=prw;
            prw=temp;
            
        } while (i<n);
        sc.close();
    }
}
